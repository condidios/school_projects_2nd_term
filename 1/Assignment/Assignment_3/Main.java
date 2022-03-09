import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        File board1 = new File(args[0]);
        File commands = new File(args[1]);
        FileReader frBoard = new FileReader(board1);
        FileReader frCommands = new FileReader(commands);
        BufferedReader brBoard = new BufferedReader(frBoard);
        BufferedReader brCommands = new BufferedReader(frCommands);
        BufferedWriter brOutput = new BufferedWriter(new FileWriter(args[2]));
        String finalText = "";
        String initials = "";
        String line;
        ArrayList<Characters> characters = new ArrayList<>();
        ArrayList<ArrayList<String>> board = new ArrayList<>();
        int boardLength = 0;
        while ((line = brBoard.readLine()) != null) {
            if (line.equals("")) {
                initials += "\n\n";
            } else {
                initials += line + "\n";
            }

        }
        String[] array2 = initials.split("\n\n\n");
        for (String i : array2) {
            String[] temp = i.split("\n");
            if (temp[0].equals("BOARD")) {
                boardLength = Integer.parseInt((temp[1].split("x"))[0]);
            } else if (temp[0].equals("CALLIANCE")) {
                for (String k : temp) {
                    String[] ktemp = k.split(" ");
                    if (ktemp[0].equals("ELF")) {
                        Elf elf1 = new Elf(ktemp[1], Integer.parseInt(ktemp[2]) + 1, Integer.parseInt(ktemp[3]) + 1, Constants.elfAP, Constants.elfMaxMove, 70);
                        characters.add(elf1);
                    } else if (ktemp[0].equals("DWARF")) {
                        Dwarf elf1 = new Dwarf(ktemp[1], Integer.parseInt(ktemp[2]) + 1, Integer.parseInt(ktemp[3]) + 1, Constants.dwarfAP, Constants.dwarfMaxMove, 120);
                        characters.add(elf1);
                    } else if (ktemp[0].equals("HUMAN")) {
                        Human elf1 = new Human(ktemp[1], Integer.parseInt(ktemp[2]) + 1, Integer.parseInt(ktemp[3]) + 1, Constants.humanAP, Constants.humanMaxMove, 100);
                        characters.add(elf1);
                    }

                }
            } else if (temp[0].equals("ZORDE")) {
                for (String k : temp) {
                    String[] ktemp = k.split(" ");
                    if (ktemp[0].equals("GOBLIN")) {
                        Goblin elf1 = new Goblin(ktemp[1], Integer.parseInt(ktemp[2]) + 1, Integer.parseInt(ktemp[3]) + 1, Constants.goblinAP, Constants.goblinMaxMove, 80);
                        characters.add(elf1);
                    } else if (ktemp[0].equals("TROLL")) {
                        Troll elf1 = new Troll(ktemp[1], Integer.parseInt(ktemp[2]) + 1, Integer.parseInt(ktemp[3]) + 1, Constants.trollAP, Constants.trollMaxMove, 150);
                        characters.add(elf1);
                    } else if (ktemp[0].equals("ORK")) {
                        Ork elf1 = new Ork(ktemp[1], Integer.parseInt(ktemp[2]) + 1, Integer.parseInt(ktemp[3]) + 1, Constants.orkAP, Constants.orkMaxMove, 200);
                        characters.add(elf1);
                    }
                }
            }
        }
        board = restartBoard(boardLength);
        finalText += printBoard(characters,boardLength);
        for (Characters i : characters) {
            i.setBoard(board);
        }
        while ((line = brCommands.readLine()) != null) {
            if (!winner(characters).equals("")){
                finalText+=winner(characters);
                brOutput.write(finalText);
                brOutput.flush();
                break;
            }
            ArrayList<String[]> twoCommands = new ArrayList<>();
            String[] splittedCommands = line.split(" ");
            String[] commandsUse = splittedCommands[1].split(";");
            for (int i = 0; i < commandsUse.length; i++) {

                if (i % 2 == 1) {
                    String[] temp = new String[2];
                    temp[0] = commandsUse[i - 1];
                    temp[1] = commandsUse[i];
                    twoCommands.add(temp);
                }

            }
            Characters i = null;
            for (Characters k : characters) {
                if (k.id.equals(splittedCommands[0])) {
                    i = k;
                    break;
                }
            }
            if (i == null) {
                continue;
            }
            if (commandsUse.length / 2 != i.maxMove) {
                finalText += "Error : Move sequence contains wrong number of move steps. Input line ignored.\n\n";
            } else {
                boolean checker = false;
                for (int j = 0; j < twoCommands.size(); j++) {
                    if (Integer.parseInt(twoCommands.get(j)[0]) + i.xcoord < boardLength + 1 && Integer.parseInt(twoCommands.get(j)[0]) + i.xcoord > 0 && Integer.parseInt(twoCommands.get(j)[1]) + i.ycoord < boardLength + 1 && Integer.parseInt(twoCommands.get(j)[1]) + i.ycoord > 0) {
                        checker = true;
                        int newx = Integer.parseInt(twoCommands.get(j)[0]) + i.xcoord;
                        int newy = Integer.parseInt(twoCommands.get(j)[1]) + i.ycoord;
                        String temp5 = board.get(newy).get(newx).substring(0, 1);
                        if (i instanceof Ork && j == 0) {
                            ((Ork) i).heal(characters, 1);
                            board = currentBoard(characters,boardLength);
                        }
                        if (board.get(newy).get(newx).equals("  ")) {
                            i.xcoord = newx;
                            i.ycoord = newy;
                            if (i instanceof Goblin || i instanceof Dwarf || (i instanceof Elf && j != twoCommands.size() - 1)) {
                                i.attack(characters, 1);

                            }
                            board = currentBoard(characters,boardLength);
                        } else if ((i instanceof Zorde && (temp5.equals("H") || temp5.equals("D") || temp5.equals("E"))) || (i instanceof Calliance && (temp5.equals("T") || temp5.equals("O") || temp5.equals("G")))) {
                            i.xcoord = newx;
                            i.ycoord = newy;
                            i.fightToDeath(characters, board.get(newy).get(newx));
                            board = currentBoard(characters,boardLength);
                            break;
                        } else {
                            board = currentBoard(characters,boardLength);
                            break;
                        }
                        if ((i instanceof Human || i instanceof Troll || i instanceof Ork) && j == twoCommands.size() - 1) {
                            i.attack(characters, 1);
                            board = currentBoard(characters,boardLength);
                        } else if (i instanceof Elf && j == twoCommands.size() - 1) {
                            i.attack(characters, 2);
                            board = currentBoard(characters,boardLength);
                        }
                    } else {
                        try {
                            throw new BoundaryException();
                        } catch (BoundaryException e) {
                            if (checker) {
                                finalText+="\n";
                                finalText += printBoard(characters, boardLength);
                                checker = false;
                            }
                            finalText += "Error : Game board boundaries are exceeded. Input line ignored.\n\n";
                            board = currentBoard(characters,boardLength);
                            break;
                        }
                    }
                }
                if (checker) {
                    board = currentBoard(characters,boardLength);
                    finalText += printBoard(characters, boardLength);
                }
            }
            if (!winner(characters).equals("")){
                finalText+=winner(characters);
                brOutput.write(finalText);
                brOutput.flush();
                break;
            }
        }
    }

    public static String printBoard(ArrayList<Characters> characters, int boardLength) {
        String finaltext = "";
        ArrayList<ArrayList<String>> board = currentBoard(characters,boardLength);
        for (ArrayList<String> i : board) {
            for (String k : i) {
                finaltext += k;
            }
            finaltext += "\n";
        }
        finaltext += "\n";
        Collections.sort(characters);
        for (Characters i : characters) {
            if (i instanceof Elf) {
                finaltext += i.id + "\t" + i.hp + "\t" + "(70)\n";
            }
            if (i instanceof Ork) {
                finaltext += i.id + "\t" + i.hp + "\t" + "(200)\n";
            }
            if (i instanceof Troll) {
                finaltext += i.id + "\t" + i.hp + "\t" + "(150)\n";
            }
            if (i instanceof Goblin) {
                finaltext += i.id + "\t" + i.hp + "\t" + "(80)\n";
            }
            if (i instanceof Human) {
                finaltext += i.id + "\t" + i.hp + "\t" + "(100)\n";
            }
            if (i instanceof Dwarf) {
                finaltext += i.id + "\t" + i.hp + "\t" + "(120)\n";
            }
        }
        finaltext += "\n";
        return finaltext;

    }

    public static ArrayList<ArrayList<String>> restartBoard(int boardLength) {
        ArrayList<ArrayList<String>> board = new ArrayList<>();
        ArrayList<String> temp1 = new ArrayList<>();
        for (int i = 0; i < boardLength + 1; i++) {
            temp1.add("**");
        }
        board.add(temp1);
        for (int i = 0; i < boardLength; i++) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("*");
            for (int k = 0; k < boardLength; k++) {
                temp.add("  ");
            }
            temp.add("*");
            board.add(temp);
        }
        board.add(temp1);
        return board;
    }
    public static ArrayList<ArrayList<String>> currentBoard(ArrayList<Characters> characters, int boardLength){
        ArrayList<ArrayList<String>> board = restartBoard(boardLength);
        for (Characters i : characters) {
            i.setBoard(board);
        }
        return board;
    }
    public static String winner(ArrayList<Characters> list1){
        boolean checker = false;
        boolean checker2 = false;
        for (Characters i : list1){
            if (i instanceof Zorde){
                checker = true;
            }
            else if (i instanceof Calliance){
                checker2 = true;
            }
        }
        if (checker && checker2){
            return "";
        }
        else if (checker){
            return "\nGame Finished\nZorde Wins";
        }
        else{
            return "\nGame Finished\nCalliance Wins";
        }
    }

}
