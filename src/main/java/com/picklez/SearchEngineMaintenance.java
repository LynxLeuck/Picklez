/*
This file is a part of the Search Engine project for COP2805C
This project was created by Lynx Leuck, Ulas Koca, and Matthew Maynard
For more information view README.md
 */
package com.picklez;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchEngineMaintenance extends JFrame {

    private final IndexModel model;
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

        if (model != null) {
            model.setTeamName("Picklez");
            model.setVersion(1);
        }

        indexTable.setModel(model);
        model.getTableModel();
        // Add files to the table on this form
        addFileButton.addActionListener(e -> {
            FileDialog fd = new FileDialog((Dialog) null, "Select file", FileDialog.LOAD);
            fd.setVisible(true);
            String filePath = fd.getDirectory() + fd.getFile();
            //Creates a file object from the FileDialog to be able to process
            File file = new File(fd.getDirectory() + fd.getFile());
            model.insertRow(0, new String[]{filePath, "Indexed"});
            fileHandler(file);
            IndexModel.saveIndex(model);

        });

        // Remove the selected row from the table
        removeSelectedFilesButton.addActionListener(e -> model.removeRow(indexTable.getSelectedRow()));
    }

    public void fileHandler(File fd) {
        //Read data for file to add to the File Item and indexModel

        //builds file basic's
        int id = 0;
        String path = fd.getAbsolutePath();
        String name = fd.getName();
        int lastUpdate = (int) fd.lastModified();
        String words = "";
        List<WordItem> convertedWordList = new ArrayList<WordItem>();
        int wordPosition = 0;

        FileItem fileItem = new FileItem(model.getIndexUID(), path, name, lastUpdate, convertedWordList);
        //reads the file and splits it into a List of wordList
        try {
            Scanner myReader = new Scanner(fd);
            while (myReader.hasNext()) {
                String data = myReader.next();

                if (data != null) {
                    if (words != "") {
                        words = words + " " + data.replace("[^a-zA-Z0-9]", "");
                    } else {
                        words = data.replace("[^a-zA-Z0-9]", "");
                    }
                    convertedWordList.add(new WordItem(data, fileItem.getId(), wordPosition));
                    wordPosition++;
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        fileItem.setWords(convertedWordList);
        model.addFile(fileItem);
        model.setIndexUID(model.getIndexUID() + 1);

    }

}
