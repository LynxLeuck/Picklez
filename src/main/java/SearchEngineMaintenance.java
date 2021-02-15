/*
This Class sets up the GUI for the Search Screen
 */
import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.util.ArrayList;


public class SearchEngineMaintenance extends JFrame {

    //List of files on For the Database to search can be get or set
    private ArrayList<File>[] fileList;

    //These private variables are used by the GUI editor on IntelliJ IDEA Editor
    private JFrame frame;
    private TableModel model;
    private JTable fileListTable;
    private JButton rebuildBtn;
    private JButton removeSelectedFilesButton;
    private JButton addFileBtn;
    private JPanel Main;
    private JButton resetWindowsButton;
    private JPanel bottomOptions;
    private JScrollPane fileHolderPanel;
    private JPanel fileListSettingsPanel;
    private JLabel labelNumberOfFilesIndexed;
    private JLabel labelSearchEngineVersion;

    //Builds and sets up Gui
    public SearchEngineMaintenance() {
        super("Search Engine Maintenance");
        this.setContentPane(this.Main);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.pack();
        this.setSize(700, 800);

        //This button re-builds the list the array of files if any were added or removed from the file list
        rebuildBtn.addActionListener(e -> {
        });

        //This button will open the file selector then add the file to the file list
        addFileBtn.addActionListener(e -> {
            File file = FileBrowser.fileSelector();
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
