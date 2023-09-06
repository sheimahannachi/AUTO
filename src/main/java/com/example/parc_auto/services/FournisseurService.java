package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Fournisseur;
import com.example.parc_auto.repositories.FournisseurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository FournisseurRepository;

    public Fournisseur ajouterFournisseur(Fournisseur fournisseur) {
        return FournisseurRepository.save(fournisseur);
    }

    public Fournisseur modifierFournisseur(int idFournisseur, Fournisseur fournisseurModifié) {
        Optional<Fournisseur> fournisseurExistant = FournisseurRepository.findById(idFournisseur);
        if (fournisseurExistant.isPresent()) {
            Fournisseur fournisseur = fournisseurExistant.get();

            fournisseur.setAdresse(fournisseurModifié.getAdresse());
            fournisseur.setTelephone(fournisseurModifié.getTelephone());



            return FournisseurRepository.save(fournisseur);
        }
        return null;
    }

    public void supprimerFournisseur(int idFournisseur) {
        FournisseurRepository.deleteById(idFournisseur);
    }

    public Fournisseur chercherFournisseurParId(int idFournisseur) {
        Optional<Fournisseur> fournisseur = FournisseurRepository.findById(idFournisseur);
        return fournisseur.orElse(null);
    }

    public List<Fournisseur> obtenirTousLesFournisseurs() {
        return FournisseurRepository.findAll();
    }
}
