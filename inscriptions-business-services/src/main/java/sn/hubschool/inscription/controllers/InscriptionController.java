package sn.hubschool.inscription.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.hubschool.inscription.domain.InscriptionDto;
import sn.hubschool.inscription.models.Inscription;
import sn.hubschool.inscription.services.IInscriptionService;

import java.util.List;

/**
 * Created by gueyealy on 04/01/2018.
 */
@RestController
@RequestMapping(value = "/api/inscriptions")
public class InscriptionController {

    @Autowired
    private IInscriptionService inscriptionService;


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Inscription create(@RequestBody @Validated InscriptionDto inscriptionDto) {

        return inscriptionService.create(inscriptionDto.getAnnee(),
                inscriptionDto.getIdEleve(), inscriptionDto.getIdClasse(), inscriptionDto.getMontant());


    }

    // supprimer une inscription
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        inscriptionService.supprimer(id);
    }

    // lister toutes les inscriptions de facon pagine
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Inscription> getInscriptions(Pageable pageable) {

        return inscriptionService.getInscriptions(pageable);
    }

    // lister les inscriptions pour une annee donnee de facon paginé
    @RequestMapping(value = "/{annee}", method = RequestMethod.GET)
    public Page<Inscription> getInscriptionsByAnnee(@PathVariable String annee,Pageable pageable) {

        return inscriptionService.findByAnnee(annee,pageable);
    }


    // de rechercher l'inscription d'un eleve pour une annee donne
    @RequestMapping(value = "/rechercher/{idEleve}/{annee}", method = RequestMethod.GET)
    public Inscription RechercherInscriptionByEleveAndAnnee(@PathVariable Long idEleve,@PathVariable String annee ) {

        return inscriptionService.findByEleveAndAnnee(idEleve,annee);
    }


    // de rechercher les inscriptions d'une classe pour une annee donnee
    @RequestMapping(value = "/{idClasse}/{annee}", method = RequestMethod.GET)
    public List<Inscription> RechercherInscriptionByClasseAndAnnee(@PathVariable Long idClasse,@PathVariable String annee ) {

        return inscriptionService.findByClasseAndAnnee(idClasse,annee);
    }
}
