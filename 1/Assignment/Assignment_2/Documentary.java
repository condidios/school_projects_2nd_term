import java.util.ArrayList;

public class Documentary extends Film{
    String releaseDate;
    public Documentary(String filmId, String title, String language, int runtime, String country, ArrayList<Director> director, ArrayList<Performer> performer, String releaseDate) {
        super(filmId, title, language, runtime, country, director, performer);
        this.releaseDate=releaseDate;
    }
    @Override
    public String toString(){
        String text =
                title + " (" + releaseDate.substring(6) + ")\n\n"+
                "Directors: "+ directorToString(directors) + "\n"+
                "Stars: " + performerToString(cast) + "\n";
        if (ratings.size() != 0){
            text += "Ratings: " + getRating() + "/10 from " + ratings.size() + " users\n";
        }
        else {
            text += "Awaiting for votes\n";
        }
        return text;
    }
}