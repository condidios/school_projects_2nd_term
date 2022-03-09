import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Queue {
    /**
     * For my priority queue algorithm, I simply added an attribute "order" to my token class. In the beginning of the code,
     * I declared an integer named "orderCounter" and set it's value to 0. When I added a token to my queue (When I add them
     * from the given file or when I add a token right back after spending some of it) I increased orderCounter by 1 so
     * for example the first token in the queue has 0 as order attribute and the second token has 1. So the latest the token
     * is added to the queue, the higher it's order. That way I can determine whether a token is added to the queue earlier
     * or later. That way I can get the earliest added token when there is 2 tokens of the same type with the same value.
     * When I sort the list, first I sort by order then by value so it gives me the right sorted list.
     */
    public ArrayList<Token> tokens = new ArrayList<>();

    public void enqueue(Token item){ //The method which adds tokens to Queue's arraylist
        tokens.add(item);
    }
    public void dequeue(Token item){ //The method which removes tokens from Queue's arraylist
        tokens.remove(item);
    }
    public void tokenCalculate(int valueTotal,String type){ //The method for calculating a tokens latest value after it is spent
        while (valueTotal > 0) {
            valueTotal -= Objects.requireNonNull(Methods.findBiggestPrio(tokens, type)).value;
            if (valueTotal >= 0) {
                tokens.remove(Methods.findBiggestPrio(tokens, type));
            }
            else {
                Methods.findBiggestPrio(tokens,type).value = valueTotal*-1;
            }
        }
    }
    public void arraySort(){ //The method for sorting the arraylist according to wanted output
        Collections.sort(tokens, Comparator.comparing(Token::getOrder));
        Collections.reverse(tokens);
        Collections.sort(tokens, Comparator.comparing(Token::getValue));
    }
}