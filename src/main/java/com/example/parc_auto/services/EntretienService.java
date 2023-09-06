package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Entretien;
import com.example.parc_auto.repositories.EntretienRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EntretienService {

    @Autowired
    private EntretienRepository EntretienRepository;

    public Entretien ajouterEntretien(Entretien entretien) {
        return EntretienRepository.save(entretien);
    }

    public Entretien modifierEntretien(Integer idEntretien, Entretien entretienModifié) {
        Optional<Entretien> entretienExistant = EntretienRepository.findById(idEntretien);
        if (entretienExistant.isPresent()) {
            Entretien entretien = entretienExistant.get();

            entretien.setOperation_entretien(entretienModifié.getOperation_entretien());


            return EntretienRepository.save(entretien);
        }
        return null;
    }

    public void supprimerEntretien(Integer idEntretien) {
        EntretienRepository.deleteById(idEntretien);
    }

    public Entretien chercherEntretienParId(Integer idEntretien) {
        Optional<Entretien> Entretien = EntretienRepository.findById(idEntretien);
        return Entretien.orElse(null);
    }

    public List<Entretien> obtenirTousLesEntretiens() {
        return EntretienRepository.findAll();
    }
}

