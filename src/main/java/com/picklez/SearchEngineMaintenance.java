package com.picklez;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SearchEngineMaintenance extends JFrame {

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

        // Set up GUI
        add(maintenancePanel);
        setTitle("Search Engine Maintenance");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);

        // Set up table model and add to table
        DefaultTableModel tableModel = new DefaultTableModel(){

            @Override
            public boolean isCellEditable(int row, int column) {
                // All cells false
                return false;
            }

        };

        indexTable.setModel(tableModel);
        tableModel.addColumn("File Name");
        tableModel.addColumn("Status");

        // Add files to the table on this form
        addFileButton.addActionListener(e -> {
            FileDialog fd = new FileDialog((Dialog) null, "Select file", FileDialog.LOAD);
            fd.setVisible(true);
            String filePath = fd.getDirectory() + fd.getFile();
            //Builds the table model and FileItem Object
            fileHandler(fd);

            tableModel.insertRow(0, new String[]{filePath, "Not indexed"});
        });

        // Remove the selected row from the table
        removeSelectedFilesButton.addActionListener(e -> tableModel.removeRow(indexTable.getSelectedRow()));
    }
    public static void fileHandler(FileDialog fd ){
        //Read data for file to add to the File Item and indexModel

    }

}
