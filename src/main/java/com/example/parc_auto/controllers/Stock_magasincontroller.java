package com.example.parc_auto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.parc_auto.entities.Stock_magasin;
import com.example.parc_auto.services.Stock_magasinservice;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class Stock_magasincontroller {

    @Autowired
    private Stock_magasinservice Stock_magasinservice;

    @PostMapping
    public ResponseEntity<Stock_magasin> ajouterStock(@RequestBody Stock_magasin stock) {
        Stock_magasin nouveauStock = Stock_magasinservice.ajouterStock(stock);
        return ResponseEntity.ok(nouveauStock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock_magasin> modifierStock(
            @PathVariable Integer id,
            @RequestBody Stock_magasin stockModifié) {
        Stock_magasin stockMisAJour = Stock_magasinservice.modifierStock(id, stockModifié);
        if (stockMisAJour != null) {
            return ResponseEntity.ok(stockMisAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerStock(@PathVariable Integer id) {
        Stock_magasinservice.supprimerStock(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock_magasin> obtenirStockParId(@PathVariable Integer id) {
        Stock_magasin stock = Stock_magasinservice.chercherStockParId(id);
        if (stock != null) {
            return ResponseEntity.ok(stock);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Stock_magasin>> obtenirTousLesStocks() {
        List<Stock_magasin> stocks = Stock_magasinservice.obtenirTousLesStocks();
        return ResponseEntity.ok(stocks);
    }
}
