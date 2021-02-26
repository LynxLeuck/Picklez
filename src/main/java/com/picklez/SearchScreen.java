package com.picklez;// Set up the GUI for the com.picklez.Main search screen

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchScreen extends JFrame {
    private JButton maintenanceButton;
    private JButton aboutButton;
    private JLabel filesIndexedLabel;
    private JLabel programNameLabel;
    private JLabel searchTermsLabel;
    private JTextField searchTerms;
    private JButton searchButton;
    private JRadioButton searchOption1;
    private JRadioButton searchOption2;
    private JRadioButton searchOption3;
    private JPanel mainPanel;
    private SearchEngineMaintenance searchEngineMaintenance = new SearchEngineMaintenance();

    public SearchScreen() {
        add(mainPanel);
        setTitle("Search Engine");
        setSize(780, 525);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        maintenanceButton.addActionListener(e -> searchEngineMaintenance.setVisible(true));
        aboutButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Hello world!", "About Search Engine", JOptionPane.PLAIN_MESSAGE);
        });
    }
}
