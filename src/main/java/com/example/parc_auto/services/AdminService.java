package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Admin;
import com.example.parc_auto.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository AdminRepository;

    public ResponseEntity<Admin> AjouterAdmin(Admin newAdmin) {
        Admin savedAdmin = AdminRepository.save(newAdmin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    public ResponseEntity<Admin> ModifierAdmin(Integer cin, Admin modifiedAdmin) {
        Optional<Admin> adminExistant = AdminRepository.findById(cin); // Use 'cin' as the primary key
        if (adminExistant.isPresent()) {
            Admin existingAdmin = adminExistant.get();
            existingAdmin.setNom(modifiedAdmin.getNom());
            existingAdmin.setPrenom(modifiedAdmin.getPrenom());
            existingAdmin.setAdresse(modifiedAdmin.getAdresse());
            existingAdmin.setTelephone(modifiedAdmin.getTelephone());
            existingAdmin.setCin(modifiedAdmin.getCin());

            Admin modified = AdminRepository.save(existingAdmin);
            return new ResponseEntity<>(modified, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> SupprimerAdmin(Integer cin) {
        if (AdminRepository.existsById(cin)) { // Use 'cin' as the primary key
            AdminRepository.deleteById(cin); // Use 'cin' as the primary key
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Admin> ChercherAdminParCin(Integer cin) {
        Optional<Admin> admin = AdminRepository.findById(cin); // Use 'cin' as the primary key
        return admin.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<List<Admin>> ObtenirTousLesAdmins() {
        List<Admin> admins = AdminRepository.findAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
}
