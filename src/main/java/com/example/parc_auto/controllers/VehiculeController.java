package com.example.parc_auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.entities.Vehicule;
import com.example.parc_auto.services.VehiculeService;
import java.util.List;

@RestController
@RequestMapping("/vehicules")
public class VehiculeController {

    @Autowired
    private VehiculeService VehiculeService;

    @PostMapping
    public ResponseEntity<Vehicule> ajouterVehicule(@RequestBody Vehicule Vehicule) {
        Vehicule nouveauVehicule = VehiculeService.ajouterVehicule(Vehicule);
        return ResponseEntity.ok(nouveauVehicule);
    }

    @PutMapping("/{immatriculation}")
    public ResponseEntity<Vehicule> modifierVehicule(
            @PathVariable String immatriculation,
            @RequestBody Vehicule vehiculeModifié) {
        Vehicule VehiculeMisAJour = VehiculeService.modifierVehicule(immatriculation, vehiculeModifié);
        if (VehiculeMisAJour != null) {
            return ResponseEntity.ok(VehiculeMisAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{immatriculation}")
    public ResponseEntity<Void> supprimerVehicule(@PathVariable String immatriculation) {
        VehiculeService.supprimerVehicule(immatriculation);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{immatriculation}")
    public ResponseEntity<Vehicule> obtenirVehiculeParImmatriculation(@PathVariable String immatriculation) {
        Vehicule Vehicule = VehiculeService.chercherVehiculeParImmatriculation(immatriculation);
        if (Vehicule != null) {
            return ResponseEntity.ok(Vehicule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Vehicule>> obtenirTousLesVehicules() {
        List<Vehicule> Vehicules = VehiculeService.obtenirTousLesVehicules();
        return ResponseEntity.ok(Vehicules);
    }
}

