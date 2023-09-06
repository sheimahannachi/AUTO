package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Vehicule;
import com.example.parc_auto.repositories.VehiculeRepository;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository VehiculeRepository;

    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return VehiculeRepository.save(vehicule);
    }

    public Vehicule modifierVehicule(String immatriculation, Vehicule vehiculeModifié) {
        Optional<Vehicule> VehiculeExistant = VehiculeRepository.findById(immatriculation);
        if (VehiculeExistant.isPresent()) {
            Vehicule Vehicule = VehiculeExistant.get();

            // Update specific fields based on your requirements
            Vehicule.setPuissance(vehiculeModifié.getPuissance());
            Vehicule.setDate_aquisition(vehiculeModifié.getDate_aquisition());
            Vehicule.setKilometrage_initial(vehiculeModifié.getKilometrage_initial());
            Vehicule.setPoids(vehiculeModifié.getPoids());
            Vehicule.setNb_places(vehiculeModifié.getNb_places());
            Vehicule.setType(vehiculeModifié.getType());
            Vehicule.setMarque(vehiculeModifié.getMarque());

            return VehiculeRepository.save(Vehicule);
        }
        return null;
    }


    public void supprimerVehicule(String immatriculation) {
        VehiculeRepository.deleteById(immatriculation);
    }

    public Vehicule chercherVehiculeParImmatriculation(String immatriculation) {
        Optional<Vehicule> Vehicule = VehiculeRepository.findById(immatriculation);
        return Vehicule.orElse(null);
    }

    public List<Vehicule> obtenirTousLesVehicules() {
        return VehiculeRepository.findAll();
    }
}

