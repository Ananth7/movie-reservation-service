package com.ananth.demo.service;

import com.ananth.demo.dao.CinemaOwnershipDao;
import com.ananth.demo.model.CinemaOwnership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaOwnershipService {

    @Autowired
    CinemaOwnershipDao cinemaOwnershipDao;

    public List<CinemaOwnership> getCinemaOwnershipDetails() {
        return cinemaOwnershipDao.getCinemaOwnerships();
    }

    public boolean isUserOwnerOfCinema(String userId, String cinemaId) {
        List<CinemaOwnership> ownersOfCinema = cinemaOwnershipDao.getOwnersOfCinema(cinemaId);
        return ownersOfCinema.stream().filter(p -> p.getOwner_id().equals(userId)).count() == 1;
    }

    public CinemaOwnership addCinemaOwnership(CinemaOwnership cinemaOwnership) {
        return cinemaOwnershipDao.addCinemaOwnershipDetail(cinemaOwnership);
    }

}
