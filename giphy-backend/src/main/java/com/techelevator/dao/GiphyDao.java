package com.techelevator.dao;

import com.techelevator.model.GifDetail;

import java.util.List;

public interface GiphyDao {

    //CRUD
    GifDetail saveGiphy(GifDetail gif);  // CREATE

    List<GifDetail> getAllGiphys();  // READ

    GifDetail getGiphyById(int id); // READ one from db

}
