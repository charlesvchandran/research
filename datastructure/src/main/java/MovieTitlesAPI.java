import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MovieTitlesAPI {
    static Logger logger = LoggerFactory.getLogger(MovieTitlesAPI.class.getSimpleName());
    public static void main(String[] args) {
        logger.info("from MovieTitlesAPI");
        String[] titles = new MovieTitlesAPI().getMovieTitles("Spider");
        Arrays.asList(titles).forEach(System.out::println);
    }

    private String getMovieURL(String searchStr) {
       return new StringBuilder("https://jsonmock.hackerrank.com/api/movies/search/?Title=")
                                            .append(searchStr).append("&page=").toString();
    }

    private String[] getMovieTitles(String searchStr) {
        logger.info("getMovieTitles :: substr:: " + searchStr);
        String movieURL = getMovieURL(searchStr);
        int startPage = 1;
        int totalPages = Integer.MAX_VALUE;
        String response;
        List<String> titles = new ArrayList<>();
        URL url;
        HttpURLConnection httpConn;
        try {
            while (startPage <= totalPages) {
                url = new URL(new StringBuilder(movieURL).append(startPage).toString());
                httpConn = (HttpURLConnection) url.openConnection();
                httpConn.setReadTimeout(60000);
                httpConn.setConnectTimeout(60000);
                httpConn.setRequestMethod("GET");
                httpConn.setRequestProperty("Content-Type", "application/json");

                BufferedReader bufRead = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                while ( (response = bufRead.readLine()) != null ) {
                    JsonObject jsonObj = new Gson().fromJson(response, JsonObject.class);
                    totalPages = jsonObj.get("total_pages").getAsInt();
                    JsonArray data = jsonObj.getAsJsonArray("data");
                    for (int i=0; i<data.size(); i++) {
                        titles.add(data.get(i).getAsJsonObject().get("Title").getAsString());
                    }
                }
                bufRead.close();
                startPage++;
            }
            Collections.sort(titles);
        } catch (MalformedURLException e) {
            logger.error("IOException thrown!", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titles.toArray(new String[0]);
    }
}
