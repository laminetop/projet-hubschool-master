package sn.hubschool.ecoles.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import sn.hubschool.ecoles.model.Ecole;
import sn.hubschool.ecoles.repos.EcoleSimpleRepository;

import java.util.List;


@CrossOrigin("*")
@RestController
public class EcoleService {

    @Autowired
   private EcoleSimpleRepository ecoleSimpleRepository;

    @RequestMapping(value="/ecoles", method = RequestMethod.GET)
public Page<Ecole> chercherEcoles(@RequestParam(name = "mc",defaultValue = "") String mc,
                                 @RequestParam(name = "page",defaultValue = "0")int page,
                                 @RequestParam(name = "size",defaultValue = "5")int size)
    {
   return ecoleSimpleRepository.findAllByName("%"+mc+"%",new PageRequest(page,size));
}

@RequestMapping(value = "/ecoless/{id}", method = RequestMethod.GET)
   public  Ecole getEcole(@PathVariable Long id){

       return ecoleSimpleRepository.findOne(id);
    }


    @RequestMapping(value = "/ecoless", method = RequestMethod.GET)
    public  List<Ecole> listerEcole(){

       return ecoleSimpleRepository.findAll();
    }


    @RequestMapping(value = "/ecoles", method = RequestMethod.POST)
    public  Ecole save(@RequestBody Ecole ecole){

        return ecoleSimpleRepository.save(ecole);
    }

    @RequestMapping(value="/ecole", method = RequestMethod.GET)
    public Ecole chercherParNom(@RequestParam(name = "nom") String nom)
    {
        return ecoleSimpleRepository.findEcoleByName(nom);
    }
}
