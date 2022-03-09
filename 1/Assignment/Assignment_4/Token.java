public class Token {
    String id,type;
    int value,order;
    public Token(String id, String type, int value,int order){
        this.id = id;
        this.type = type;
        this.value = value;
        this.order = order;
    }

    public int getValue() {
        return value;
    }

    public int getOrder() {
        return order;
    }

}
