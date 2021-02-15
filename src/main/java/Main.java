public class Main {
    SearchEngineMaintenance searchEngineMaintenance = new SearchEngineMaintenance();
    SearchScreen searchScreen = new SearchScreen();


    public static void main(String[] args) {
    new Main();
    }



    public Main(){
        //Grabs the current number of indexed files


           showSearchEngineMaintenance();


        showSearchScreen();

    }
    public void showSearchEngineMaintenance(){
        searchEngineMaintenance.setVisible(true);
    }
    public void showSearchScreen(){
        searchScreen.setVisible(true);

    }
}
