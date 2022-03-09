import java.util.ArrayList;

public class SportCenter {
    private String name;
    public PersonalTrainer[] PTs = new PersonalTrainer[0];

    public SportCenter(String name){
        this.name = name;
    }
    public void addPT(PersonalTrainer pt){
        PersonalTrainer[] ptTemp = new PersonalTrainer[PTs.length+1];
        int i = 0;
        while (i < PTs.length){
            ptTemp[i] = PTs[i];
            i++;
        }
        ptTemp[ptTemp.length-1] = pt;
        this.PTs = ptTemp;
    }
    public PersonalTrainer searchPT(String name, String surname){
        for (PersonalTrainer i: PTs){
            if (i.name.equals(name) && i.surname.equals(surname)){
                return i;
            }

        }
        return null;
    }

}

