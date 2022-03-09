import java.io.*;
import java.util.*;

public class Main {
    public static boolean checkIfInHockey(ArrayList<IceHockey> list1, String name){
        for (IceHockey i: list1){
            if (i.name.equals(name)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkIfInHandball(ArrayList<Handball> list1, String name){
        for (Handball i: list1){
            if (i.name.equals(name)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        File fixture = new File(args[0]);
        File handball = new File("handball.txt");
        File icehockey = new File("icehockey.txt");
        FileReader frfixtures = new FileReader(fixture);
        FileWriter fwhandball = new FileWriter(handball);
        FileWriter fwicehockey = new FileWriter(icehockey);
        BufferedReader brFixtures = new BufferedReader(frfixtures);
        BufferedWriter bwhandball = new BufferedWriter(fwhandball);
        BufferedWriter bwicehockey = new BufferedWriter(fwicehockey);
        ArrayList<IceHockey> ihTeamArray = new ArrayList<>();
        ArrayList<Handball>  handballTeamArray = new ArrayList<>();
        String finaltextHockey = "";
        String finaltextHandball = "";
        String line;
        while ((line = brFixtures.readLine()) != null){
            String[] fixtureArray = line.split("\t");
            if (fixtureArray[0].equals("H")){
                if (!checkIfInHandball(handballTeamArray,fixtureArray[1])){
                    Handball team1 = new Handball(fixtureArray[1]);
                    handballTeamArray.add(team1);
                }
                if (!checkIfInHandball(handballTeamArray,fixtureArray[2])){
                    Handball team1 = new Handball(fixtureArray[2]);
                    handballTeamArray.add(team1);
                }
                String[] scores = fixtureArray[3].split(":");
                if (Sports.winnerCalculate(fixtureArray[1],fixtureArray[2],Integer.parseInt(scores[0]),Integer.parseInt(scores[1])).equals(fixtureArray[1])){
                    for (Handball i: handballTeamArray){
                        if (i.name.equals(fixtureArray[1])){
                            i.addMatch();
                            i.addWin();
                            i.addGoal(Integer.parseInt(scores[0]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[1]));
                        }
                    }
                    for (Handball i: handballTeamArray){
                        if (i.name.equals(fixtureArray[2])){
                            i.addMatch();
                            i.addLose();
                            i.addGoal(Integer.parseInt(scores[1]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[0]));
                        }
                    }
                }
                else if (Sports.winnerCalculate(fixtureArray[1],fixtureArray[2],Integer.parseInt(scores[0]),Integer.parseInt(scores[1])).equals(fixtureArray[2])){
                    for (Handball i: handballTeamArray){
                        if (i.name.equals(fixtureArray[1])){
                            i.addMatch();
                            i.addLose();
                            i.addGoal(Integer.parseInt(scores[0]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[1]));
                        }
                    }
                    for (Handball i: handballTeamArray){
                        if (i.name.equals(fixtureArray[2])){
                            i.addMatch();
                            i.addWin();
                            i.addGoal(Integer.parseInt(scores[1]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[0]));
                        }
                    }
                }
                else {
                    for (Handball i: handballTeamArray){
                        if (i.name.equals(fixtureArray[1])){
                            i.addMatch();
                            i.addDraw();
                            i.addGoal(Integer.parseInt(scores[0]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[1]));
                        }
                    }
                    for (Handball i: handballTeamArray){
                        if (i.name.equals(fixtureArray[2])){
                            i.addMatch();
                            i.addDraw();
                            i.addGoal(Integer.parseInt(scores[1]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[0]));
                        }
                    }
                }
            }
            else if (fixtureArray[0].equals("I")){
                if (!checkIfInHockey(ihTeamArray,fixtureArray[1])){
                    IceHockey team1 = new IceHockey(fixtureArray[1]);
                    ihTeamArray.add(team1);
                }
                if (!checkIfInHockey(ihTeamArray,fixtureArray[2])){
                    IceHockey team1 = new IceHockey(fixtureArray[2]);
                    ihTeamArray.add(team1);
                }
                String[] scores = fixtureArray[3].split(":");
                if (Sports.winnerCalculate(fixtureArray[1],fixtureArray[2],Integer.parseInt(scores[0]),Integer.parseInt(scores[1])).equals(fixtureArray[1])){
                    for (IceHockey i:ihTeamArray){
                        if (i.name.equals(fixtureArray[1])){
                            i.addMatch();
                            i.addWin();
                            i.addGoal(Integer.parseInt(scores[0]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[1]));
                        }
                    }
                    for (IceHockey i:ihTeamArray){
                        if (i.name.equals(fixtureArray[2])){
                            i.addMatch();
                            i.addLose();
                            i.addGoal(Integer.parseInt(scores[1]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[0]));
                        }
                    }
                }
                else if (Sports.winnerCalculate(fixtureArray[1],fixtureArray[2],Integer.parseInt(scores[0]),Integer.parseInt(scores[1])).equals(fixtureArray[2])){
                    for (IceHockey i:ihTeamArray){
                        if (i.name.equals(fixtureArray[1])){
                            i.addMatch();
                            i.addLose();
                            i.addGoal(Integer.parseInt(scores[0]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[1]));
                        }
                    }
                    for (IceHockey i:ihTeamArray){
                        if (i.name.equals(fixtureArray[2])){
                            i.addMatch();
                            i.addWin();
                            i.addGoal(Integer.parseInt(scores[1]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[0]));
                        }
                    }
                }
                else {
                    for (IceHockey i:ihTeamArray){
                        if (i.name.equals(fixtureArray[1])){
                            i.addMatch();
                            i.addDraw();
                            i.addGoal(Integer.parseInt(scores[0]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[1]));
                        }
                    }
                    for (IceHockey i:ihTeamArray){
                        if (i.name.equals(fixtureArray[2])){
                            i.addMatch();
                            i.addDraw();
                            i.addGoal(Integer.parseInt(scores[1]));
                            i.addGoalScoredAgainst(Integer.parseInt(scores[0]));
                        }
                    }
                }
            }
        }
        for (Handball i: handballTeamArray){
            i.totalScoreCalc();
        }
        for (IceHockey i: ihTeamArray){
            i.totalScoreCalc();
        }
        Sports.orderIceHockey(ihTeamArray);
        Sports.orderHandBall(handballTeamArray);
        Collections.reverse(ihTeamArray);
        Collections.reverse(handballTeamArray);
        finaltextHockey += "1.\t" + ihTeamArray.get(0).name + "\t" + ihTeamArray.get(0).totalMatch + "\t" +
                ihTeamArray.get(0).totalWin + "\t" + ihTeamArray.get(0).totalDraw + "\t" + ihTeamArray.get(0).totalLose + "\t" +
                ihTeamArray.get(0).goalsScored + ":" + ihTeamArray.get(0).goalsScoredAgainst + "\t" + ihTeamArray.get(0).totalScore + "\n" +
                "2.\t" + ihTeamArray.get(1).name + "\t" + ihTeamArray.get(1).totalMatch + "\t" +
                ihTeamArray.get(1).totalWin + "\t" + ihTeamArray.get(1).totalDraw + "\t" + ihTeamArray.get(1).totalLose + "\t" +
                ihTeamArray.get(1).goalsScored + ":" + ihTeamArray.get(1).goalsScoredAgainst + "\t" + ihTeamArray.get(1).totalScore + "\n" +
                "3.\t" + ihTeamArray.get(2).name + "\t" + ihTeamArray.get(2).totalMatch + "\t" +
                ihTeamArray.get(2).totalWin + "\t" + ihTeamArray.get(2).totalDraw + "\t" + ihTeamArray.get(2).totalLose + "\t" +
                ihTeamArray.get(2).goalsScored + ":" + ihTeamArray.get(2).goalsScoredAgainst + "\t" + ihTeamArray.get(2).totalScore + "\n" +
                "4.\t" + ihTeamArray.get(3).name + "\t" + ihTeamArray.get(3).totalMatch + "\t" +
                ihTeamArray.get(3).totalWin + "\t" + ihTeamArray.get(3).totalDraw + "\t" + ihTeamArray.get(3).totalLose + "\t" +
                ihTeamArray.get(3).goalsScored + ":" + ihTeamArray.get(3).goalsScoredAgainst + "\t" + ihTeamArray.get(3).totalScore + "\n";
        finaltextHandball += "1.\t" + handballTeamArray.get(0).name + "\t" + handballTeamArray.get(0).totalMatch + "\t" +
                handballTeamArray.get(0).totalWin + "\t" + handballTeamArray.get(0).totalDraw + "\t" + handballTeamArray.get(0).totalLose + "\t" +
                handballTeamArray.get(0).goalsScored + ":" + handballTeamArray.get(0).goalsScoredAgainst + "\t" + handballTeamArray.get(0).totalScore + "\n" +
                "2.\t" + handballTeamArray.get(1).name + "\t" + handballTeamArray.get(1).totalMatch + "\t" +
                handballTeamArray.get(1).totalWin + "\t" + handballTeamArray.get(1).totalDraw + "\t" + handballTeamArray.get(1).totalLose + "\t" +
                handballTeamArray.get(1).goalsScored + ":" + handballTeamArray.get(1).goalsScoredAgainst + "\t" + handballTeamArray.get(1).totalScore + "\n" +
                "3.\t" + handballTeamArray.get(2).name + "\t" + handballTeamArray.get(2).totalMatch + "\t" +
                handballTeamArray.get(2).totalWin + "\t" + handballTeamArray.get(2).totalDraw + "\t" + handballTeamArray.get(2).totalLose + "\t" +
                handballTeamArray.get(2).goalsScored + ":" + handballTeamArray.get(2).goalsScoredAgainst + "\t" + handballTeamArray.get(2).totalScore + "\n" +
                "4.\t" + handballTeamArray.get(3).name + "\t" + handballTeamArray.get(3).totalMatch + "\t" +
                handballTeamArray.get(3).totalWin + "\t" + handballTeamArray.get(3).totalDraw + "\t" + handballTeamArray.get(3).totalLose + "\t" +
                handballTeamArray.get(3).goalsScored + ":" + handballTeamArray.get(3).goalsScoredAgainst + "\t" + handballTeamArray.get(3).totalScore + "\n";
        fwhandball.write(finaltextHandball);
        fwicehockey.write(finaltextHockey);
        fwhandball.flush();
        fwicehockey.flush();
    }
}
