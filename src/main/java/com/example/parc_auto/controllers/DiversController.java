package com.example.parc_auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.entities.Divers;
import com.example.parc_auto.services.DiversService;
import java.util.List;

@RestController
@RequestMapping("api/tab_divers")
public class DiversController {

    @Autowired
    private DiversService diversService;

    @PostMapping
    public ResponseEntity<Divers> ajouterDivers(@RequestBody Divers divers) {
        Divers nouveauDivers = diversService.ajouterDivers(divers);
        return ResponseEntity.ok(nouveauDivers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Divers> modifierDivers(
            @PathVariable int id,
            @RequestBody Divers diversModifié) {
        Divers diversMiseAJour = diversService.modifierDivers(id, diversModifié);
        if (diversMiseAJour != null) {
            return ResponseEntity.ok(diversMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerDivers(@PathVariable int id) {
        diversService.supprimerDivers(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Divers> obtenirDiversParId(@PathVariable int id) {
        Divers divers = diversService.chercherDiversParId(id);
        if (divers != null) {
            return ResponseEntity.ok(divers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Divers>> obtenirTousLesDivers() {
        List<Divers> divers = diversService.obtenirTousLesDivers();
        return ResponseEntity.ok(divers);
    }
}
