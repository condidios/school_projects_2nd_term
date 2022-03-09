public class Item {
    private String s = new String(" 2000 ");
    public void append(String a){
        s += a;
    }
    public void op2(){
        append(".1 ");

    }
    public void op3(){
        append(".2 ");
    }
    public void op4(){
        append(".3 ");
    }
    public String toString(){
        return s;
    }
}
