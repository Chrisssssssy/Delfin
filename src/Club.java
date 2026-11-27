import java.util.ArrayList;
import java.time.LocalDate;


public class Club {
    private ArrayList<Member>members = new ArrayList<>();

    private int nextMemberID = 1;

    public Member createMember (String name, int age, String swimmingLevel,
                                MembershipStatus status){
        Member member = new Member(name, age, nextMemberID , swimmingLevel, status, false);
        nextMemberID++;
        members.add(member);
        return member;
    }

    public Member findMember(int memberID) {
        for (Member member : members) {
            if (member.getMemberID() == memberID) {
                return member;
            }
        }
        return null;
    }

    public boolean deleteMember(int memberID) {
        return members.removeIf(member -> member.getMemberID() == memberID);
    }


    public ArrayList<Member> getMembers() {
        return members;
    }
    public void addLoadedMember(Member member) {
        members.add(member);

        if (member.getMemberID() >= nextMemberID) {
            nextMemberID = member.getMemberID() + 1;
        }
    }

    private ArrayList<Result>results = new ArrayList<>();
    public Result createResult(Member member, Discipline discipline, Competition competition, int placering){
        Result result = new Result(member, discipline, competition, placering);
        results.add(result);
        return result;
    }



    public Result findResult(Member member){
        for (Result result : results) {
            if (result.getMember() == member){
                return result;
            }
        }
        return null;
    }
    public boolean deleteResult(Member member) {
        return results.removeIf(result -> result.getMember().equals(member));
    }

    public ArrayList<Result> getResults() {
        return results;
    }
    public void addLoadedResult(Result result) {
        results.add(result);
    }

}
