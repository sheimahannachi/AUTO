package com.example.parc_auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.services.DotationService;
import com.example.parc_auto.entities.Dotation;
import java.util.List;

@RestController
@RequestMapping("api/tab_dotation")
public class DotationController {

    @Autowired
    private DotationService DotationService;

    @PostMapping
    public ResponseEntity<Dotation> ajouterDotation(@RequestBody Dotation dotation) {
        Dotation nouvelleDotation = DotationService.ajouterDotation(dotation);
        return ResponseEntity.ok(nouvelleDotation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dotation> modifierDotation(
            @PathVariable int id,
            @RequestBody Dotation dotationModifiée) {
        Dotation dotationMiseAJour = DotationService.modifierDotation(id, dotationModifiée);
        if (dotationMiseAJour != null) {
            return ResponseEntity.ok(dotationMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerDotation(@PathVariable int id) {
        DotationService.supprimerDotation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dotation> obtenirDotationParId(@PathVariable int id) {
        Dotation dotation = DotationService.chercherDotationParId(id);
        if (dotation != null) {
            return ResponseEntity.ok(dotation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Dotation>> obtenirToutesLesDotations() {
        List<Dotation> dotations = DotationService.obtenirToutesLesDotations();
        return ResponseEntity.ok(dotations);
    }
}
