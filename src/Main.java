import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.*;

public class Main {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://my-json-server.typicode.com/SilviuCristian45/Parole/posts");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        StringBuilder content;
        try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            content = new StringBuilder();
            while ((line = input.readLine()) != null) {
                // Append each line of the response and separate them
                content.append(line);
                content.append(System.lineSeparator());
            }
        } finally {
            connection.disconnect();
        }

        //System.out.println(content);
        JSONArray obj = new JSONArray(content.toString());

        ArrayList<Post> elements = new ArrayList<>();

        for (int i = 0; i < obj.length(); i++)
        {
            elements.add(convertToPost(obj.getJSONObject(i)));
        }

        System.out.println(elements);

    }

    static Post convertToPost(JSONObject obj){
        Post p = new Post();
        p.setId(obj.getInt("id"));
        p.setTitle(obj.getString("title"));
        return p;
    }
}