// Set up the GUI for the main search screen

import javax.swing.*;

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

    public SearchScreen() {
        add(mainPanel);
        setTitle("Search Engine");
        setSize(780, 525);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
