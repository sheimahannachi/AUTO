package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Acquisition;
import com.example.parc_auto.repositories.AcquisitionRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AcquisitionService {

    @Autowired
    private AcquisitionRepository AcquisitionRepository;

    public Acquisition ajouterAcquisition(Acquisition acquisition) {
        return AcquisitionRepository.save(acquisition);
    }

    public Acquisition modifierAcquisition(int idAcquisition, Acquisition acquisitionModifiée) {
        Optional<Acquisition> acquisitionExistante = AcquisitionRepository.findById(idAcquisition);
        if (acquisitionExistante.isPresent()) {
            Acquisition acquisition = acquisitionExistante.get();

            acquisition.setMontant_totale(acquisitionModifiée.getMontant_totale());


            return AcquisitionRepository.save(acquisition);
        }
        return null;
    }

    public void supprimerAcquisition(int idAcquisition) {
        AcquisitionRepository.deleteById(idAcquisition);
    }

    public Acquisition chercherAcquisitionParId(int idAcquisition) {
        Optional<Acquisition> Acquisition = AcquisitionRepository.findById(idAcquisition);
        return Acquisition.orElse(null);
    }

    public List<Acquisition> obtenirToutesLesAcquisitions() {
        return AcquisitionRepository.findAll();
    }
}
