package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import entities.admin;
import repositories.adminRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private adminRepository adminRepository;

    public ResponseEntity<admin> ajouterAdmin(admin newAdmin) {
        admin savedAdmin = adminRepository.save(newAdmin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    public ResponseEntity<admin> modifierAdmin(Integer id, admin modifiedAdmin) {
        Optional<admin> adminExistant = adminRepository.findById(id);
        if (adminExistant.isPresent()) {
            admin existingAdmin = adminExistant.get();
             existingAdmin.setNom(modifiedAdmin.getNom());
            existingAdmin.setPrenom(modifiedAdmin.getPrenom());
            existingAdmin.setAdresse(modifiedAdmin.getAdresse());
            existingAdmin.setTelephone(modifiedAdmin.getTelephone());
            existingAdmin.setCin(modifiedAdmin.getCin());

            admin modified = adminRepository.save(existingAdmin);
            return new ResponseEntity<>(modified, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> supprimerAdmin(Integer id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<admin> chercherAdminParId(Integer id) {
        Optional<admin> admin = adminRepository.findById(id);
        return admin.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<List<admin>> obtenirTousLesAdmins() {
        List<admin> admins = adminRepository.findAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }
}
