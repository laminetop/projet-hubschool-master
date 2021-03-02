package sn.hubschool.nomenclature.repo;

import sn.hubschool.nomenclature.domain.vo.Element;
import sn.hubschool.nomenclature.domain.vo.ElementAttributs;
import sn.hubschool.nomenclature.model.NomenclatureEntite;
import sn.hubschool.nomenclature.utils.Constantes;
import sn.hubschool.nomenclature.domain.vo.Nomenclature;
import sn.hubschool.nomenclature.utils.ElementAttributsUtil;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 * L'implémentation de la couche persistance d'un objet Lien.
 */
@Repository("lienPersistance")
public class LienPersistanceImpl implements ILienPersistance {

    /**
     * Unchecked.
     */
    private static final String UNCHECKED = "unchecked";
    /**
     * Le gestionnaire d'entités.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public  boolean verifierExistanceLienInf(final Element element1, final Element element2, final Date dateEffet) {

        StringTokenizer tokenizer = new StringTokenizer(element1.getId(), "/");
        final String codeNomenclature1 = tokenizer.nextToken();
        final String codeElement1 = tokenizer.nextToken();

        tokenizer = new StringTokenizer(element2.getId(), "/");
        final String codeNomenclature2 = tokenizer.nextToken();
        final String codeElement2 = tokenizer.nextToken();

        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_VERIFIER_EXISTANCE_LIEN_INF);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT1_LIEN, codeElement1);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT2_LIEN, codeElement2);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE1_LIEN, codeNomenclature1);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE2_LIEN, codeNomenclature2);

        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);

        final List<?> results = requete.getResultList();

        return !results.isEmpty();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public  boolean verifierExistanceLienInfNomenclatureDifferentes(final Nomenclature nomenclature, final Element element1,
                                                                    final Element element2, final Date dateEffet) {

        StringTokenizer tokenizer = new StringTokenizer(element1.getId(), "/");
        final String codeNomenclature1 = tokenizer.nextToken();
        final String codeElement1 = tokenizer.nextToken();

        tokenizer = new StringTokenizer(element2.getId(), "/");
        final String codeNomenclature2 = tokenizer.nextToken();
        final String codeElement2 = tokenizer.nextToken();

        final Query requete = entityManager
                .createNamedQuery(Constantes.REQUETE_VERIFIER_EXISTANCE_LIEN_INF_NOMENCLATURE_DIFFERENTES);

        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE, nomenclature.getCode());
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT1_LIEN, codeElement1);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE1_LIEN, codeNomenclature1);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT2_LIEN, codeElement2);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE2_LIEN, codeNomenclature2);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);

        final List<?> results = requete.getResultList();

        return !results.isEmpty();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public  boolean verifierExistanceLienSupNomenclatureDifferentes(final Nomenclature nomenclature, final Element element1,
                                                                         final Element element2, final Date dateEffet) {

        StringTokenizer tokenizer = new StringTokenizer(element1.getId(), "/");
        final String codeNomenclature1 = tokenizer.nextToken();
        final String codeElement1 = tokenizer.nextToken();

        tokenizer = new StringTokenizer(element2.getId(), "/");
        final String codeNomenclature2 = tokenizer.nextToken();
        final String codeElement2 = tokenizer.nextToken();

        final Query requete = entityManager
                .createNamedQuery(Constantes.REQUETE_VERIFIER_EXISTANCE_LIEN_SUP_NOMENCLATURE_DIFFERENTES);

        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE, nomenclature.getCode());
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT1_LIEN, codeElement1);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT2_LIEN, codeElement2);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE1_LIEN, codeNomenclature1);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE2_LIEN, codeNomenclature2);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);

        final List<?> results = requete.getResultList();

        return !results.isEmpty();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public  boolean verifierExistanceLienSup(final Element element1, final Element element2, final Date dateEffet) {

        StringTokenizer tokenizer = new StringTokenizer(element1.getId(), "/");
        final String codeNomenclature1 = tokenizer.nextToken();
        final String codeElement1 = tokenizer.nextToken();

        tokenizer = new StringTokenizer(element2.getId(), "/");
        final String codeNomenclature2 = tokenizer.nextToken();
        final String codeElement2 = tokenizer.nextToken();

        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_VERIFIER_EXISTANCE_LIEN_SUP);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT1_LIEN, codeElement1);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT2_LIEN, codeElement2);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE1_LIEN, codeNomenclature1);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE2_LIEN, codeNomenclature2);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);

        final List<?> results = requete.getResultList();

        return !results.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public  List<ElementAttributs> rechercherLiensSup(final Element element, final Date dateEffet) {

        final StringTokenizer tokenizer = new StringTokenizer(element.getId(), "/");

        final String codeNomenclature = tokenizer.nextToken();
        final String codeElement = tokenizer.nextToken();
        // recherche de la nomenclature entite. je n 'ai besoin pour le boolean.
        final NomenclatureEntite nomenclature = rechercherNomenclature(codeNomenclature);
        final boolean possessionAtriBExt = nomenclature.getLibelleAttributExterne() != null
                && nomenclature.getLibelleAttributExterne().trim().length() != 0;
        // recherche des liens Sup.
        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_LIENS_SUP);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT1_LIEN, codeElement);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE1_LIEN, codeNomenclature);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);
        // traitement des résultats.
        final List<?> elementAttributsEnBase = requete.getResultList();

        return ElementAttributsUtil.transformeElementAttributsEntiteEnElementAttributs(elementAttributsEnBase, codeNomenclature,
                possessionAtriBExt);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings(UNCHECKED)
    @Override
    public  List<String> rechercherCodeLiensSup(final String codeNomenclature, final String codeElement,
                                                     final Date dateEffet) {

        // Construction de la requête
        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_CODE_LIENS_SUP);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT1_LIEN, codeElement);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE1_LIEN, codeNomenclature);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);

        // Recherche des codes des liens inférieurs
        return requete.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public  List<ElementAttributs> rechercherLiensInf(final Element element, final Date dateEffet) {

        final StringTokenizer tokenizer = new StringTokenizer(element.getId(), "/");

        final String codeNomenclature = tokenizer.nextToken();
        final String codeElement = tokenizer.nextToken();

        // recherche de la nomenclature entite.
        final NomenclatureEntite nomenclature = rechercherNomenclature(codeNomenclature);
        final boolean possessionAtriBExt = nomenclature.getLibelleAttributExterne() != null
                && nomenclature.getLibelleAttributExterne().trim().length() != 0;
        // recherche des liens inférieurs
        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_LIENS_INF);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT2_LIEN, codeElement);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE2_LIEN, codeNomenclature);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);
        // traitement des résultats.
        final List<?> elementAttributsEnBase = requete.getResultList();

        return ElementAttributsUtil.transformeElementAttributsEntiteEnElementAttributs(elementAttributsEnBase, codeNomenclature,
                possessionAtriBExt);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings(UNCHECKED)
    @Override
    public  List<String> rechercherCodeLiensInf(final String codeNomenclature, final String codeElement,
                                                     final Date dateEffet) {

        // Construction de la requête
        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_CODE_LIENS_INF);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT2_LIEN, codeElement);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE2_LIEN, codeNomenclature);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);

        // Recherche des codes des liens inférieurs
        return requete.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public  List<ElementAttributs> rechercherLiensInfLex(final Nomenclature nomenclature, final Element element,
                                                              final Date dateEffet) {

        final StringTokenizer tokenizer = new StringTokenizer(element.getId(), "/");

        final String codeNomenclature = tokenizer.nextToken();
        final String codeElement = tokenizer.nextToken();
        final boolean possessionAtriBExt = nomenclature.getLibelleAttributExterne() != null
                && nomenclature.getLibelleAttributExterne().trim().length() != 0;
        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_LIENS_INF_LEX);

        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE, nomenclature.getCode());
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT2_LIEN, codeElement);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE2_LIEN, codeNomenclature);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);

        final List<?> elementAttributsEnBase = requete.getResultList();

        return ElementAttributsUtil.transformeElementAttributsEntiteEnElementAttributs(elementAttributsEnBase, codeNomenclature,
                possessionAtriBExt);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings(UNCHECKED)
    @Override
    public  List<String> rechercherCodeLiensInfLex(final String codeNomenclature, final String codeNomenclature1,
                                                        final String codeElement, final Date dateEffet) {

        // Construction de la requête
        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_CODE_LIENS_INF_LEX);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE, codeNomenclature);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT2_LIEN, codeElement);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE2_LIEN, codeNomenclature1);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);

        return requete.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public  List<ElementAttributs> rechercherLiensSupLex(final Nomenclature nomenclature, final Element element,
                                                              final Date dateEffet) {

        final StringTokenizer tokenizer = new StringTokenizer(element.getId(), "/");

        final String codeNomenclature = tokenizer.nextToken();
        final String codeElement = tokenizer.nextToken();
        final boolean possessionAtriBExt = nomenclature.getLibelleAttributExterne() != null
                && nomenclature.getLibelleAttributExterne().trim().length() != 0;

        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_LIENS_SUP_LEX);

        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE, nomenclature.getCode());
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT1_LIEN, codeElement);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE1_LIEN, codeNomenclature);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);

        final List<?> elementAttributsEnBase = requete.getResultList();

        return ElementAttributsUtil.transformeElementAttributsEntiteEnElementAttributs(elementAttributsEnBase, codeNomenclature,
                possessionAtriBExt);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings(UNCHECKED)
    @Override
    public  List<String> rechercherCodeLiensSupLex(final String codeNomenclature, final String codeNomenclature1,
                                                        final String codeElement, final Date dateEffet) {

        // Construction de la requête
        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_CODE_LIENS_SUP_LEX);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE, codeNomenclature);
        requete.setParameter(Constantes.ATTR_CODE_ELEMENT1_LIEN, codeElement);
        requete.setParameter(Constantes.ATTR_CODE_NOMENCLATURE1_LIEN, codeNomenclature1);
        requete.setParameter(Constantes.ATTR_DATE_EFFET_LIEN, dateEffet);

        return requete.getResultList();
    }

    /**
     * recherche NomenclatureEntite.
     *
     * @param codeNomenclature code de la nomenclature.
     * @return la nomenclature Entite recherché.
     */
    private NomenclatureEntite rechercherNomenclature(final String codeNomenclature) {
        final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_NOMENCLATURE_PAR_CODE);
        requete.setParameter(Constantes.PARAM_CODENOMENCLATURE, codeNomenclature);

        return (NomenclatureEntite) requete.getSingleResult();
    }
}
