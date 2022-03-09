public class Handball extends Sports {

    public Handball(String name) {
        super(name);
    }

    public void totalScoreCalc(){
        this.totalScore = 2*totalWin + totalDraw;
    }

}
