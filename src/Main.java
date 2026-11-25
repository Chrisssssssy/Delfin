void main() {
//Member member = new Member("Peter", 24,9986,"rygsvømning", "Nybegynder");
//
//IO.println(member);


    Club club = new Club();

    MemberCsvMapper mapper = new MemberCsvMapper();

    MemberCsvFileHandler fileHandler = new MemberCsvFileHandler
            (Path.of("data", "members.csv"), mapper);

    //Indlæs medlemmer
    try {
        for (Member member : fileHandler.loadMembers()) {
            club.addLoadedMember(member);
        }
    } catch (IOException | RuntimeException e) {
        IO.println("Fejl ved indlæsning : " + e.getMessage());
        return;
    }

    // Start programmet
    ConsoleUI ui = new ConsoleUI(club, fileHandler);
    ui.run();

    // metode der gemmer members når man lukker programmet, kan godt gemmes som en sikkerhed
    // men er implementeret i console
    try {
        fileHandler.saveMembers(club.getMembers());
        IO.println("Medlemmer gemt!");
    } catch (IOException e) {
        IO.println("Fejl ved gemning: " + e.getMessage());
    }
}