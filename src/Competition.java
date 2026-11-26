import java.time.LocalDate;

public class Competition {
   private String competitionName;
   private String competitionPlace;
   private LocalDate competitionDate;
   private int competitionID;

    public Competition(String competitionName, String competitionPlace, LocalDate competitionDate, int competitionID){
     this.competitionName = competitionName;
     this.competitionPlace = competitionPlace;
     this.competitionDate = competitionDate;
     this.competitionID = competitionID;
    }

    public String getCompetitionName(){
        return competitionName;
    }

    public String getCompetitionPlace(){
        return competitionPlace;
    }

    public LocalDate getCompetitionDate() {
        return competitionDate;
    }

    public int getCompetitionID() {
        return competitionID;
    }
}
