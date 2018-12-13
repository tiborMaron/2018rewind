package com.codecool.netflix_service.DAO;

import com.codecool.netflix_service.Model.Netflix;
import com.codecool.netflix_service.Repository.NetflixRepo;
import org.springframework.stereotype.Component;

@Component
public class InitalizeDB {

    public InitalizeDB(NetflixRepo netflixRepo){

        netflixRepo.save(new Netflix("On My Block", "A coming-of-age story about four bright, street-savvy friends navigating their way through high school in the gritty inner city of South Central Los Angeles. Dealing with the danger of getting their friend out of a gang and friends turning into romance, danger is constant.", "https://www.colorlines.com/sites/default/files/styles/twitter/public/images/articles/2018/01/colorlines-screenshot-my-block-trailer-title-card-now-013118.png?itok=RZsE8f1w"));
        netflixRepo.save(new Netflix("Making a Murderer: Part Two", "Filmed over a 10-year period, Steven Avery, a DNA exoneree who, while in the midst of exposing corruption in local law enforcement, finds himself the prime suspect in a grisly new crime.","https://hips.hearstapps.com/cos.h-cdn.co/assets/16/04/1453915977-making-a-murderer.jpg"));
        netflixRepo.save(new Netflix("13 Reasons Why: season two", "Follows teenager Clay Jensen, in his quest to uncover the story behind his classmate and crush, Hannah, and her decision to end her life.", "https://i2.wp.com/www.texasrighttolife.com/wp-content/uploads/2018/06/13reasonswhyfeature.jpg?fit=800%2C400&ssl=1"));
        netflixRepo.save(new Netflix("Last Chance U: INDY", "Intense look inside the world of junior college football, chronicling the stories of players and coaches in the classroom and on the field.", "https://cdn.business2community.com/wp-content/uploads/2018/08/last-chance-U-netflix-typography.jpg"));
        netflixRepo.save(new Netflix("Bodyguard", "A contemporary thriller featuring the Royalty and Specialist Protection Branch of London's Metropolitan Police Service.", "https://blog.screenweek.it/wp-content/uploads/2018/09/Bodyguard-01.jpg"));
        netflixRepo.save(new Netflix("Fastest Car", "In a quarter mile drag race, drivers of exotic supercars go up against sleeper cars built and modified by dedicated gearheads.", "https://media.licdn.com/media-proxy/ext?w=800&h=800&hash=n6NHjvIxnG31m0IPFnEf8jEwOb0%3D&ora=1%2CaFBCTXdkRmpGL2lvQUFBPQ%2CxAVta5g-0R6nlh8Tw1It6a2FowGz60oISIfYC2G8G2f1spyfNT-tdoDSeLChpEtOdSoBkBJkcrG-GGGiSp7oWMO4eI0izuuiX9C9fCAzRS5z109EwJRpG0l9s8KtQLjUJiFc07EJKH2eMp_LRGYHDi4F8PyuAdXUP2wk_3S8fJ2zOtRkaKNjpYYXk2wDrsDCB-A06r1hnGpw-0uJqr6jEAkm2Zr4OXuJDQ4RLm_RLdVUi6mN5iOyxVH8sXnY6sKXHZuMCY4H0Caj88nKWlKl2k5hmmMvzAc00JxFEXTd3sEnvnqjAMYKWEqsssPHG3GJ8JdH6jEMiMuQDkKOcC9fv1JmarGMuE9jILbO_wrV2wh3dttLRU1SjuWDXMOI-W-CUnNLO3CKWz9LrO3_vqO0St5cdqY0kfJoau85a1g2JNc"));
        netflixRepo.save(new Netflix("The Haunting of Hill House", "Flashing between past and present, a fractured family confronts haunting memories of their old home and the terrifying events that drove them from it.", "https://paranormaldailynews.com/wp-content/uploads/2018/10/f687a78765734d085793736ce3d354afe658dc5e-haunting-hill-house-1000-08_fd8469e301e91d4da5456dccaa466366_2000-800x400.jpeg"));
        netflixRepo.save(new Netflix("Anne with an E: Season 2", "The adventures of a young orphan girl living in the late 19th century. Follow Anne as she learns to navigate her new life on Prince Edward Island, in this new take on L.M. Montgomery's classic novels.", "https://i.pinimg.com/originals/9d/55/75/9d557555894d1dca55047f603058a5e8.jpg"));
        netflixRepo.save(new Netflix("Insatiable", "A disgraced, dissatisfied civil lawyer-turned-beauty pageant coach takes on a vengeful, bullied teenager as his client and has no idea what he's about to unleash upon the world.", "https://blog.screenweek.it/wp-content/uploads/2018/07/Insatiable.jpg"));
        netflixRepo.save(new Netflix("Orange Is the New Black: Season 6", "Convicted of a decade old crime of transporting drug money to an ex-girlfriend, normally law-abiding Piper Chapman is sentenced to a year and a half behind bars to face the reality of how life-changing prison can really be.", "https://media.women.com/images/images/000/139/547/large/orange-is-the-new-black-season-6-may_21__2018.jpg?1526680995"));
    }
}
