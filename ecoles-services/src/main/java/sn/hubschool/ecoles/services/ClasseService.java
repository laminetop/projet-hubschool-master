package sn.hubschool.ecoles.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import sn.hubschool.ecoles.model.Classe;
import sn.hubschool.ecoles.model.Ecole;
import sn.hubschool.ecoles.repos.ClasseSimpleRepository;

import java.util.List;


@CrossOrigin("*")
@RestController
public class ClasseService {

@Autowired
private ClasseSimpleRepository classeSimpleRepository;




    @RequestMapping(value="/classes")
    public Page<Classe> chargerClasse(@RequestParam(name = "ecole") Ecole ecole, int page,int size
                                     )
    {
        return classeSimpleRepository.findByEcole(ecole,new PageRequest(page,size));
    }


    @RequestMapping(value = "/classes", method = RequestMethod.POST)
    public Classe save(@RequestBody Classe classe){

        return classeSimpleRepository.save(classe);
    }

    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public List<Classe> liteClasse (){

        return classeSimpleRepository.findAll();
    }
}
