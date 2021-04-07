/*
This file is a part of the Search Engine project for COP2805C
This project was created by Lynx Leuck, Ulas Koca, and Matthew Maynard
For more information view README.md
 */
package com.picklez;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new SearchScreen();

    }

}
