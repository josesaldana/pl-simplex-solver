import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    public static void printf(String message, Object... variables) {
        System.out.printf(message, variables);
    }

    public static String readLine() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        return line;
    }
}
