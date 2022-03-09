import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack {
    public static ArrayList<Integer> numbers = new ArrayList<Integer>();

    public Stack(){
    }

    public void push(int number){
        if (!isFull())
            numbers.add(number);
    }
    public int pop(){
        if (isEmpty()) throw new NoSuchElementException();
        int temp;
        temp = numbers.get(numbers.size() - 1);
        numbers.remove(numbers.size() - 1);
        return temp;
    }
    public int top(){
        if (isEmpty()) throw new NoSuchElementException();
        return numbers.get(numbers.size()-1);
    }
    public static boolean isFull(){
        if (numbers.size() == 20){
            return true;
        }
        else return false;
    }
    public static boolean isEmpty(){
        if (numbers.size() > 0){
            return false;
        }
        else return true;
    }
    public int size(){
        return numbers.size();
    }

}
