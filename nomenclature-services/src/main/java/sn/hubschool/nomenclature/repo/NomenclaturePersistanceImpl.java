package sn.hubschool.nomenclature.repo;

import sn.hubschool.nomenclature.domain.vo.Nomenclature;
import sn.hubschool.nomenclature.model.NomenclatureEntite;
import sn.hubschool.nomenclature.utils.Constantes;
import sn.hubschool.nomenclature.utils.NomenclatureUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

/**
 * L'implémentation de la couche persistance d'un objet Nomenclature.
 * 
 */
@Repository("nomenclaturePersistance")
public class NomenclaturePersistanceImpl implements INomenclaturePersistance {

	/** Le gestionnaire des entités. */
	@PersistenceContext
	private EntityManager entityManager;

	private static final Log LOG = LogFactory.getLog(NomenclaturePersistanceImpl.class);

	/**
	 * {@inheritDoc}
	 */
	// Rechercher une nommenclature par son code
	@Override
	public Nomenclature rechercherParCode(final String codeNomenclature) {
		final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_NOMENCLATURE_PAR_CODE);
		requete.setParameter(Constantes.PARAM_CODENOMENCLATURE, codeNomenclature);

		List < ? > nomenclaturesEnBase = requete.getResultList();
		Nomenclature nomenclature = null;

