package sn.hubschool.inscription.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import sn.hubschool.inscription.controllers.Status;
import sn.hubschool.inscription.domain.Classe;
import sn.hubschool.inscription.domain.Eleve;
import sn.hubschool.inscription.models.Inscription;
import sn.hubschool.inscription.repos.InscriptionRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by gueyealy on 18/12/2017.
 */
@Service
public class InscriptionServiceImpl implements IInscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static String URL_BASE_ELEVE = "http://ELEVESSERVICES";
    private static String URL_BASE_CLASSE = "http://ECOLESSERVICES";


    @Override
    public Page<Inscription> findByAnnee(String annee, Pageable pageable) {
        return inscriptionRepository.findByAnnee(annee, pageable);
    }

    @Override
    public List<Inscription> findByEleve(Long idEleve) {
        return inscriptionRepository.findByEleve(idEleve);
    }

    @Override
    public Page<Inscription> findByClasse(Long idClasse, Pageable pageable) {
        return inscriptionRepository.findByClasse(idClasse, pageable);
    }

    @Override
    public Inscription findFirstByEleveAndAnnee(Long idEleve, String annee) {
        return inscriptionRepository.findFirstByEleveAndAnnee(idEleve, annee);
    }

    @Override
    public Inscription create(String annee, Long idEleve, Long idClasse, Double montant) {


        // verifie que la classe existe

        Classe classe = restTemplate.getForEntity(URL_BASE_CLASSE + "/api/classes/" + idClasse, Classe.class).getBody();
        if (classe == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "classe inconnu");
        }
        // verifie si l'eleve existe
        Eleve eleve = restTemplate.getForEntity(URL_BASE_ELEVE + "/api/eleves/" + idEleve, Eleve.class).getBody();
        if (eleve == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "eleve inconnu");
        }


        // verifie que l'eleve n'est pas deja inscrit pour l'annee scolaire dans la meme classe

        Inscription inscriptionExistant = inscriptionRepository.findFirstByEleveAndAnnee(idEleve, annee);

        if (inscriptionExistant != null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Eleve deja inscrit");
        }


        Inscription ins = new Inscription();
        ins.setEleve(idEleve);
        ins.setClasse(idClasse);
        ins.setMontant(montant);
        ins.setAnnee(annee);
        ins.setStatus(Status.ENCOURS);
        ins.setDate(new Date());

        return inscriptionRepository.save(ins);

    }

    @Override
    public void supprimer(Long id) {
         Inscription ins=inscriptionRepository.findById(id);
        if(ins==null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Incription introuvable");
        }
        inscriptionRepository.delete(id);
    }

    @Override
    public Page<Inscription> getInscriptions(Pageable pageable)
    {
        return inscriptionRepository.findAll(pageable);
    }


    @Override
    @Transactional
    public Inscription validatePaiement(Long inscriptionId, double montant) {

        return null;
    }

    @Override
    public List<Inscription> findByClasseAndAnnee(Long idClasse, String annee) {
        return inscriptionRepository.findByClasseAndAnnee(idClasse, annee);
    }

    @Override
    public Inscription findByEleveAndAnnee(Long idEleve, String annee) {

        Inscription ins = inscriptionRepository.findFirstByEleveAndAnnee(idEleve, annee);
        if (ins == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Inscription introuvable");
        }
            return ins;
    }

    @Override
    public Inscription findById(Long id) {
        return inscriptionRepository.findOne(id);
    }
}
