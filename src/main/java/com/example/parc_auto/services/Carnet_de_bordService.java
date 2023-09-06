package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Carnet_de_bord;
import com.example.parc_auto.repositories.Carnet_de_bordRepository;
import java.util.List;
import java.util.Optional;

@Service
public class Carnet_de_bordService {

    @Autowired
    private Carnet_de_bordRepository Carnet_de_bordRepository;

    public Carnet_de_bord ajouterCarnetDeBord(Carnet_de_bord carnetDeBord) {
        return Carnet_de_bordRepository.save(carnetDeBord);
    }

    public Carnet_de_bord modifierCarnetDeBord(int idCarnetDeBord, Carnet_de_bord carnetDeBordModifié) {
        Optional<Carnet_de_bord> carnetDeBordExistant = Carnet_de_bordRepository.findById(idCarnetDeBord);
        if (carnetDeBordExistant.isPresent()) {
            Carnet_de_bord carnetDeBord = carnetDeBordExistant.get();

            carnetDeBord.setKilometrage_initial(carnetDeBordModifié.getKilometrage_initial());
            carnetDeBord.setKilometrage_sortie(carnetDeBordModifié.getKilometrage_sortie());
            carnetDeBord.setObsrevation(carnetDeBordModifié.getObsrevation());


            return Carnet_de_bordRepository.save(carnetDeBord);
        }
        return null;
    }

    public void supprimerCarnetDeBord(int idCarnetDeBord) {
        Carnet_de_bordRepository.deleteById(idCarnetDeBord);
    }

    public Carnet_de_bord chercherCarnetDeBordParId(int idCarnetDeBord) {
        Optional<Carnet_de_bord> Carnet_de_bord = Carnet_de_bordRepository.findById(idCarnetDeBord);
        return Carnet_de_bord.orElse(null);
    }

    public List<Carnet_de_bord> obtenirTousLesCarnetsDeBord() {
        return Carnet_de_bordRepository.findAll();
    }
}
