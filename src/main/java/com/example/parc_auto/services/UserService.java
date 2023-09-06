package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.User;
import com.example.parc_auto.repositories.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public User ajouterUser(User user) {
        return UserRepository.save(user);
    }

    public User modifierUser(Integer cin, User userModifié) {
        Optional<User> userExistant = UserRepository.findById(cin);
        if (userExistant.isPresent()) {
            User user = userExistant.get();
            user.setNom(userModifié.getNom());
            user.setPrenom(userModifié.getPrenom());
            user.setAdresse(userModifié.getAdresse());
            user.setTelephone(userModifié.getTelephone());

            return UserRepository.save(user);
        }
        return null;
    }

    public void supprimerUser(Integer cin) {
        UserRepository.deleteById(cin);
    }

    public User chercherUserParId(Integer cin) {
        Optional<User> user = UserRepository.findById(cin);
        return user.orElse(null);
    }

    public List<User> obtenirTousLesUsers() {
        return UserRepository.findAll();
    }
}