import com.sun.source.tree.WhileLoopTree;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File commands = new File(args[1]);
        File authors = new File(args[0]);
        FileReader frCommands = new FileReader(commands);
        FileReader frAuthors = new FileReader(authors);
        BufferedReader brCommands = new BufferedReader(frCommands);
        BufferedReader brAuthors = new BufferedReader(frAuthors);
        BufferedWriter brOutput = new BufferedWriter(new FileWriter("output.txt"));
        String line;
        ArrayList<Articles> articleObject = new ArrayList<Articles>();
        ArrayList<Author> authorObject = new ArrayList<Author>();
        String finalText = "";
        while ((line = brCommands.readLine()) != null) {
            String[] commandsArray = line.split(" ");
            if (commandsArray[0].equals("read")) {
                File article = new File(commandsArray[1]);
                FileReader readArticle = new FileReader(article);
                BufferedReader articleRead = new BufferedReader(readArticle);
                while ((line = articleRead.readLine()) != null) {
                    String[] articleArray = line.split(" ");
                    Articles article1 = new Articles();
                    article1.setPaperId(articleArray[1]);
                    article1.setName(articleArray[2]);
                    article1.setPublisherName(articleArray[3]);
                    article1.setYear(articleArray[4]);
                    articleObject.add(article1);
                }
                while ((line = brAuthors.readLine()) != null) {
                    String[] arryOfAuthor = line.split(" ");
                    Author author1 = new Author();
                    try {
                        if (arryOfAuthor[1] != null){
                            author1.setId(arryOfAuthor[1]);
                        }
                        if (arryOfAuthor[2] != null){
                            author1.setName(arryOfAuthor[2]);
                        }
                        if (arryOfAuthor[3] != null){
                            author1.setUniversity(arryOfAuthor[3]);
                        }
                        if (arryOfAuthor[4] != null){
                            author1.setDepartment(arryOfAuthor[4]);
                        }
                        if (arryOfAuthor[5] != null){
                            author1.seteMail(arryOfAuthor[5]);
                        }

                    } catch (Exception e) {
                        //
                    }
                    authorObject.add(author1);
                    try {
                        author1.setArticle1(arryOfAuthor[6]);
                        author1.setArticle2(arryOfAuthor[7]);
                        author1.setArticle3(arryOfAuthor[8]);
                        author1.setArticle4(arryOfAuthor[9]);
                        author1.setArticle5(arryOfAuthor[10]);
                    } catch (Exception e) {
                        //Block of code to handle error
                    }
                }
            }
            else if (commandsArray[0].equals("list")) {
                finalText += "----------------------------------List------------------------------------------" + "\n";
                for (Author i : authorObject) {
                    finalText += "Author:" + i.getId() + "\t" + i.getName() + "\t" + i.getUniversity() + "\t" + i.getDepartment() + "\t" + i.geteMail() + "\n";
                    for (Articles k : articleObject) {
                        if (i.getArticle1() != null && k.getPaperId().equals(i.getArticle1())) {
                            finalText += "+" + k.getPaperId() + "\t" + k.getName() + "\t" + k.getPublisherName() + "\t" + k.getYear() + "\n";
                        }
                    }
                    for (Articles k : articleObject) {
                        if (i.getArticle2() != null && k.getPaperId().equals(i.getArticle2())) {
                            finalText += "+" + k.getPaperId() + "\t" + k.getName() + "\t" + k.getPublisherName() + "\t" + k.getYear() + "\n";
                        }
                    }
                    for (Articles k : articleObject) {
                        if (i.getArticle3() != null && k.getPaperId().equals(i.getArticle3())) {
                            finalText += "+" + k.getPaperId() + "\t" + k.getName() + "\t" + k.getPublisherName() + "\t" + k.getYear() + "\n";
                        }
                    }
                    for (Articles k : articleObject) {
                        if (i.getArticle4() != null && k.getPaperId().equals(i.getArticle4())) {
                            finalText += "+" + k.getPaperId() + "\t" + k.getName() + "\t" + k.getPublisherName() + "\t" + k.getYear() + "\n";
                        }
                    }
                    for (Articles k : articleObject) {
                        if (i.getArticle5() != null && k.getPaperId().equals(i.getArticle5())) {
                            finalText += "+" + k.getPaperId() + "\t" + k.getName() + "\t" + k.getPublisherName() + "\t" + k.getYear() + "\n";
                        }
                    }
                    finalText += "\n";
                }
                finalText += "----------------------------------End-------------------------------------------" + "\n" + "\n";

            }
            else if (commandsArray[0].equals("completeAll")){
                for (Author k : authorObject){
                    for (Articles i : articleObject){
                        if (k.getId().equals(i.getPaperId().substring(0,3)) && !i.getPaperId().equals(k.getArticle1()) && !i.getPaperId().equals(k.getArticle2()) && !i.getPaperId().equals(k.getArticle3()) && !i.getPaperId().equals(k.getArticle4()) && !i.getPaperId().equals(k.getArticle5())){
                            if (k.getArticle1() == null){
                                k.setArticle1(i.getPaperId());
                            }
                            else if (k.getArticle2() == null){
                                k.setArticle2(i.getPaperId());
                            }
                            else if (k.getArticle3() == null){
                                k.setArticle3(i.getPaperId());
                            }
                            else if (k.getArticle4() == null) {
                                k.setArticle4(i.getPaperId());
                            }
                            else if (k.getArticle5() == null) {
                                k.setArticle5(i.getPaperId());
                            }
                        }
                    }
                }
                finalText += "*************************** Complete All Successful ****************************" + "\n" + "\n";
            }
            else if (commandsArray[0].equals("del")){
                for(Author i: authorObject){
                    if (i.getId().equals(commandsArray[1])){
                        authorObject.remove(i);
                        break;
                    }
                }
                finalText += "******************************* del Successful *********************************" + "\n" + "\n";
            }
            else if (commandsArray[0].equals("sortedAll")){
                for (Author i: authorObject){
                    i.sortArticles();
                }
                finalText += "**************************** SortedAll Successful ******************************" + "\n" + "\n";
            }
        }
        brOutput.write(finalText);
        brOutput.flush();
    }
}