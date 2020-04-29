package com.ananth.demo.dao;

import com.ananth.demo.model.CinemaOwnership;
import java.util.List;



public interface CinemaOwnershipDao {

    List<CinemaOwnership> getCinemaOwnerships();
    CinemaOwnership addCinemaOwnershipDetail(CinemaOwnership cinemaOwnership);

}
