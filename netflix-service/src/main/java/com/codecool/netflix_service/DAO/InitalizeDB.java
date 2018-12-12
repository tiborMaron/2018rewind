package com.codecool.netflix_service.DAO;

import com.codecool.netflix_service.Model.Netflix;
import com.codecool.netflix_service.Repository.NetflixRepo;
import org.springframework.stereotype.Component;

@Component
public class InitalizeDB {

    public InitalizeDB(NetflixRepo netflixRepo){

        netflixRepo.save(new Netflix("lol", "haha", "hehe"));
        netflixRepo.save(new Netflix("On My Block", "A coming-of-age story about four bright, street-savvy friends navigating their way through high school in the gritty inner city of South Central Los Angeles. Dealing with the danger of getting their friend out of a gang and friends turning into romance, danger is constant.", "https://occ-0-1489-1490.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABXJoPVi8Kyv0dJUMlvkj0U9JbPo332_cpm6DAOdnZOGz5mggKTVc0tkBrkbTLTHs7S0jLhOQ0PCMkUzlXr9yvW7Ib3df6wcZad7GKe0KbPTeQw0KlGv_AatUeBpd-aBvXp9HX8Ezfg.jpg"));
        netflixRepo.save(new Netflix("Making a Murderer: Part Two", "Filmed over a 10-year period, Steven Avery, a DNA exoneree who, while in the midst of exposing corruption in local law enforcement, finds himself the prime suspect in a grisly new crime.","https://occ-0-1489-1490.1.nflxso.net/dnm/api/v5/rendition/412e4119fb212e3ca9f1add558e2e7fed42f8fb4/AAAABfCwOXqbKE8LFqOvr5R9mm3hih_RezlxboTDuhnrhWc1JKREkJU1WST52pNFz14Wj-6aCY3vUjqIfCe7usAPSwJiWizKTX9Ccj2RejmtUaJzQfYUssi88S_xQHTKbtzJSyF9yQ4h9w.jpg"));
        netflixRepo.save(new Netflix("13 Reasons Why: season two", "Follows teenager Clay Jensen, in his quest to uncover the story behind his classmate and crush, Hannah, and her decision to end her life.", "https://fyc.netflix.com/_assets/_img/titles/80117470.jpg"));
        netflixRepo.save(new Netflix("Last Chance U: INDY", "Intense look inside the world of junior college football, chronicling the stories of players and coaches in the classroom and on the field.", "kép"));
        netflixRepo.save(new Netflix("Bodyguard", "A contemporary thriller featuring the Royalty and Specialist Protection Branch of London's Metropolitan Police Service.", "dik"));
        netflixRepo.save(new Netflix("Fastest Car", "In a quarter mile drag race, drivers of exotic supercars go up against sleeper cars built and modified by dedicated gearheads.", "zsa"));
        netflixRepo.save(new Netflix("The Haunting of Hill House", "Flashing between past and present, a fractured family confronts haunting memories of their old home and the terrifying events that drove them from it.", "lol"));
        netflixRepo.save(new Netflix("Anne with an E: Season 2", "The adventures of a young orphan girl living in the late 19th century. Follow Anne as she learns to navigate her new life on Prince Edward Island, in this new take on L.M. Montgomery's classic novels.", "nane"));
        netflixRepo.save(new Netflix("Insatiable", "A disgraced, dissatisfied civil lawyer-turned-beauty pageant coach takes on a vengeful, bullied teenager as his client and has no idea what he's about to unleash upon the world.", "pék"));
        netflixRepo.save(new Netflix("Orange Is the New Black: Season 6", "Convicted of a decade old crime of transporting drug money to an ex-girlfriend, normally law-abiding Piper Chapman is sentenced to a year and a half behind bars to face the reality of how life-changing prison can really be.", "jóreggelt"));
    }
}
