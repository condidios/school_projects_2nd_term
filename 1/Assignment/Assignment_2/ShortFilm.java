import java.util.ArrayList;

public class ShortFilm extends Film{
    String releaseDate,genre;
    ArrayList<Writer> writers = new ArrayList<>();
    public ShortFilm(String filmId, String title, String language, int runtime, String country, ArrayList<Director> director, ArrayList<Performer> performer,String releaseDate, String genre, ArrayList<Writer> writer) {
        super(filmId, title, language, runtime, country, director, performer);
        this.releaseDate=releaseDate;
        this.genre=genre;
        this.writers=(writer);
    }
    @Override
    public String toString(){
        String text =
                title + " (" + releaseDate.substring(6) + ")\n" +
                genre + "\n" +
                "Writers: " + writerToString(writers) + "\n" +
                "Directors: " + directorToString(directors) + "\n" +
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