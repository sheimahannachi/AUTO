package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.repositories.DiversRepository;
import com.example.parc_auto.entities.Divers;
import java.util.List;
import java.util.Optional;

@Service
public class DiversService {

    @Autowired
    private DiversRepository DiversRepository;

    public Divers ajouterDivers(Divers divers) {
        return DiversRepository.save(divers);
    }

    public Divers modifierDivers(int idDivers, Divers diversModifié) {
        Optional<Divers> diversExistant = DiversRepository.findById(idDivers);
        if (diversExistant.isPresent()) {
            Divers divers = diversExistant.get();

            divers.setOperation_divers(diversModifié.getOperation_divers());


            return DiversRepository.save(divers);
        }
        return null;
    }

    public void supprimerDivers(int idDivers) {
        DiversRepository.deleteById(idDivers);
    }

    public Divers chercherDiversParId(int idDivers) {
        Optional<Divers> divers = DiversRepository.findById(idDivers);
        return divers.orElse(null);
    }

    public List<Divers> obtenirTousLesDivers() {
        return DiversRepository.findAll();
    }
}
