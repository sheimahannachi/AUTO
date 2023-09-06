package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Reparation;
import com.example.parc_auto.repositories.ReparationRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ReparationService {

    @Autowired
    private ReparationRepository ReparationRepository;

    public Reparation ajouterReparation(Reparation reparation) {
        return ReparationRepository.save(reparation);
    }

    public Reparation modifierReparation(Integer idReparation, Reparation reparationModifiée) {
        Optional<Reparation> reparationExistante = ReparationRepository.findById(idReparation);
        if (reparationExistante.isPresent()) {
            Reparation reparation = reparationExistante.get();

            reparation.setOperation_reparation(reparationModifiée.getOperation_reparation());

            return ReparationRepository.save(reparation);
        }
        return null;
    }

    public void supprimerReparation(Integer idReparation) {
        ReparationRepository.deleteById(idReparation);
    }

    public Reparation chercherReparationParId(Integer idReparation) {
        Optional<Reparation> Reparation = ReparationRepository.findById(idReparation);
        return Reparation.orElse(null);
    }

    public List<Reparation> obtenirToutesLesReparations() {
        return ReparationRepository.findAll();
    }
}
