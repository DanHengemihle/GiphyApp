package com.techelevator.model;

public class Gif {

    private String id;
    private String url;
    private String title;

    public Gif(String id, String url, String title) {
        this.id = id;
        this.url = url;
        this.title = title;
    }

    public Gif() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Gif{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
