package com.picklez;

public class Main {

    SearchScreen searchScreen = new SearchScreen();


    public static void main(String[] args) {
    new Main();
    }



    public Main(){
        //Grabs the current number of indexed files

           showSearchScreen();

    }

    public void showSearchScreen(){
        searchScreen.setVisible(true);

    }
}
