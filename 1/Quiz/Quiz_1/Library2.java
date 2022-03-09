
class NewItem extends Item {
    //Change a method:
    public void op1() {
        append(" n1 ");
    }

    public void op4() {
        super.op4();
        append(" n4 ");
    }
}

class NewNewItem extends NewItem {
    //Change a method:
    public void op2() {
        super.op2();
        append(" nn3 ");
    }

    public void op4() {
        append(" nn4 ");
    }
}

public class Library2 {
    //Test the new class:
    public static void main(String[] args) {
        NewNewItem x = new NewNewItem();
        x.op1();
        x.op2();
        x.op3();
        x.op4();
        System.out.println(x.toString());
    }
}

