package com.codecool.netflix_service.Repository;


import com.codecool.netflix_service.Model.Netflix;
import com.codecool.netflix_service.NetflixServiceApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface NetflixRepo extends JpaRepository<Netflix, Long> {

}
