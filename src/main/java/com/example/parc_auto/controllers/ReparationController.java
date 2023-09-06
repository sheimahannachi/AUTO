package com.example.parc_auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.services.ReparationService;
import com.example.parc_auto.entities.Reparation;

import java.util.List;

@RestController
@RequestMapping("api/tab_reparation")
public class ReparationController {

    @Autowired
    private ReparationService reparationService;

    @PostMapping
    public ResponseEntity<Reparation> ajouterReparation(@RequestBody Reparation reparation) {
        Reparation nouvelleReparation = reparationService.ajouterReparation(reparation);
        return ResponseEntity.ok(nouvelleReparation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reparation> modifierReparation(
            @PathVariable Integer id,
            @RequestBody Reparation reparationModifiée) {
        Reparation reparationMiseAJour = reparationService.modifierReparation(id, reparationModifiée);
        if (reparationMiseAJour != null) {
            return ResponseEntity.ok(reparationMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerReparation(@PathVariable Integer id) {
        reparationService.supprimerReparation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reparation> obtenirReparationParId(@PathVariable Integer id) {
        Reparation reparation = reparationService.chercherReparationParId(id);
        if (reparation != null) {
            return ResponseEntity.ok(reparation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Reparation>> obtenirToutesLesReparations() {
        List<Reparation> reparations = reparationService.obtenirToutesLesReparations();
        return ResponseEntity.ok(reparations);
    }
}

