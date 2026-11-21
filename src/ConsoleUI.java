import java.util.List;

public class ConsoleUI {
    Club club;

    public ConsoleUI(Club club){
        this.club = club;
    }

    public void run (){
        boolean running = true;
        while (running){
            showMainMenu();
            int choice = readInt("Indtast valg ");
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
        IO.println("3. Træner");
        IO.println("0. Afslut");
        IO.println();


    }

    public void FormandMenu (){
        boolean inMenuFormand = true;
        while (inMenuFormand){
            showInMenuFormand ();
            int choice = readInt("Indtast valg: ");
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
        String name = IO.readln("Navn: ");
        int age = readInt("Alder: ");

        String swimmingStyle = IO.readln("Svømmestil: ");
        String swimmingLevel = IO.readln("Svømmeniveau: ");

        //Fra Enums?
        MembershipStatus status = MembershipStatus.valueOf(
                IO.readln("Medlemskab aktiv/passivt: ").trim().toUpperCase());
//
//        SwimmerType type = SwimmerType.valueOf(
//                IO.readln("MOTIONIST/KONKURRENCE").trim().toUpperCase());

        Member member = club.createMember(name, age, swimmingStyle, swimmingLevel, status);
        IO.println();
        IO.println("Medlem oprettet: " + member.getName());
        IO.println("Medlemsnummer: " + member.getMemberID());
    }

    private void showMember() {
        if (club.getMembers().isEmpty()){
            IO.println("Der er ingen registrerede medlemmer");
            return;
        }

        for (Member member : club.getMembers()){
            IO.println();
            IO.println("Medlemsnummer: " + member.getMemberID());
            IO.println("Navn: " + member.getName());
            IO.println("Alder: " + member.getAge());
            IO.println("Svømmestil: " + member.getSwimmingStyle());
            IO.println("Svømmeniveau: " + member.getSwimmingLevel());
            IO.println("Medlemsstatus: " + member.getStatus());
            IO.println();
        }

    }

    private void DeleteMember() {
        int id = readInt("Medlemsnummer på medlemmet der skal slettes: ");
        Member member = club.findMember(id);

        if (member == null) {
            IO.println("Der findes intet medlem med nummer " + id);
            return;
        }

        club.deleteMember(id);
        IO.println("Medlemmet er slettet: " + member.getName());
        IO.println("Medlemsnummer: " + member.getMemberID());
    }

    public void KassererMenu(){
        boolean inMenuKasserer = true;
        while (inMenuKasserer){
            showInMenuKasserer ();
            int choice = readInt("Indtast valg: ");
            switch (choice){
                case 1 -> showExpectedIncome();
                case 2 -> showArrears();
                case 3 -> registerPayment();
                case 4 -> showMemberFee();
                case 0 -> inMenuKasserer = false;

            }
        }
    }

    private void showInMenuKasserer() {
        IO.println();
        IO.println("1. Forventet kontingent i alt");
        IO.println("2. Restanceliste");
        IO.println("3. Registrer betaling");
        IO.println("4. Beregn et medlems kontigent");
        IO.println("0. Tilbage til hovedmenuen");
        IO.println();
    }

    private void registerPayment() {
        int id = readInt("Indtast medlemsnummer: ");
        Member member = club.findMember(id);

        if (member == null) {
            IO.println("Medlemmesnummer kan ikke findes");
            return;
        }
        if (member.getHasPaid()) {
            IO.println("Medlemmet har allerede betalt kontigent");
            return;
        }

        if(!member.getHasPaid()) {
            IO.println();
            IO.println("Medlem: " + member.getName());
            IO.println("Betalingsstatus: Ikke betalt");
            member.markAsHasPaid();
            IO.println();
            IO.println("Medlemmets betaling er nu registreret");
        }
    }

    private void showMemberFee() {
        int id = readInt("Indtast medlemsnummer: ");
        Member member = club.findMember(id);

        if (member == null) {
            IO.println("Medlemsnummeret kan ikke findes");
            return;
        }
        PaymentManager paymentManager = new PaymentManager();
        int fee = paymentManager.calculateFee(member.getAge(), member.getStatus());
        IO.println();
        IO.println("Medlem: " + member.getName() + "\nÅrligt kontigent: " + fee + " kr.");
    }

    private void showArrears() {
        PaymentManager paymentManager = new PaymentManager();

        List<Member> unpaidMembers = paymentManager.getUnpaidMembers(club.getMembers());

        if (unpaidMembers == null) {
            IO.println();
            IO.println("Ingen medlemmer er i resistance");
        }
        for (Member member: unpaidMembers) {
            IO.println();
            IO.println("Navn: " + member.getName());
            IO.println("Medlemsnummer: " + member.getMemberID());
            int fee = paymentManager.calculateFee(member.getAge(), member.getStatus());
            IO.println("Skyldigt kontigent: " + fee + " kr.");
        }

    }

    private void showExpectedIncome() {
        PaymentManager expected = new PaymentManager();
        List<Member> members = club.getMembers();

        int result = expected.calculateTotal(members);

        IO.println("Samlede forventet kontigentindtægt " + result + " kr.");
    }

    public void TrænerMenu (){
        boolean inMenuTræner = true;
        while (inMenuTræner){
            showInMenuTræner ();
            int choice = readInt("Indtast valg ");
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

    //Metode der erstater Integer.parseInt(IO.readln()) for at lave en mere generel at fange andet end tal
    private int readInt(String prompt) {

        while (true) {
            try {
            return Integer.parseInt(IO.readln(prompt));
        } catch (NumberFormatException e) {
            IO.println("Fejl: Du skal indtaste et tal!");
        }
    }
    }
}

