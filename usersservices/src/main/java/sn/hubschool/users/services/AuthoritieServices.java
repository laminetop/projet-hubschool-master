package sn.hubschool.users.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.hubschool.users.Repository.AuthoritieRepository;

import sn.hubschool.users.models.Authoritie;


import java.util.List;

@CrossOrigin("*")
@RestController
public class AuthoritieServices {




    @Autowired
    private AuthoritieRepository authoritieRepository;


    @RequestMapping(value = "/authorities", method = RequestMethod.GET)
    public List<Authoritie> listerAuthorities(){

        return authoritieRepository.findAll();
    }

    @RequestMapping(value = "/authorities", method = RequestMethod.POST)
    public Authoritie save(@RequestBody Authoritie authoritie){

        return authoritieRepository.save(authoritie);
    }
}
