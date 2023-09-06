package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Carburant;
import com.example.parc_auto.repositories.CarburantRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CarburantService {

    @Autowired
    private CarburantRepository CarburantRepository;

    public Carburant ajouterCarburant(Carburant carburant) {
        return CarburantRepository.save(carburant);
    }

    public Carburant modifierCarburant(int idCarburant, Carburant carburantModifié) {
        Optional<Carburant> carburantExistant = CarburantRepository.findById(idCarburant);
        if (carburantExistant.isPresent()) {
            Carburant carburant = carburantExistant.get();

            carburant.setLibelle(carburantModifié.getLibelle()); // Corrected

            return CarburantRepository.save(carburant);
        }
        return null;
    }



    public void supprimerCarburant(int idCarburant) {
        CarburantRepository.deleteById(idCarburant);
    }

    public Carburant chercherCarburantParId(int idCarburant) {
        Optional<Carburant> Carburant = CarburantRepository.findById(idCarburant);
        return Carburant.orElse(null);
    }

    public List<Carburant> obtenirTousLesCarburants() {
        return CarburantRepository.findAll();
    }
}

