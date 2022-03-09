import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Methods.sendFile(args[0],args[1],args[2],args[3]);
        Methods.printFile(args[4]);
    }
}