public class ChildActor extends Performer{
    String age;
    public ChildActor(String name, String surname, String country, String ID,String age) {
        super(name, surname, country, ID);
        this.age=age;
    }
}