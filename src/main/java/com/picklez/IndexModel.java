/*
This file is a part of the Search Engine project for COP2805C
This project was created by Lynx Leuck, Ulas Koca, and Matthew Maynard
For more information view README.md
 */
package com.picklez;

import java.io.*;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndexModel implements Serializable
{

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
    @Serial
    private final static long serialVersionUID = -5893562234839116493L;
    private final static String filePath = System.getProperty("user.home") + "\\index.json";
    private final static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .create();


    /**
     * No args constructor for use in serialization
     *
     */
    public IndexModel() {
    }

    /**
     *
     * @param teamName
     * @param fileList
     * @param version
     * @param indexUID
     */
    public IndexModel(String teamName, float version, int indexUID, List<FileItem> fileList) {
        super();
        this.teamName = teamName;
        this.version = version;
        this.indexUID = indexUID;
        this.fileList = fileList;
    }

    public static IndexModel getModel() throws IOException {
        File file = new File(System.getProperty("user.home") , "\\index.json");

        if (!file.isFile() && !file.createNewFile())
        {
            throw new IOException("Error creating new file: " + file.getAbsolutePath());
        }

        BufferedReader r = new BufferedReader(new FileReader(file));

        return gson.fromJson(r, IndexModel.class);
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

    //adds a new file item to the list
    public void addFile(FileItem file){
        /* Process file words into gson */
        if(fileList == null) {
            setTeamName("Picklez");
            setVersion(1);
            this.fileList.add(file);
            try {
                saveIndex(getModel());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
        fileList.add(file);
        }

    }

    public void removeFile(){
        //Removes item from list
    }

    public void updateList(){
        //Refreshes the words on the list
        //Has to determine the last time updated and compare to current time
        //https://mkyong.com/java/how-to-get-the-file-last-modified-date-in-java/
    }
}
