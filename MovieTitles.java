import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieTitles {

    public static void main(String... args) {
        try {
            String substr = "Spider";
            URL url;
            HttpURLConnection con;
            int startPage=1;
            int totalPages = Integer.MAX_VALUE;
            String response;
            List<String> titles = new ArrayList<>();
            while (startPage <= totalPages) {
                url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" +substr + "&page="+startPage);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                con.setConnectTimeout(60000);
                con.setReadTimeout(60000);

                BufferedReader bufRead = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((response = bufRead.readLine()) != null) {
                    JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
                    totalPages = jsonObject.get("total_pages").getAsInt();
                    JsonArray data = jsonObject.getAsJsonArray("data");
                    for (int i = 0; i < data.size(); i++) {
                        titles.add(data.get(i).getAsJsonObject().get("Title").getAsString());
                    }
                }
                bufRead.close();
                startPage++;
            }
            Collections.sort(titles);
            //String[] movieTitles = titles.toArray(new String[0]);
            titles.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
