package operasales.services.interfaces;

import operasales.domain.PremiereMain;

import java.util.Collection;

public interface PremiereService {

    Collection<PremiereMain> getAll();

    PremiereMain getPremiere(String title);

    boolean addPremiere(PremiereMain premiereMain);

    PremiereMain updatePremiere(PremiereMain premiereMain);

    void deletePremiere(int id);
}
