public class Director extends Artist{
    String agent;
    public Director(String name, String surname, String country, String ID,String agent) {
        super(name, surname, country, ID);
        this.agent=agent;
    }
}
