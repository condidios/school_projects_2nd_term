import java.util.ArrayList;

public class User extends Person {
    ArrayList<String[]> rate = new ArrayList<>();
    public User(String name, String surname, String country, String ID){
        super(name, surname, country, ID);

    }
    public void rateSys(String rate1, String filmID){
        String[] stringList = {rate1,filmID};
        rate.add(stringList);
    }
    public boolean rateChecker(ArrayList<String[]> list1, String ID){
        for (String[] i : list1) {
            if (i[1].equals(ID)) {
                return true;
            }
        }
        return false;
    }
    public void rateChange(String newRate, String filmID){
        for (String[] i:rate){
            if (i[1].equals(filmID)){
                i[0] = newRate;

            }
        }
    }
    public void rateDelete(String ID){
        for (String[] i:rate){
            if (i[1].equals(ID)){
                rate.remove(i);
            }
        }
    }
}
