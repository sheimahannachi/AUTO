package controllers;

import entities.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/add")
    public ResponseEntity<admin> addAdmin(@RequestBody admin newAdmin) {
        return adminService.ajouterAdmin(newAdmin);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<admin> modifyAdmin(@PathVariable Integer id, @RequestBody admin modifiedAdmin) {
        return adminService.modifierAdmin(id, modifiedAdmin);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Integer id) {
        return adminService.supprimerAdmin(id);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<admin> getAdmin(@PathVariable Integer id) {
        return adminService.chercherAdminParId(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<admin>> getAllAdmins() {
        return adminService.obtenirTousLesAdmins();
    }
}
