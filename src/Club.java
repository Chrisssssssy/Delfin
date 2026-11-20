import java.util.ArrayList;

public class Club {
    private ArrayList<Member>members = new ArrayList<>();
    private int nextMemberID = 1;

    public Member createMember (String name, int age, String swimmingStyle, String swimmingLevel){
        Member member = new Member(name, age, nextMemberID, swimmingStyle, swimmingLevel);
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
}
