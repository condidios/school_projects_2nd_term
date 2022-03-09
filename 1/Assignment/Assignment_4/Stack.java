import java.util.ArrayList;
import java.util.Collections;

public class Stack {
    String type;
    ArrayList<Items> items = new ArrayList<>();

    public Stack(String type){
        this.type = type;
    }
    public void push(Items item){ // The method for adding items to the given stack
        items.add(item);
    }

    public void pop(){
        /**
     I have stored items in each stack in arraylists and when I wanted to remove an item I simply
         removed the last index of the arraylist so it works like a stack.
     **/
        this.items.remove(this.items.get(items.size()-1));
    }
    public void sortItems(){ // The method for sorting the items according to the wanted output
        Collections.reverse(items);
    }
}
