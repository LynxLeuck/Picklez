/*
This file is a part of the Search Engine project for COP2805C
This project was created by Lynx Leuck, Ulas Koca, and Matthew Maynard
For more information view README.md
 */
package com.picklez;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class FileItem implements Serializable, Comparable<FileItem> {

    @Serial
    private final static long serialVersionUID = -6183808971942914447L;
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
    private List<WordItem> words = null;

    /**
     * No args constructor for use in serialization
     */
    public FileItem() {
    }

    /**
     * @param path
     * @param lastUpdate
     * @param name
     * @param words
     * @param id
     */
    public FileItem(int id, String path, String name, int lastUpdate, List<WordItem> words) {
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

    public List<WordItem> getWords() {
        return words;
    }

    public void setWords(List<WordItem> words) {
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