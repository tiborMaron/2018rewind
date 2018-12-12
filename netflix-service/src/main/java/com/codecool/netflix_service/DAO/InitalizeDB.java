package com.codecool.netflix_service.DAO;

import com.codecool.netflix_service.Model.Netflix;
import com.codecool.netflix_service.Repository.NetflixRepo;
import org.springframework.stereotype.Component;

@Component
public class InitalizeDB {

    public InitalizeDB(NetflixRepo netflixRepo){
        netflixRepo.save(new Netflix("lol", "haha", "hehe"));


        netflixRepo.save(new Netflix("On My Block", "A coming-of-age story about four bright, street-savvy friends navigating their way through high school in the gritty inner city of South Central Los Angeles. Dealing with the danger of getting their friend out of a gang and friends turning into romance, danger is constant.", "https://m.media-amazon.com/images/M/MV5BNTkxZjQ1MDYtZThmNS00ZjZlLWI0NmYtMzY5MjA4OTllMjFkXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SY1000_CR0,0,675,1000_AL_.jpg"));
        netflixRepo.save(new Netflix("Making a Murderer: Part Two", "Filmed over a 10-year period, Steven Avery, a DNA exoneree who, while in the midst of exposing corruption in local law enforcement, finds himself the prime suspect in a grisly new crime.","https://m.media-amazon.com/images/M/MV5BMTg4Mjc1NjE4Ml5BMl5BanBnXkFtZTgwMjk2NjA1NjM@._V1_SY1000_CR0,0,674,1000_AL_.jpg"));
        netflixRepo.save(new Netflix("13 Reasons Why: season two", "Follows teenager Clay Jensen, in his quest to uncover the story behind his classmate and crush, Hannah, and her decision to end her life.", "https://fyc.netflix.com/_assets/_img/titles/80117470.jpg"));


        /*
        netflixRepo.save(new Netflix());
        netflixRepo.save(new Netflix());
        netflixRepo.save(new Netflix());
        netflixRepo.save(new Netflix());
        netflixRepo.save(new Netflix());
        netflixRepo.save(new Netflix());
        netflixRepo.save(new Netflix());
        */
    }
}
