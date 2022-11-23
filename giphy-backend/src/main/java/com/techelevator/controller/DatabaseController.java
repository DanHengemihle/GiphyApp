package com.techelevator.controller;

import com.techelevator.dao.GiphyDao;
import com.techelevator.model.GifDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DatabaseController {

    @Autowired
    GiphyDao giphyDao;

    @PostMapping("/add")
    public GifDetail saveToDatabase(@RequestBody GifDetail detail){
//        System.out.println(detail);
        return giphyDao.saveGiphy(detail);
    }
}
