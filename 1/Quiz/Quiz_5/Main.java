import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader decimal = new BufferedReader(new FileReader(args[0]));
        BufferedWriter octal = new BufferedWriter(new FileWriter("octal.txt"));
        String line;
        String finalText = "";
        while ((line = decimal.readLine()) != null){
            Stack stack = new Stack();
            int lineInt = Integer.parseInt(line);
            while (lineInt >= 8){
                int remainder = lineInt % 8;
                stack.push(remainder);
                int toBeAdded = 8 - remainder;
                lineInt += toBeAdded;
                lineInt = lineInt/8 - 1;
            }
            stack.push(lineInt);
            while (!stack.isEmpty()){
                finalText += String.valueOf(stack.pop());
            }
            finalText += "\n";
        }
        octal.write(finalText);
        octal.flush();
    }
}
