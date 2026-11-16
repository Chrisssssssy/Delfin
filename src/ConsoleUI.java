public class ConsoleUI {

    public void run (){
        boolean running = true;
        while (running){
            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast valg "));
            switch (choice){
                case 1 -> createMember();
                case 2 -> showMember();
                //case 3 ->
                case 0 -> running = false;

            }

        }
    }

    private void showMenu (){
        IO.println();
        IO.println("1. registrer medlem");
        IO.println("2. se medlemmer");
        IO.println("0. Afslut");
        IO.println();


    }

    public void createMember (){


    }

    public void showMember(){

    }



}


