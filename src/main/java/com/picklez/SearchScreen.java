package com.picklez;

import javax.swing.*;
import java.awt.*;

public class SearchScreen extends JFrame {

    private JLabel lblTitle;
    private JTextField inputText;
    private JTextArea resultsTextArea;
    private JButton searchButton;
    private JButton maintenanceButton;
    private JButton aboutButton;
    private JLabel searchTermsLabel;
    private JLabel numberOfFilesLabel;
    private JPanel mainPanel;

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
        setVisible(true);
    }
}
