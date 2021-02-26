package com.picklez;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileBrowser {
    private static JFrame frame;

    public static File fileSelector() {
        FileDialog fd = new FileDialog(frame, "File Selector", FileDialog.LOAD);
        fd.setVisible(true);
        String fileName = fd.getDirectory() + fd.getFile();
        File file = new File(fileName);
        fileName = file.getName();
        String fileDirectory = file.getAbsolutePath();
        System.out.print("Name : " + fileName + "- Directory : " + fileDirectory);
        return file;
    }
}
