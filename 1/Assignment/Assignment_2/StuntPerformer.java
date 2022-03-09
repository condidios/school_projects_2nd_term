public class StuntPerformer extends Actor{
    String realActorId;
    public StuntPerformer(String name, String surname, String country, String ID,String height,String realActorId) {
        super(name, surname, country, ID,height);
        this.realActorId=realActorId;
    }
}
