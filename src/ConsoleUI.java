import java.io.IOException;
import java.util.List;

public class ConsoleUI {
    Club club;

    private final MemberCsvFileHandler fileHandler;

    public ConsoleUI(Club club, MemberCsvFileHandler fileHandler){
        this.club = club;
        this.fileHandler = fileHandler;
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
                case 4 -> MemberMenu();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg. Prøv igen");

            }

        }
    }

    private void showMainMenu (){
        IO.println();
        IO.println("1. Formand");
        IO.println("2. Kasserer");
        IO.println("3. Træner");
        IO.println("4. Medlem");
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
                default -> IO.println("Ugyldigt valg. Prøv igen");

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
        while (age <= 0) {
            IO.println("Alder skal være større end 0");
            age = readInt("Alder: ");
        }

        String swimmingStyle = IO.readln("Svømmestil (Crawl/Bryst/Ryg/Butterfly): ");
        String swimmingLevel = IO.readln("Svømmeniveau (Motionist/Konkurrence): ");

        // Membershipstatus oprettes nu i en anden metode da, den også skal bruges i medlemsmenu'
        MembershipStatus status = chooseMembershipStatus();

//
//        SwimmerType type = SwimmerType.valueOf(
//                IO.readln("MOTIONIST/KONKURRENCE").trim().toUpperCase());

        Member member = club.createMember(name, age, swimmingStyle, swimmingLevel, status);
        saveMembers();
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
        saveMembers();
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
                default -> IO.println("Ugyldigt valg. Prøv igen");

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

            IO.println();
            IO.println("Medlem: " + member.getName());
            IO.println("Betalingsstatus: Ikke betalt");
            member.markAsHasPaid();
            saveMembers();
            IO.println();
            IO.println("Medlemmets betaling er nu registreret");
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

        if (unpaidMembers.isEmpty()) {
            IO.println();
            IO.println("Ingen medlemmer er i restance");
            return;
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
                default -> IO.println("Ugyldigt valg. Prøv igen");

            }
        }
    }

    private void showInMenuTræner() {
        IO.println();
        IO.println("1. Vis Top 5");
        IO.println("0. Tilbage til hovedmenuen");
        IO.println();
    }

    private void Top5Menu() {
    }

    private void MemberMenu() {
        int id = readInt("Indtast medlemsnummer: ");
        Member member = club.findMember(id);

        if (member == null) {
            IO.println("Medlemsnummer kan ikke findes");
            return;
        }
        IO.println();
        IO.println("Velkommen til " + member.getName());
        IO.println();

        boolean inMenuMember = true;
        while (inMenuMember) {
            showInMenuMember();

            int choice = readInt("Indtast valg: ");
            IO.println();

            switch (choice) {
                case 1 -> showStatusForMember(member);
                case 2 -> changeMembershipStatus(member);
                case 0 -> inMenuMember = false;
                default -> IO.println("Ugyldigt valg. Prøv igen.");
            }

        }

    }

    private void showInMenuMember() {
        IO.println("1. Se medlemsstatus");
        IO.println("2. Skift medlemsstatus");
        IO.println("0. Tilbage til hovedmenuen");
        IO.println();
    }

    private void showStatusForMember(Member member) {
        IO.println("Nuværende status: " + member.getStatus());
        IO.println();
    }

    private void changeMembershipStatus(Member member) {
        MembershipStatus newStatus = chooseMembershipStatus();

        if (member.getStatus() == newStatus) {
            IO.println("Du har allerede denne medlemsstatus.");
            IO.println();
            return;
        }
        member.setStatus(newStatus);
        saveMembers();

        IO.println();
        IO.println("Din medlemsstatus er nu ændret til: " + member.getStatus());
        IO.println();
    }

    //Metode som bliver brugt til at sætte medlemsstatus
    private MembershipStatus chooseMembershipStatus() {
        IO.println("Vælg medlemsstatus");
        IO.println("1. Aktiv");
        IO.println("2. Passiv");

        int statusChoice = readInt("Indtast valg: ");

        while (statusChoice != 1 && statusChoice != 2) {
            IO.println("Ugyldigt valg. Vælge 1 eller 2");
            statusChoice = readInt("Indtast valg: ");
        }
        MembershipStatus status;
        if (statusChoice == 1) {
            status = MembershipStatus.ACTIVE;
        } else {
            status = MembershipStatus.PASSIVE;
        }
        return status;
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
    // metode til at gemme members
    private void saveMembers() {
        try {
            fileHandler.saveMembers(club.getMembers());
            IO.println("Medlemmer gemt!");
        } catch (IOException e) {
            IO.println("Fejl ved gemning: " + e.getMessage());
        }
    }
}

