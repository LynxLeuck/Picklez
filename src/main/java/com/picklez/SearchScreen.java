package com.picklez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchScreen extends JFrame {

    private JLabel titleLabel;
    private JTextField inputText;
    private JTextArea resultsTextArea;
    private JButton searchButton;
    private JButton maintenanceButton;
    private JButton aboutButton;
    private JLabel searchTermsLabel;
    private JLabel numberOfFilesLabel;
    private JPanel mainPanel;
    JRadioButton ANDRadioButton;
    JRadioButton ORRadioButton;
    JRadioButton EXACTRadioButton;

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
    public SearchScreen() throws HeadlessException {

        add(mainPanel);
        setTitle("Search Engine");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        aboutButton.addActionListener(e -> JOptionPane.showConfirmDialog(mainPanel, """
                Search Engine v1.0
                Written by Team Picklez
                Brought to you by pickle.jar""", "Search Engine", JOptionPane.DEFAULT_OPTION)
        );

        maintenanceButton.addActionListener(e -> new SearchEngineMaintenance());
        searchButton.addActionListener(e -> search());
    }

    private void search() {
    }

}
