package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Dotation;
import com.example.parc_auto.repositories.DotationRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DotationService {

    @Autowired
    private DotationRepository DotationRepository;

    public Dotation ajouterDotation(Dotation dotation) {
        return DotationRepository.save(dotation);
    }

    public Dotation modifierDotation(Integer idDotation, Dotation dotationModifiée) {
        Optional<Dotation> dotationExistante = DotationRepository.findById(idDotation);
        if (dotationExistante.isPresent()) {
            Dotation dotation = dotationExistante.get();

            dotation.setMontant_totale(dotationModifiée.getMontant_totale());


            return DotationRepository.save(dotation);
        }
        return null;
    }

    public void supprimerDotation(Integer idDotation) {
        DotationRepository.deleteById(idDotation);
    }

    public Dotation chercherDotationParId(Integer idDotation) {
        Optional<Dotation> dotation = DotationRepository.findById(idDotation);
        return dotation.orElse(null);
    }

    public List<Dotation> obtenirToutesLesDotations() {
        return DotationRepository.findAll();
    }
}
