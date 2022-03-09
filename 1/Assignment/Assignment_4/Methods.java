import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Methods {
    static String finalText = "";
    static Queue queue = new Queue();
    static ArrayList<Stack> stacksArray = new ArrayList<>();
    static ArrayList<Token> tokensArray = new ArrayList<>();

    public static ArrayList<String> readFile(String fileName) { // The method I used for reading the input files
        try {
            BufferedReader fileBuffered = new BufferedReader(new FileReader(fileName));
            String line;
            ArrayList<String> lines = new ArrayList<>();
            while ((line = fileBuffered.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (Exception e) {
            System.out.println("File not found " + fileName);
            System.exit(0);
        }
        return null;
    }

    public static Token findBiggestPrio(ArrayList<Token> tokenList, String type) { // The method for finding the highest priority token of the given type
        ArrayList<Token> arrayClone = new ArrayList<>(tokenList);
        Collections.sort(arrayClone, Comparator.comparing(Token::getOrder));
        Collections.reverse(arrayClone);
        Collections.sort(arrayClone, Comparator.comparing(Token::getValue));
        for (int i = 0; i < tokenList.size(); i++) {
            if (arrayClone.get(arrayClone.size() - 1 - i).type.equals(type)) {
                return arrayClone.get(arrayClone.size() - 1 - i);
            }
        }
        return null;
    }

    public static void sendFile(String arg1, String arg2, String arg3, String arg4) { // The method I used for my coding part.
        ArrayList<String> parts = readFile(arg1);
        ArrayList<String> itemsNotSplit = readFile(arg2);
        ArrayList<String> tokensNotSplit = readFile(arg3);
        ArrayList<String> tasks = readFile(arg4);
        int orderCounter = 0;
        for (String i : parts) {
            Stack stacks = new Stack(i);
            stacksArray.add(stacks);
        }
        for (String i : itemsNotSplit) {
            String[] splitItems = i.split(" ");
            Items item = new Items(splitItems[0], splitItems[1]);
            for (Stack k : stacksArray) {
                if (k.type.equals(item.type)) {
                    k.push(item);
                }
            }
        }
        for (String i : tokensNotSplit) {
            String[] splitTokens = i.split(" ");
            Token token = new Token(splitTokens[0], splitTokens[1], Integer.parseInt(splitTokens[2]), orderCounter);
            queue.enqueue(token);
            tokensArray.add(token);
            orderCounter++;
        }
        for (String i : tasks) {
            String[] splitTasks = i.split("\t");
            if (splitTasks[0].equals("PUT")) {
                for (String k : splitTasks) {
                    if (!k.equals("PUT")) {
                        String[] splitLine = k.split(",");
                        for (int j = 1; j < splitLine.length; j++) {
                            Items items = new Items(splitLine[j], splitLine[0]);
                            for (Stack l : stacksArray) {
                                if (l.type.equals(items.type)) {
                                    l.push(items);
                                }
                            }
                        }
                    }
                }
            } else if (splitTasks[0].equals("BUY")) {
                for (String k : splitTasks) {
                    if (!k.equals("BUY")) {
                        String[] splitLine = k.split(",");
                        for (int j = 0; j < Integer.parseInt(splitLine[1]); j++) {
                            for (Stack l : stacksArray) {
                                if (l.type.equals(splitLine[0])) {
                                    l.pop();
                                }
                            }
                        }
                        for (Token j : tokensArray) {
                            if (j.type.equals(splitLine[0])) {
                                Token rightOne = findBiggestPrio(tokensArray, splitLine[0]);
                                if (rightOne.id.equals(j.id)) {
                                    if (j.value == Integer.parseInt(splitLine[1])) {
                                        queue.dequeue(j);
                                        break;
                                    } else if (j.value > Integer.parseInt(splitLine[1])) {
                                        j.value -= Integer.parseInt(splitLine[1]);
                                        j.order = orderCounter;
                                        orderCounter++;
                                        break;
                                    } else {
                                        queue.tokenCalculate(Integer.parseInt(splitLine[1]), splitLine[0]);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void printFile(String outputFileName) throws IOException { // The method for writing the concluded output to an output.txt file
        BufferedWriter brOutput = new BufferedWriter(new FileWriter(outputFileName));
        queue.arraySort();
        for (Stack i : stacksArray) {
            i.sortItems();
            finalText += i.type + "\n";
            if (i.items.size() == 0) {
                finalText += "\n";
            }
            for (Items k : i.items) {
                finalText += k.id + "\n";
            }
            finalText += "---------------\n";
        }
        finalText += "Token Box:\n";
        for (Token i : queue.tokens) {
            finalText += i.id + " " + i.type + " " + i.value + "\n";
        }
        brOutput.write(finalText);
        brOutput.flush();
    }
}