		if (nomenclaturesEnBase != null && nomenclaturesEnBase.size() == 1) {
			NomenclatureEntite nomenclatureEntite = (NomenclatureEntite) nomenclaturesEnBase.get(0);
			nomenclature = new Nomenclature();
			NomenclatureUtil.copie(nomenclatureEntite, nomenclature);
		}
		return nomenclature;
	}

	/**
	 * {@inheritDoc}
	 */

	// Lister les nomenlatures
	@Override
	public  List < Nomenclature > lister() {
		final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_NOMENCLATURE);
		final List < ? > nomenclaturesEnBase = requete.getResultList();
		final List < Nomenclature > nomenclatures = new ArrayList < Nomenclature >();

		if (nomenclaturesEnBase != null) {
			NomenclatureEntite nomenclatureEntite = null;
			Nomenclature nomenclature = null;

			for (Object o : nomenclaturesEnBase) {
				nomenclatureEntite = (NomenclatureEntite) o;
				nomenclature = new Nomenclature();
				NomenclatureUtil.copie(nomenclatureEntite, nomenclature);
				nomenclatures.add(nomenclature);
			}
		}
		return nomenclatures;
	}

	/**
	 * {@inheritDoc}
	 */
	// Rechercher les nommenclatures avec des liens
	@Override
	public  List < Nomenclature > rechercherNomenclaturesAvecLiens() {
		final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_ALL_NOMENS_ET_LIEN_ENTRE_NOMENS);
		final List < ? > nomenclaturesEnBase = requete.getResultList();
		final List < Nomenclature > nomenclatures = new ArrayList < Nomenclature >();
		Map < String, Nomenclature > nomenclatureDejaTraitees = null;

		if (nomenclaturesEnBase != null) {
			NomenclatureEntite nomenclatureEntite = null;
			NomenclatureEntite newNomenclatureLiee = null;
			Nomenclature nomenclature = null;
			Nomenclature nomenclatureDejaTraitee = null;
			nomenclatureDejaTraitees = new HashMap < String, Nomenclature >(1);

			for (Object o : nomenclaturesEnBase) {
				Object[] resultat = (Object[]) o;
				nomenclatureEntite = (NomenclatureEntite) resultat[0];

				nomenclatureDejaTraitee = nomenclatureDejaTraitees.get(nomenclatureEntite.getCode());
				if (nomenclatureDejaTraitee == null) {
					// On la transforme en VO leger
					nomenclature = new Nomenclature();
					NomenclatureUtil.copie(nomenclatureEntite, nomenclature);
					nomenclatures.add(nomenclature);
					nomenclatureDejaTraitees.put(nomenclature.getCode(), nomenclature);
				}
			}

			// A ce stade, la map contient l'ensemble des nomenclatures legères (cad sans les liens entre nomenclatures)
			for (Object o : nomenclaturesEnBase) {
				Object[] resultat = (Object[]) o;
				nomenclatureEntite = (NomenclatureEntite) resultat[0];
				newNomenclatureLiee = (NomenclatureEntite) resultat[1];

				if (newNomenclatureLiee != null) {
					// La nomenclature est liée à une autre nomenclature
					nomenclature = nomenclatureDejaTraitees.get(nomenclatureEntite.getCode());
					// On récupère sa liste des nomenclatures liées
					NomenclatureUtil.ajouteCodeNomenclatureLie(nomenclature, newNomenclatureLiee.getCode());
					nomenclatureDejaTraitees.put(nomenclatureEntite.getCode(), nomenclature);

					// Il faut maintenant relié la 2ième nomenclature à la première
					nomenclature = nomenclatureDejaTraitees.get(newNomenclatureLiee.getCode());
					// On récupère sa liste des nomenclatures liées
					NomenclatureUtil.ajouteCodeNomenclatureLie(nomenclature, nomenclatureEntite.getCode());
					nomenclatureDejaTraitees.put(newNomenclatureLiee.getCode(), nomenclature);
				}
			}
		}

		List < Nomenclature > results = null;
		if (nomenclatureDejaTraitees != null) {
			results = new ArrayList < Nomenclature >(nomenclatureDejaTraitees.size());
			for (Nomenclature n : nomenclatureDejaTraitees.values()) {
				results.add(n);
			}
		}
		return results;
	}

	/**
	 * {@inheritDoc}
	 */
	// Rechercher une nomenclature par lien de nomenclature1
	@Override
	public  Nomenclature rechercherNomenclatureParLienNomenclature1(final String codeNomenclature,
		final String codeNomenclature1) {
		final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_NOMENCLATURE_PAR_CODE);
		requete.setParameter(Constantes.PARAM_CODENOMENCLATURE, codeNomenclature);
		NomenclatureEntite nomenclatureEntite = null;
		Nomenclature nomenclature = null;
		boolean found = false;
		try {
			nomenclatureEntite = (NomenclatureEntite) requete.getSingleResult();
			List < NomenclatureEntite > nomenclature1s = nomenclatureEntite.getNomenclature1();
			for (NomenclatureEntite nomenclature1 : nomenclature1s) {
				// Si le code de la nomenclature de droite correspond au code <code>codeNomenclature1</code>
				if (nomenclature1.getCode().equals(codeNomenclature1)) {
					found = true;
				}
			}

			if (found) {
				nomenclature = new Nomenclature();
				NomenclatureUtil.copie(nomenclatureEntite, nomenclature);
			}
		} catch (NoResultException nre) {
			LOG.error("la nomenclature " + codeNomenclature + " n'existe pas ");

		}
		return nomenclature;
	}

	/**
	 * {@inheritDoc}
	 */
	// Rechercher une nomenclature par lien de nomenclature2
	@Override
	public  Nomenclature rechercherNomenclatureParLienNomenclature2(final String codeNomenclature,
		final String codeNomenclature2) {
		final Query requete = entityManager.createNamedQuery(Constantes.REQUETE_RECHERCHER_NOMENCLATURE_PAR_CODE);
		requete.setParameter(Constantes.PARAM_CODENOMENCLATURE, codeNomenclature);
		NomenclatureEntite nomenclatureEnBase = null;
		Nomenclature nomenclature = null;
		boolean found = false;
		try {
			nomenclatureEnBase = (NomenclatureEntite) requete.getSingleResult();
			List < NomenclatureEntite > nomenclature2s = nomenclatureEnBase.getNomenclature2();
			for (NomenclatureEntite nomenclature2 : nomenclature2s) {
				// Si le code de la nomenclature de gauche correspond au code <code>codeNomenclature1</code>
				if (nomenclature2.getCode().equals(codeNomenclature2)) {
					found = true;
				}
			}

			if (found) {
				nomenclature = new Nomenclature();
				NomenclatureUtil.copie(nomenclatureEnBase, nomenclature);
			}
		} catch (NoResultException nre) {
			LOG.error("la nomenclature " + codeNomenclature + " n'existe pas ");

		}
		return nomenclature;
	}
}
