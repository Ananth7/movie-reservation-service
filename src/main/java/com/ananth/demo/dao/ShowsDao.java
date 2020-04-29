package com.ananth.demo.dao;

import com.ananth.demo.model.Show;

import java.util.List;

public interface ShowsDao {

    List<Show> getShows();
    Show addShow(Show show);

}
