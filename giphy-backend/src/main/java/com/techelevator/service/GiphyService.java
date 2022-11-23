package com.techelevator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Gif;
import com.techelevator.model.GifDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GiphyService {

    @Value("${giphy.api.url}")
    private String apiURL;
    @Value("${giphy.api.key}")
    private String apiKey;

    public List<Gif>  getSearchResults(String searchString){
        // set up the url to query the qiphy API
        String url = apiURL + apiKey + "&limit=30&q=" + searchString;

        // class for querying external APIs
        RestTemplate restTemplate = new RestTemplate();
        // because we have to "pick" through the nodes to get our info
        // we need to do some setup, including an httpentity object
        HttpEntity<String> httpEntity = new HttpEntity<>("");
        // Object mapper will let us walk through the nodes in the response
        ObjectMapper objectMapper = new ObjectMapper();
        // json node object also needed to walk through the response
        JsonNode jsonNode;

        // make the call to the api using restTemplate.exchange
        // sends back a response entity object of type String
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);

        // create an empty list of gifs
        List<Gif> gifList = new ArrayList<>();

        try {  // needed for the objectMapper.readTree method
            jsonNode = objectMapper.readTree(response.getBody());

            JsonNode root = jsonNode.path("data");
            for (int i = 0; i < root.size(); i++){
                //root is the json node starting at 'data'
                //path(i) says which object in the array we are going to
                // path("id") says which key are we grabbing data from
                String id = root.path(i).path("id").asText();
                String title = root.path(i).path("title").asText();
                // in order to get back just the gif, we have to format this
                // margaret did some investigation to figure this out
                String giphyUrl = "https://media.giphy.com/media/" +id + "/giphy.gif";
//                Gif gif = new Gif();
//                gif.setId(id);
//                gif.setTitle(title);
//                gif.setUrl(giphyUrl);
                Gif gif = new Gif(id, giphyUrl, title);
                gifList.add(gif);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return gifList;
    }


    public GifDetail getGiphyDetails(String id){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> httpEntity = new HttpEntity<>("");
        ObjectMapper objectMapper = new ObjectMapper();
        String apiUrl = "https://api.giphy.com/v1/gifs/" + id + "?api_key=" + apiKey;
        ResponseEntity<String> response =
                restTemplate.exchange(apiUrl, HttpMethod.GET, httpEntity, String.class);
        JsonNode jsonNode;

        try {
            jsonNode = objectMapper.readTree(response.getBody());
            JsonNode root = jsonNode.path("data");
//            String url = root.path("url").asText();
            String gifId = root.path("id").asText();
            // in order to get back just the gif, we have to format this
            // margaret did some investigation to figure this out
            String giphyUrl = "https://media.giphy.com/media/" +id + "/giphy.gif";
            String rating = root.path("rating").asText();
            String description = root.path("user").path("description").asText();
            String title = root.path("title").asText();
            String userName = root.path("username").asText();
            int height = root.path("images").path("preview").path("height").asInt();
            int width = root.path("images").path("preview").path("width").asInt();

            return new GifDetail(giphyUrl, gifId, rating, description, title, userName, height, width);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
