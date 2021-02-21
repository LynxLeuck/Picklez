package com.picklez;

import javax.swing.*;
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

        add(maintenancePanel);
        setTitle("Search Engine Maintenance");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);

    }

}
