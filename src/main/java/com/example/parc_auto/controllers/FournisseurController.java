package com.example.parc_auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.services.FournisseurService;
import com.example.parc_auto.entities.Fournisseur;
import java.util.List;

@RestController
@RequestMapping("api/tab_fournisseur")
public class FournisseurController {

    @Autowired
    private FournisseurService FournisseurService;

    @PostMapping
    public ResponseEntity<Fournisseur> ajouterFournisseur(@RequestBody Fournisseur Fournisseur) {
        Fournisseur nouveauFournisseur = FournisseurService.ajouterFournisseur(Fournisseur);
        return ResponseEntity.ok(nouveauFournisseur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> modifierFournisseur(
            @PathVariable int id,
            @RequestBody Fournisseur fournisseurModifié) {
        Fournisseur fournisseurMiseAJour = FournisseurService.modifierFournisseur(id, fournisseurModifié);
        if (fournisseurMiseAJour != null) {
            return ResponseEntity.ok(fournisseurMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerFournisseur(@PathVariable int id) {
        FournisseurService.supprimerFournisseur(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> obtenirFournisseurParId(@PathVariable int id) {
        Fournisseur fournisseur = FournisseurService.chercherFournisseurParId(id);
        if (fournisseur != null) {
            return ResponseEntity.ok(fournisseur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Fournisseur>> obtenirTousLesFournisseurs() {
        List<Fournisseur> fournisseurs = FournisseurService.obtenirTousLesFournisseurs();
        return ResponseEntity.ok(fournisseurs);
    }
}

