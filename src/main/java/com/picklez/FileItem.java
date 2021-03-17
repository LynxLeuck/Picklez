package com.picklez;

import java.util.List;

public class FileItem implements Comparable <FileItem>{
    public final String path;
    public final String name;
    public final long lastUpdate;
    public final int id;
    public List words;
    public final String[] tableList;

    public FileItem(String path, String name, int lastUpdate, int id ) {
        this.path = path;
        this.name = name;
        this.lastUpdate = lastUpdate;
        this.id = id;
        this.tableList = new String[] {path, name};

    }
    public int compareTo(FileItem other) {
        return this.id - other.id;
    }
    public void addWord(String word){
        words.add(word);
    }


    }

