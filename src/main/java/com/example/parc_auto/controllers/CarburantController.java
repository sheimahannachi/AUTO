package com.example.parc_auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.entities.Carburant;
import com.example.parc_auto.services.CarburantService;
import java.util.List;

@RestController
@RequestMapping("/tab_carburant")
public class CarburantController {

    @Autowired
    private CarburantService CarburantService;

    @PostMapping
    public ResponseEntity<Carburant> ajouterCarburant(@RequestBody Carburant carburant) {
        Carburant nouveauCarburant = CarburantService.ajouterCarburant(carburant);
        return ResponseEntity.ok(nouveauCarburant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carburant> modifierCarburant(
            @PathVariable int id,
            @RequestBody Carburant carburantModifié) {
        Carburant carburantMiseAJour = CarburantService.modifierCarburant(id, carburantModifié);
        if (carburantMiseAJour != null) {
            return ResponseEntity.ok(carburantMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCarburant(@PathVariable int id) {
        CarburantService.supprimerCarburant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carburant> obtenirCarburantParId(@PathVariable int id) {
        Carburant carburant = CarburantService.chercherCarburantParId(id);
        if (carburant != null) {
            return ResponseEntity.ok(carburant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Carburant>> obtenirTousLesCarburants() {
        List<Carburant> carburants = CarburantService.obtenirTousLesCarburants();
        return ResponseEntity.ok(carburants);
    }
}
