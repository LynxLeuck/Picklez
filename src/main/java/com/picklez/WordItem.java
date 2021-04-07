package com.picklez;


import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class WordItem {

    @SerializedName("word")
    @Expose
    private final String word;

    public List<Integer[]> getFilePosition() {
        return filePosition;
    }

    public void setFilePosition(List<Integer[]> filePosition) {
        this.filePosition = filePosition;
    }

    @SerializedName("filePosition")
    @Expose
    private List<Integer[]> filePosition;
    @Serial
    private final static long serialVersionUID = -6183808971942914447L;

    /**
     * @param word
     * @param fileLocation
     */
    public WordItem(String word, Integer fileID, Integer fileLocation) {
        Integer[] file = new Integer[]{fileID, fileLocation};
        this.word = word;
        this.filePosition = new ArrayList<Integer[]>();
        //Creates a singular integer for the file location to store as a word
        filePosition.add(file);
    }


    public String getWord() {
        return word;
    }

    /**
     * @param o the object to be compared.
     * @return a zero if the items are identical
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    public int compareTo(@NotNull WordItem o) {
        if (getWord().toLowerCase(Locale.ROOT) == o.getWord().toLowerCase(Locale.ROOT)) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        System.out.println(word + getFilePosition());
        return word + " " + getFilePosition();
    }



}
