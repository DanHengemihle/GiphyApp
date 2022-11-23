package com.techelevator.model;

public class GifDetail {
    private int id; // from the database
    private String url; // for the image
    private String giphyId; // from the API
    private String rating;
    private String description;
    private String title;
    private String  userName;
    private int height;
    private int width;

    public GifDetail(int id, String url, String giphyId, String rating,
                     String description, String title, String userName,
                     int height, int width) {
        this.id = id;
        this.url = url;
        this.giphyId = giphyId;
        this.rating = rating;
        this.description = description;
        this.title = title;
        this.userName = userName;
        this.height = height;
        this.width = width;
    }

    public GifDetail(String url, String giphyId, String rating,
                     String description, String title, String userName, int height, int width) {
        this.url = url;
        this.giphyId = giphyId;
        this.rating = rating;
        this.description = description;
        this.title = title;
        this.userName = userName;
        this.height = height;
        this.width = width;
    }

    public GifDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGiphyId() {
        return giphyId;
    }

    public void setGiphyId(String giphyId) {
        this.giphyId = giphyId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "GifDetail{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", giphyId='" + giphyId + '\'' +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", userName='" + userName + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
