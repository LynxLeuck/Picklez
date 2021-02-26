package com.picklez;/*
This Class sets up the GUI for the Search Screen
 */


import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;


public class SearchEngineMaintenance extends JFrame {

    //List of files on For the Database to search can be get or set
    private ArrayList<File>[] fileList;
    private  String[] columns = new String[] {
            "File Name", "Status"
    };
    private Object[][] data = new Object[][] {
            {1, "John"},
            {2, "Rambo"},
            {3, "Zorro"},
    };

    //These private variables are used by the GUI editor on IntelliJ IDEA Editor
    private TableModel model;
    private JTable fileListTable = new JTable(data,columns);
    private JScrollPane fileHolderPanel;
    private JButton rebuildBtn;
    private JButton removeSelectedFilesButton;
    private JButton addFileBtn;
    private JPanel Main;
    private JButton resetWindowsButton;
    private JPanel bottomOptions;
    private JPanel fileListSettingsPanel;
    private JLabel labelNumberOfFilesIndexed;
    private JLabel labelSearchEngineVersion;

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
        super("Search Engine Maintenance");
        this.setContentPane(this.Main);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.pack();
        this.setSize(700, 800);


        this.fileHolderPanel.setViewportView(fileListTable);


        //This button re-builds the list the array of files if any were added or removed from the file list
        rebuildBtn.addActionListener(e -> {
        });

        //This button will open the file selector then add the file to the file list
        addFileBtn.addActionListener(e -> {

        });

        //This button removes a file from the file list then reloads the list
        removeSelectedFilesButton.addActionListener(e -> {
        });


    }

    //Getter and setter for the List to allow it to grow
    public ArrayList[] getFileList() {
        return fileList;
    }

    public void setFileList(ArrayList[] fileList) {
        this.fileList = fileList;
    }

    //Getter and setter for JTable to allow it to grow
    public JTable getFileListTable() {
        return fileListTable;
    }


    public void setFileListTable(JTable fileListTable) {
        this.fileListTable = fileListTable;
    }


}

