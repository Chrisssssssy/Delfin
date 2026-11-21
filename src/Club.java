import java.util.ArrayList;

public class Club {
    private ArrayList<Member>members = new ArrayList<>();
    private int nextMemberID = 1;

    public Member createMember (String name, int age, String swimmingStyle, String swimmingLevel,
                                MembershipStatus status){
        Member member = new Member(name, age, nextMemberID, swimmingStyle, swimmingLevel, status, false);
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
}
