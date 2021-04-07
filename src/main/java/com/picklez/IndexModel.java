/*
This file is a part of the Search Engine project for COP2805C
This project was created by Lynx Leuck, Ulas Koca, and Matthew Maynard
For more information view README.md
 */
package com.picklez;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Class now extends DefaultTableModel as originally designed
public class IndexModel extends DefaultTableModel implements Serializable {

    @Serial
    private final static long serialVersionUID = -5893562234839116493L;
    private final static String filePath = System.getProperty("user.home") + "\\index.json";
    private final static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation() // Ensure only desired fields are persisted
            .setPrettyPrinting()
            .serializeNulls()
            .create();
    @SerializedName("Team Name")
    @Expose
    private String teamName;
    @SerializedName("Version")
    @Expose
    private float version;
    @SerializedName("Index UID")
    @Expose
    private int indexUID;
    @SerializedName("File List")
    @Expose
    private List<FileItem> fileList;
    @SerializedName("Word List")
    @Expose
    private List<WordItem> wordList;
    public List<WordItem> getWordList() {
        return wordList;
    }
    /**
     * No args constructor for use in serialization
     */
    public IndexModel() {
        // Table settings moved from SearchEngineMaintenance
        addColumn("File Name");
        addColumn("Status");
        this.teamName = "Picklez";
        this.version = 1;
        this.indexUID = 0;
        this.fileList = new ArrayList<FileItem>();
        this.wordList = new ArrayList<WordItem>();


    }

    /**
     * @param teamName Name of the team that created this application
     * @param fileList List of files that are contained in the Index
     * @param version  Current version number of the application
     * @param indexUID Unique ID for files in the Index
     */
    public IndexModel(String teamName, float version, int indexUID, List<FileItem> fileList, List<WordItem> wordList) {
        super();
        this.teamName = teamName;
        this.version = version;
        this.indexUID = indexUID;
        this.fileList = fileList;
        this.wordList = wordList;
    }

    public IndexModel getModel() throws IOException {
        File file = new File(filePath);  // Replaced hardcoded value

        if (!file.isFile() && !file.createNewFile()) {

            throw new IOException("Error creating new file: " + file.getAbsolutePath());
        }


        BufferedReader r = new BufferedReader(new FileReader(file));
        return gson.fromJson(r, IndexModel.class);
    }
    public void getTableModel(){
        try {
            getModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(FileItem file1: fileList){
            super.insertRow(0,new String[]{file1.getName(),"Indexed"});
        }


    }

    // Save index to file
    public static void saveIndex(IndexModel index) {
        Writer writer;
        // Unsure if try/catch is best here or if exception should just get thrown up
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            gson.toJson(index, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public List<FileItem> getFileList() {
        return fileList;
    }

    public void setFileList(List<FileItem> fileList) {
        this.fileList = fileList;
    }

    public int getIndexUID() {
        return indexUID;
    }

    public void setIndexUID(int indexUID) {
        this.indexUID = indexUID;
    }

    //adds a new file item to the list
    public void addFile(FileItem file) {
        /* Process file words into gson */

        if (fileList == null) {
            setTeamName("Picklez");
            setVersion(1);
            this.fileList.add(file);
            try {
                saveIndex(getModel());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            fileList.add(file);
            Set<WordItem> hSet = new HashSet<>(wordList);
            hSet.addAll(wordList);
            wordList.clear();
            wordList.addAll(hSet);


        }

    }

    public void removeFile() {
        //Removes item from list
    }

    public void updateList() {
        //Refreshes the words on the list
        //Has to determine the last time updated and compare to current time
        //https://mkyong.com/java/how-to-get-the-file-last-modified-date-in-java/
    }

    // Moved from SearchEngineMaintenance
    @Override
    public boolean isCellEditable(int row, int column) {
        // All cells false
        return false;
    }
}
