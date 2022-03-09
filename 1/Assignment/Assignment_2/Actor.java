public class Actor extends Performer{
    String height;
    public Actor(String name, String surname, String country, String ID,String height) {
        super(name, surname, country, ID);
        this.height=height;
    }
}