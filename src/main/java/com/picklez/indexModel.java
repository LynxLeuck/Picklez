package com.picklez;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class indexModel extends AbstractTableModel {
    private String[] columnNames = new String[]{"File Name","Status"};
    private static indexModel model = null;
    static List<FileItem> fileList = new ArrayList();

    indexModel(){
        model = this;
        //Load in index
    }

    public static indexModel getModel() {
        //ensures there is a model
        if (model == null) {
            model = new indexModel();
        }
        return model;
    }
    public void addFile(){
        //Process file words into gson
    }
    public void removeFile(){
        //Removes item from list
    }
    public void updateList(){
        //Refreshes the words on the list
        //Has to determine the last time updated and compare to current time
        //https://mkyong.com/java/how-to-get-the-file-last-modified-date-in-java/

    }
    private void saveIndex(){
        //saving json formatted file using gson

    }
    public void getFileList(){
        //Builds list from memory

    }


    /**
     * Returns the number of rows in the model. A
     * <code>JTable</code> uses this method to determine how many rows it
     * should display.  This method should be quick, as it
     * is called frequently during rendering.
     *
     * @return the number of rows in the model
     * @see #getColumnCount
     */
    @Override
    public int getRowCount() {
        return fileList.size();
    }

    /**
     * Returns the number of columns in the model. A
     * <code>JTable</code> uses this method to determine how many columns it
     * should create and display by default.
     *
     * @return the number of columns in the model
     * @see #getRowCount
     */
    @Override
    public int getColumnCount() {
        return 2;
    }

    /**
     * Returns the value for the cell at <code>columnIndex</code> and
     * <code>rowIndex</code>.
     *
     * @param rowIndex    the row whose value is to be queried
     * @param columnIndex the column whose value is to be queried
     * @return the value Object at the specified cell
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
