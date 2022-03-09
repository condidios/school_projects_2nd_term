import java.util.*;

public class Sports implements Comparable<Sports> {
    String name;
    int goalsScored,goalsScoredAgainst,totalWin,totalLose,totalDraw,totalMatch,totalScore = 0;
    public Sports(String name){
        this.name = name;
    }

    public void addGoal(int goal){
        this.goalsScored += goal;
    }
    public void addGoalScoredAgainst(int goal){
        this.goalsScoredAgainst += goal;
    }
    public void addWin(){
        this.totalWin += 1;
    }
    public void addLose(){
        this.totalLose += 1;
    }
    public void addDraw(){
        this.totalDraw += 1;
    }
    public void addMatch(){
        this.totalMatch += 1;
    }
    public void totalScoreCalc(){
        this.totalScore += 3*totalWin + totalDraw;
    }
    public int averageCalculator(){
        return goalsScored - goalsScoredAgainst;
    }
    public static String winnerCalculate(String team1, String team2, int team1Score, int team2Score){
        if (team1Score > team2Score){
            return team1;
        }
        else if (team1Score < team2Score){
            return team2;
        }
        else{
            return "draw";
        }
    }
    public static void orderHandBall(ArrayList<Handball> teams) {

        Collections.sort(teams, new Comparator() {

            public int compare(Object o1, Object o2) {

                Integer x1 = ((Sports) o1).totalScore;
                Integer x2 = ((Sports) o2).totalScore;
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                Integer x3 = ((Sports) o1).averageCalculator();
                Integer x4 = ((Sports) o2).averageCalculator();
                return x3.compareTo(x4);
            }});
    }
    public static void orderIceHockey(ArrayList<IceHockey> teams) {

        Collections.sort(teams, new Comparator() {

            public int compare(Object o1, Object o2) {

                Integer x1 = ((Sports) o1).totalScore;
                Integer x2 = ((Sports) o2).totalScore;
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                }

                Integer x3 = ((Sports) o1).averageCalculator();
                Integer x4 = ((Sports) o2).averageCalculator();
                return x3.compareTo(x4);
            }});
    }
    @Override
    public int compareTo(Sports comparescore){
        int compareScore = ((Sports)comparescore).totalScore;
        return compareScore - this.totalScore;
    }
}
