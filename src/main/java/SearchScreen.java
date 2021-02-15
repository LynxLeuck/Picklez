/*
This Class sets up the GUI for the Search Screen
 */

import javax.swing.*;

public class SearchScreen extends JFrame{
    private JButton aboutButton;
    private JButton maintenanceButton;
    private JTextArea searchResults;
    private JButton searchButton;
    private JTextField searchRequest;
    private JRadioButton allOfTheSearchRadioButton;
    private JRadioButton anyOfTheSearchRadioButton;
    private JRadioButton exactTermsRadioButton;
    private JPanel Main;
    private JLabel labelNumberOfFilesIndexed;


    //Builds and sets up the Search Screen
    public SearchScreen() {

        //Initial Set up of the Screen
        super("Search Engine Maintenance");
        this.setContentPane(this.Main);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(700, 800);
        this.searchResults.setEditable(false);

        //Adds Buttons
        aboutButton.addActionListener(e -> {

        });
        searchButton.addActionListener(e -> {
        });

        //All Three of these radials ensure that none of the others are selected
        allOfTheSearchRadioButton.addActionListener(e -> {
            anyOfTheSearchRadioButton.setSelected(false);
            exactTermsRadioButton.setSelected(false);
        });
        anyOfTheSearchRadioButton.addActionListener(e -> {
            allOfTheSearchRadioButton.setSelected(false);
            exactTermsRadioButton.setSelected(false);
        });
        exactTermsRadioButton.addActionListener(e -> {
            anyOfTheSearchRadioButton.setSelected(false);
            allOfTheSearchRadioButton.setSelected(false);
        });

    }

    public void setSearchResults(JTextArea searchResults) {
        this.searchResults = searchResults;
    }


}
