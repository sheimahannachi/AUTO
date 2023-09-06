package com.example.parc_auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.entities.Mission;
import com.example.parc_auto.services.MissionService;
import java.util.List;

@RestController
@RequestMapping("/tab_mission")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @PostMapping
    public ResponseEntity<Mission> ajouterMission(@RequestBody Mission mission) {
        Mission nouvelleMission = missionService.ajouterMission(mission);
        return ResponseEntity.ok(nouvelleMission);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mission> modifierMission(
            @PathVariable Integer id,
            @RequestBody Mission missionModifiée) {
        Mission missionMiseAJour = missionService.modifierMission(id, missionModifiée);
        if (missionMiseAJour != null) {
            return ResponseEntity.ok(missionMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMission(@PathVariable Integer id) {
        missionService.supprimerMission(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mission> obtenirMissionParId(@PathVariable Integer id) {
        Mission mission = missionService.chercherMissionParId(id);
        if (mission != null) {
            return ResponseEntity.ok(mission);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Mission>> obtenirToutesLesMissions() {
        List<Mission> missions = missionService.obtenirToutesLesMissions();
        return ResponseEntity.ok(missions);
    }
}
