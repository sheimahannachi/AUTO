package com.example.parc_auto.controllers;

import com.example.parc_auto.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.services.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/tab_administrateur") // Use the table name in the path
public class AdminController {

    private final AdminService AdminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.AdminService = adminService;
    }

    @PostMapping
    public ResponseEntity<Admin> AjouterAdmin(@RequestBody Admin newAdmin) {
        return AdminService.AjouterAdmin(newAdmin);
    }

    @PutMapping("/{cin}") // Use 'cin' as the path variable
    public ResponseEntity<Admin> ModifierAdmin(@PathVariable Integer cin, @RequestBody Admin modifiedAdmin) {
        return AdminService.ModifierAdmin(cin, modifiedAdmin);
    }

    @DeleteMapping("/{cin}") // Use 'cin' as the path variable
    public ResponseEntity<Void> SupprimerAdmin(@PathVariable Integer cin) {
        return AdminService.SupprimerAdmin(cin);
    }

    @GetMapping("/{cin}") // Use 'cin' as the path variable
    public ResponseEntity<Admin> ChercherAdminParCin(@PathVariable Integer cin) {
        return AdminService.ChercherAdminParCin(cin);
    }

    @GetMapping
    public ResponseEntity<List<Admin>> ObtenirTousLesAdmins() {
        return AdminService.ObtenirTousLesAdmins();
    }
}
