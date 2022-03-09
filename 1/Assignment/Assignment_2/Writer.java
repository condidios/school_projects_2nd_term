public class Writer extends Artist{
    String writingType;
    public Writer(String name, String surname, String country, String ID,String writingType) {
        super(name, surname, country, ID);
        this.writingType = writingType;
    }
}