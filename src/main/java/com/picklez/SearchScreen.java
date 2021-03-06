/*
This file is a part of the Search Engine project for COP2805C
This project was created by Lynx Leuck, Ulas Koca, and Matthew Maynard
For more information view README.md
 */
package com.picklez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class SearchScreen extends JFrame {
    private IndexModel model;
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
    private String searchType;

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

        ANDRadioButton.setActionCommand("AND");
        ANDRadioButton.addActionListener(this::actionPerformed);
        ORRadioButton.setActionCommand("OR");
        ORRadioButton.addActionListener(this::actionPerformed);
        EXACTRadioButton.setActionCommand("EXACT");
        EXACTRadioButton.addActionListener(this::actionPerformed);

        // Displays basic information about the program
        aboutButton.addActionListener(e -> JOptionPane.showConfirmDialog(mainPanel, """
                Search Engine v1.0
                Written by Team Picklez
                Brought to you by pickle.jar""", "Search Engine", JOptionPane.DEFAULT_OPTION)
        );

        maintenanceButton.addActionListener(e -> new SearchEngineMaintenance());
        searchButton.addActionListener(e -> search());
    }

    // Sets the search type when a radio button is clicked
    public void actionPerformed(ActionEvent e) {
        searchType = e.getActionCommand();
    }

    // Method executed by search button
    // Stub data inserted for now
    private void search() {

        model = new IndexModel();
        try {
            model.getModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.getWordList();
        resultsTextArea.setText(String.format("""
            Search function not yet implemented.
            
            Search type selected: %s""", searchType));
    }

}
