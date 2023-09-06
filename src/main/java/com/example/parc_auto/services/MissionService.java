package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Mission;
import com.example.parc_auto.repositories.MissionRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MissionService {

    @Autowired
    private MissionRepository MissionRepository;

    public Mission ajouterMission(Mission mission) {
        return MissionRepository.save(mission);
    }

    public Mission modifierMission(Integer idMission, Mission missionModifiée) {
        Optional<Mission> missionExistante = MissionRepository.findById(idMission);
        if (missionExistante.isPresent()) {
            Mission mission = missionExistante.get();

            mission.setDate_debut(missionModifiée.getDate_debut());
            mission.setDate_fin(missionModifiée.getDate_fin());


            return MissionRepository.save(mission);
        }
        return null;
    }

    public void supprimerMission(Integer idMission) {
        MissionRepository.deleteById(idMission);
    }

    public Mission chercherMissionParId(Integer idMission) {
        Optional<Mission> mission = MissionRepository.findById(idMission);
        return mission.orElse(null);
    }

    public List<Mission> obtenirToutesLesMissions() {
        return MissionRepository.findAll();
    }
}
