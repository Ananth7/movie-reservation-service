package com.ananth.demo.service;

import com.ananth.demo.dao.ShowsDao;
import com.ananth.demo.model.Show;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShowsService {
    private ShowsDao showsDao;

    public Show addShow(Show show) {
        return showsDao.addShow(show);
    }

    public List<Show> getShows() {
        return showsDao.getShows();
    }

}
