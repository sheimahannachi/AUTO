package com.example.parc_auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.services.EntretienService;
import com.example.parc_auto.entities.Entretien;
import java.util.List;

@RestController
@RequestMapping("api/tab_entretien")
public class EntretienController {

    @Autowired
    private EntretienService entretienService;

    @PostMapping
    public ResponseEntity<Entretien> ajouterEntretien(@RequestBody Entretien entretien) {
        Entretien nouveauEntretien = entretienService.ajouterEntretien(entretien);
        return ResponseEntity.ok(nouveauEntretien);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entretien> modifierEntretien(
            @PathVariable int id,
            @RequestBody Entretien entretienModifié) {
        Entretien entretienMiseAJour = entretienService.modifierEntretien(id, entretienModifié);
        if (entretienMiseAJour != null) {
            return ResponseEntity.ok(entretienMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerEntretien(@PathVariable int id) {
        entretienService.supprimerEntretien(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entretien> obtenirEntretienParId(@PathVariable int id) {
        Entretien entretien = entretienService.chercherEntretienParId(id);
        if (entretien != null) {
            return ResponseEntity.ok(entretien);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Entretien>> obtenirTousLesEntretiens() {
        List<Entretien> entretiens = entretienService.obtenirTousLesEntretiens();
        return ResponseEntity.ok(entretiens);
    }
}

