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
    }


    public static indexModel getModel() {
        //ensures there is a model
        if (model == null) {
            model = new indexModel();
        }
        return model;
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
