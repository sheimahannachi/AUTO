package com.example.parc_auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.services.Carnet_de_bordService;
import com.example.parc_auto.entities.Carnet_de_bord;
import java.util.List;

@RestController
@RequestMapping("/tab_carnet_de_bord")
public class Carnet_de_bordController {

    @Autowired
    private Carnet_de_bordService Carnet_de_bordService;

    @PostMapping
    public ResponseEntity<Carnet_de_bord> ajouterCarnetDeBord(@RequestBody Carnet_de_bord carnetDeBord) {
        Carnet_de_bord nouveauCarnetDeBord = Carnet_de_bordService.ajouterCarnetDeBord(carnetDeBord);
        return ResponseEntity.ok(nouveauCarnetDeBord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carnet_de_bord> modifierCarnetDeBord(
            @PathVariable int id,
            @RequestBody Carnet_de_bord carnetDeBordModifié) {
        Carnet_de_bord carnetDeBordMiseAJour = Carnet_de_bordService.modifierCarnetDeBord(id, carnetDeBordModifié);
        if (carnetDeBordMiseAJour != null) {
            return ResponseEntity.ok(carnetDeBordMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCarnetDeBord(@PathVariable int id) {
        Carnet_de_bordService.supprimerCarnetDeBord(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carnet_de_bord> obtenirCarnetDeBordParId(@PathVariable int id) {
        Carnet_de_bord carnetDeBord = Carnet_de_bordService.chercherCarnetDeBordParId(id);
        if (carnetDeBord != null) {
            return ResponseEntity.ok(carnetDeBord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Carnet_de_bord>> obtenirTousLesCarnetsDeBord() {
        List<Carnet_de_bord> carnetsDeBord = Carnet_de_bordService.obtenirTousLesCarnetsDeBord();
        return ResponseEntity.ok(carnetsDeBord);
    }
}

