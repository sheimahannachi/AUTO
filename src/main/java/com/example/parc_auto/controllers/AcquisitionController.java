package com.example.parc_auto.controllers;

import com.example.parc_auto.entities.Acquisition;
import com.example.parc_auto.services.AcquisitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acquisitions") // Base URL for this controller
public class AcquisitionController {

    private final AcquisitionService acquisitionService;

    @Autowired
    public AcquisitionController(AcquisitionService acquisitionService) {
        this.acquisitionService = acquisitionService;
    }

    @PostMapping("/")
    public Acquisition ajouterAcquisition(@RequestBody Acquisition acquisition) {
        return acquisitionService.ajouterAcquisition(acquisition);
    }

    @PutMapping("/{id}")
    public Acquisition modifierAcquisition(
            @PathVariable("id") int id,
            @RequestBody Acquisition acquisitionModifiee
    ) {
        return acquisitionService.modifierAcquisition(id, acquisitionModifiee);
    }

    @DeleteMapping("/{id}")
    public void supprimerAcquisition(@PathVariable("id") int id) {
        acquisitionService.supprimerAcquisition(id);
    }

    @GetMapping("/{id}")
    public Acquisition chercherAcquisitionParId(@PathVariable("id") int id) {
        return acquisitionService.chercherAcquisitionParId(id);
    }

    @GetMapping("/")
    public List<Acquisition> obtenirToutesLesAcquisitions() {
        return acquisitionService.obtenirToutesLesAcquisitions();
    }
}
