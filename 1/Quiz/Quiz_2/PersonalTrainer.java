import java.util.ArrayList;

public class PersonalTrainer extends Person{
    public ArrayList<Member> members = new ArrayList<>();
    public String sportType;

    public PersonalTrainer(int id, String name, String surname, String sportType){
        super(id,name,surname);
        this.sportType = sportType;
    }
    public int returnCountofMembers(){
        return members.size();
    }
    public void addMember(Member m){
        members.add(m);
    }
    public Member returnMember(int MemberID){
        for (Member i : members){
            if(i.Id == MemberID){
                return i;
            }
        }
        return null;
    }
    public Member ReturnFattestMember(){
        double fat = 0;
        Member person = null;
        for (Member i: members){
            if (i.getWeight() > fat){
                fat = i.getWeight();
                person = i;
            }
        }
        return person;
    }
}

