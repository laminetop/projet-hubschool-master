package sn.hubschool.nomenclature.domain;

import sn.hubschool.nomenclature.domain.vo.Nomenclature;
import sn.hubschool.nomenclature.exception.FonctionnelleException;
import sn.hubschool.nomenclature.exception.IExceptionFactory;
import sn.hubschool.nomenclature.repo.INomenclaturePersistance;
import sn.hubschool.nomenclature.utils.Constantes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe domaine.
 */
@Service("nomenclatureDomaine")
public class NomenclatureDomaineImpl implements INomenclatureDomaine {

    @Autowired
    protected IExceptionFactory factory;
    /**
     * nomenclaturePersistance.
     */
    @Autowired
    private INomenclaturePersistance nomenclaturePersistance;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Nomenclature> rechercherNomenclatures() {
        return nomenclaturePersistance.lister();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nomenclature rechercherNomenclature(final String codeNomenclature) throws FonctionnelleException {

        final Nomenclature nomenclature;

        if (codeNomenclature == null) {
            nomenclature = nomenclaturePersistance.rechercherParCode("");
        } else {
            nomenclature = nomenclaturePersistance.rechercherParCode(codeNomenclature);
        }

        if (nomenclature == null) {
            factory.throwFonctionnalException(Constantes.ERR_NOMENCLATURE_NEXIST, codeNomenclature);
        }

        return nomenclature;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nomenclature rechercherNomenclatureParLibelle(final String libelleNomenclature) throws FonctionnelleException {

        final Nomenclature nomenclature = nomenclaturePersistance.rechercherParCode(libelleNomenclature);

        if (nomenclature == null) {
            factory.throwFonctionnalException(Constantes.ERR_NOMENCLATURE_NEXIST, libelleNomenclature);
        }

        return nomenclature;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Nomenclature> rechercherNomenclaturesAvecLiens() {
        return nomenclaturePersistance.rechercherNomenclaturesAvecLiens();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nomenclature rechercherNomenclatureParLienNomenclature1(final String codeNomenclature,
                                                                         final String codeNomenclature1) {
        return nomenclaturePersistance.rechercherNomenclatureParLienNomenclature1(codeNomenclature, codeNomenclature1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Nomenclature rechercherNomenclatureParLienNomenclature2(final String codeNomenclature,
                                                                         final String codeNomenclature2) {
        return nomenclaturePersistance.rechercherNomenclatureParLienNomenclature2(codeNomenclature, codeNomenclature2);
    }
}
