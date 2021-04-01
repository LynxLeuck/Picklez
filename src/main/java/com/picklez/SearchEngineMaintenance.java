package com.picklez;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchEngineMaintenance extends JFrame {

    private IndexModel model;
    private JPanel maintenancePanel;
    private JLabel searchEngineMaintenanceLabel;
    private JTable indexTable;
    private JButton addFileButton;
    private JButton rebuildOutOfDateButton;
    private JButton removeSelectedFilesButton;
    private JLabel numberOfFilesIndexedLabel;
    private JScrollPane indexScrollPane;

    /**
     * Constructs a new frame
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public SearchEngineMaintenance() throws HeadlessException {

        model = new IndexModel();


        try {
            model.getModel();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Set up GUI
        add(maintenancePanel);
        setTitle("Search Engine Maintenance");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);

        // Set up table model and add to table

        if(model.getTeamName() == null){
            model.setTeamName("Picklez");
            model.setVersion(1);
        }

        indexTable.setModel(model);


        // Add files to the table on this form
        addFileButton.addActionListener(e -> {
            FileDialog fd = new FileDialog((Dialog) null, "Select file", FileDialog.LOAD);
            fd.setVisible(true);
            String filePath = fd.getDirectory() + fd.getFile();
            //Creates a file object from the FileDialog to be able to process
            File file = new File(fd.getDirectory() + fd.getFile());
            model.insertRow(0, new String[]{filePath, "Not indexed"});
            fileHandler(file);
            IndexModel.saveIndex(model);


        });

        // Remove the selected row from the table
        removeSelectedFilesButton.addActionListener(e -> model.removeRow(indexTable.getSelectedRow()));
    }
    public void fileHandler(File fd ) {
        //Read data for file to add to the File Item and indexModel

        //builds file basic's
        int id = 0;
        String path = fd.getAbsolutePath();
        String name = fd.getName();
        int lastUpdate = (int) fd.lastModified();
        String wordList = null;
        List<String> words = null;

        //reads the file and splits it into a List of words
        try {
            Scanner myReader = new Scanner(fd);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                wordList = wordList + " " + data;
            }
            words = Arrays.asList(wordList.split(" "));
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        FileItem fileItem = new FileItem(id, path, name, lastUpdate, words);
            model.addFile(fileItem);

    }

}
