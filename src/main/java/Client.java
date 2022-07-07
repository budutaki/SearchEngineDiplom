import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.*;

public class Client {
    public static void main(String[] args) throws IOException {
        try (
                Socket socket = new Socket("localhost", 8989);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true, UTF_8)

        ) {
            out.println("разработка");
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb);
        }
    }
}






