package com.example.parc_auto.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.services.UserService;
import com.example.parc_auto.entities.User;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping
    public ResponseEntity<User> ajouterUser(@RequestBody User user) {
        User nouveauUser = UserService.ajouterUser(user);
        return ResponseEntity.ok(nouveauUser);
    }

    @PutMapping("/{cin}")
    public ResponseEntity<User> modifierUser(
            @PathVariable Integer cin,
            @RequestBody User userModifié) {
        User userMisAJour = UserService.modifierUser(cin, userModifié);
        if (userMisAJour != null) {
            return ResponseEntity.ok(userMisAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cin}")
    public ResponseEntity<Void> supprimerUser(@PathVariable Integer cin) {
        UserService.supprimerUser(cin);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cin}")
    public ResponseEntity<User> obtenirUserParId(@PathVariable Integer cin) {
        User user = UserService.chercherUserParId(cin);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> obtenirTousLesUsers() {
        List<User> users = UserService.obtenirTousLesUsers();
        return ResponseEntity.ok(users);
    }
}

