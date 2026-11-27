

public class Result {
    private final Member member;
    private final Discipline discipline;
    private final Competition competition;
    private final int placering;

    public Result(Member member, Discipline discipline, Competition competition, int placering) {
        this.member = member;
        this.discipline = discipline;
        this.competition = competition;
        this.placering = placering;
    }

    public Member getMember() {
        return member;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public Competition getCompetition() {
        return competition;
    }

    public int getPlacering() {
        return placering;
    }
}
