package com.techelevator.dao;

import com.techelevator.model.GifDetail;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGiphyDao implements GiphyDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcGiphyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public GifDetail saveGiphy(GifDetail gif) {
        /*  From DB
        	id SERIAL PRIMARY KEY,
	        url varchar(100),
            giphy_id varchar(50),
            rating varchar(5),
            description varchar(500),
            title varchar(100),
            user_name varchar(100),
            height int,
            width int
         */
        String saveGiphy = "INSERT INTO giphy (url, giphy_id, rating, " +
                "description, title, user_name, height, width) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        int id = jdbcTemplate.queryForObject(saveGiphy, Integer.class, gif.getUrl(), gif.getGiphyId(), gif.getRating(),
                gif.getDescription(), gif.getTitle(), gif.getUserName(), gif.getHeight(), gif.getWidth());

        if (id != 0){
            return getGiphyById(id);
        }
        return null;
    }

    @Override
    public List<GifDetail> getAllGiphys() {
        String getGiphys = "SELECT * FROM giphy";
        SqlRowSet results = jdbcTemplate.queryForRowSet(getGiphys);
        List<GifDetail> gifDetails = new ArrayList<>();
        while(results.next()){
            gifDetails.add(mapRowToGifDetail(results));
        }
        return gifDetails;
    }

    @Override
    public GifDetail getGiphyById(int id) {
        String getGiphy = "SELECT * FROM giphy WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(getGiphy, id);
        if (results.next()) {
            return mapRowToGifDetail(results);
        }
        return null;
    }

    public GifDetail mapRowToGifDetail(SqlRowSet result){
        GifDetail gifDetail = new GifDetail();
        gifDetail.setId(result.getInt("id"));
        gifDetail.setUrl(result.getString("url"));
        gifDetail.setGiphyId(result.getString("giphy_id"));
        gifDetail.setRating(result.getString("rating"));
        gifDetail.setDescription(result.getString("description"));
        gifDetail.setTitle(result.getString("title"));
        gifDetail.setUserName(result.getString("user_name"));
        gifDetail.setHeight(result.getInt("height"));
        gifDetail.setWidth(result.getInt("width"));

        return gifDetail;
    }
}
