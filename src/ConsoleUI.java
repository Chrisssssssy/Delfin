public class ConsoleUI {
    Club club;

    public ConsoleUI(Club club){
        this.club = club;
    }

    public void run (){
        boolean running = true;
        while (running){
            showMainMenu();
            int choice = Integer.parseInt(IO.readln("Indtast valg "));
            switch (choice){
                case 1 -> FormandMenu();
                case 2 -> KassererMenu();
                case 3 -> TrænerMenu();
                case 0 -> running = false;

            }

        }
    }

    private void showMainMenu (){
        IO.println();
        IO.println("1. Formand");
        IO.println("2. Kasserer");
        IO.println("2. Træner");
        IO.println("0. Afslut");
        IO.println();


    }

    public void FormandMenu (){
        boolean inMenuFormand = true;
        while (inMenuFormand){
            showInMenuFormand ();
            int choice = Integer.parseInt(IO.readln("Indtast valg "));
            switch (choice){
                case 1 -> createMember();
                case 2 -> showMember();
                case 3 -> DeleteMember();
                case 0 -> inMenuFormand = false;

            }
        }
    }

    private void showInMenuFormand() {
        IO.println();
        IO.println("1. Registrer medlem");
        IO.println("2. Vis medlemmer");
        IO.println("3. slet medlem");
        IO.println("0. Tilbage til hovedmenuen");
        IO.println();
    }

    private void createMember() {
        club.createMember();



    }

    private void showMember() {
    }

    private void DeleteMember() {
    }

    public void KassererMenu(){
        boolean inMenuKasserer = true;
        while (inMenuKasserer){
            showInMenuKasserer ();
            int choice = Integer.parseInt(IO.readln("Indtast valg "));
            switch (choice){
                case 1 -> showExpectedIncome();
                case 2 -> showArrears();
                case 3 -> RegisterPayment();
                case 0 -> inMenuKasserer = false;

            }
        }
    }

    private void showInMenuKasserer() {
        IO.println();
        IO.println("1. Forventet kontingent i alt");
        IO.println("2. Restanceliste");
        IO.println("3. Registrer betaling");
        IO.println("0. Tilbage til hovedmenu");
        IO.println("0. Tilbage til hovedmenuen");
        IO.println();
    }

    private void RegisterPayment() {
    }

    private void showArrears() {
    }

    private void showExpectedIncome() {
    }

    public void TrænerMenu (){
        boolean inMenuTræner = true;
        while (inMenuTræner){
            showInMenuTræner ();
            int choice = Integer.parseInt(IO.readln("Indtast valg "));
            switch (choice){
                case 1 -> Top5Menu();
                case 0 -> inMenuTræner = false;

            }
        }
    }

    private void showInMenuTræner() {
        IO.println();
        IO.println("1. Vis Top 5");;
        IO.println("0. Tilbage til hovedmenuen");
        IO.println();
    }

    private void Top5Menu() {
    }



}


