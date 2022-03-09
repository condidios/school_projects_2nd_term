import java.util.ArrayList;

public class TvSeries extends Film {
    String startDate,endDate,seasons,episodes,genres;
    ArrayList<Writer> writers = new ArrayList<>();
    public TvSeries(String filmId, String title, String language, int runtime, String country, ArrayList<Director> director, ArrayList<Performer> performer, String startDate, String endDate, String seasons, String episodes, String genres,ArrayList<Writer> writers) {
        super(filmId, title, language, runtime, country, director, performer);
        this.startDate=startDate;
        this.endDate=endDate;
        this.seasons=seasons;
        this.endDate=endDate;
        this.genres=genres;
        this.episodes=episodes;
        this.writers = writers;
    }
    @Override
    public String toString(){
        String text =
                title + " ("+ startDate.substring(6) + "-" + endDate.substring(6) +")\n"+
                seasons + " seasons" + ", " + episodes + " episodes\n"+
                genres + "\n"+
                "Writers: " + writerToString(writers)+ "\n"+
                "Directors: " + directorToString(directors) + "\n"+
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