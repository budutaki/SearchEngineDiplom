import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BooleanSearchEngine engine = new BooleanSearchEngine(new File("pdfs"));

        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true, StandardCharsets.UTF_8)
                ) {
                    final String word = in.readLine();
                    final List<PageEntry> result = engine.search(word);
                    out.println(listToJson(result));

                }
            }
        } catch (IOException e) {
            System.out.println("Server start failed");
            e.printStackTrace();
        }
    }

    private static String listToJson(List<PageEntry> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(list);
    }
}