package com.picklez;

import javax.swing.*;

public class SearchEngineMaintenance extends JFrame {
    private JLabel windowNameLabel;
    private JTable fileTable;
    private JButton addFileButton;
    private JButton outOfDateButton;
    private JButton removeSelectedFilesButton;
    private JButton resetWindowsButton;
    private JLabel versionLabel;
    private JLabel filesIndexedLabel;
    private JPanel maintananceWindow;

    public SearchEngineMaintenance() {
        add(maintananceWindow);
        setTitle("Search Engine Maintanance");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
