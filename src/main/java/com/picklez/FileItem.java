package com.picklez;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public class FileItem implements Serializable, Comparable<FileItem>
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastUpdate")
    @Expose
    private int lastUpdate;
    @SerializedName("words")
    @Expose
    private List<String> words = null;
    @Serial
    private final static long serialVersionUID = -6183808971942914447L;

    /**
     * No args constructor for use in serialization
     *
     */
    public FileItem() {
    }

    /**
     *
     * @param path
     * @param lastUpdate
     * @param name
     * @param words
     * @param id
     */
    public FileItem(int id, String path, String name, int lastUpdate, List<String> words) {
        super();
        this.id = id;
        this.path = path;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.words = words;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(int lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    /**
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(@NotNull FileItem o) {
        return this.id - o.id;
    }
}