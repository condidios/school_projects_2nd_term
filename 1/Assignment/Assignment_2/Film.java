import java.util.ArrayList;

public class Film {
    String filmId,title,language,country;
    int runtime;
    ArrayList<Director> directors = new ArrayList<>();
    ArrayList<Performer> cast = new ArrayList<>();
    ArrayList<String[]> ratings = new ArrayList<>();
    double rating = 0;


    public Film(String filmId, String title, String language, int runtime, String country, ArrayList<Director> director, ArrayList<Performer> performer) {
        this.filmId=filmId;
        this.title=title;
        this.language=language;
        this.runtime=runtime;
        this.country=country;
        this.directors=(director);
        this.cast=(performer);
    }
    public void rateChange(int rate, String ID){
        String[] ratingSave = {String.valueOf(rate),ID};
        ratings.add(ratingSave);
        rateCalculate();
    }
    public void deleteRate(String ID){
        for (String[] i: ratings){
            if(i[1].equals(ID)){
                ratings.remove(i);
                break;
            }
        }
        rateCalculate();
    }
    public void rateCalculate(){
        double temp2 = 0;
        for (String[] i: ratings){
            temp2 += Integer.parseInt(i[0]);
        }
        try {
            rating = temp2 / ratings.size();
            rating = Math.round(rating*10.0)/ 10.0;
            if (temp2 == 0){
                rating = 0;
            }
        }
        catch (Exception e){
            //
        }
    }
    public void editRate(String newRate, String ID){
        for (String[] i: ratings){
            if (i[1].equals(ID)){
                i[0] = newRate;
            }
        }
        rateCalculate();
    }
    public String writerToString(ArrayList<Writer> list1){
        String finalText ="";
        for (Writer i: list1){
            finalText += i.name +" "+ i.surname+ ", ";
        }
        String strNew = finalText.substring(0, finalText.length()-2);
        return strNew;
    }
    public String directorToString(ArrayList<Director> list1){
        String finalText ="";
        for (Director i: list1){
            finalText += i.name +" "+ i.surname+ ", ";
        }
        String strNew = finalText.substring(0, finalText.length()-2);
        return strNew;
    }
    public String performerToString(ArrayList<Performer> list1){
        String finalText ="";
        for (Performer i: list1){
            finalText += i.name +" "+ i.surname+ ", ";
        }
        String strNew = finalText.substring(0, finalText.length()-2);
        return strNew;
    }
    public String getRating(){
        return String.valueOf(this.rating).replace(".", ",").replace(",0", "");
    }

    public String getFilmId() {
        return filmId;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}