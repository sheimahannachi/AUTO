package com.example.parc_auto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parc_auto.entities.Stock_magasin;
import com.example.parc_auto.repositories.Stock_magasinrepository;
import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@Service
public class Stock_magasinservice {

    @Autowired
    private Stock_magasinrepository Stock_magasinrepository;

    public Stock_magasin ajouterStock(Stock_magasin stockMagasin) {
        return Stock_magasinrepository.save(stockMagasin);
    }

    public Stock_magasin modifierStock(Integer idMagasin, Stock_magasin stockMagasinModifié) {
        Optional<Stock_magasin> stockMagasinExistant = Stock_magasinrepository.findById(idMagasin);
        if (stockMagasinExistant.isPresent()) {
            Stock_magasin stockMagasin = stockMagasinExistant.get();


            stockMagasin.setNb_bon_entree(stockMagasinModifié.getNb_bon_entree());
            stockMagasin.setNb_bon_sortie(stockMagasinModifié.getNb_bon_sortie());
            stockMagasin.setDate_entree(stockMagasinModifié.getDate_entree());
            stockMagasin.setDate_sortie(stockMagasinModifié.getDate_sortie());


            return Stock_magasinrepository.save(stockMagasin);
        }
        return null;
    }

    public void supprimerStock(Integer idMagasin) {
        Stock_magasinrepository.deleteById(idMagasin);
    }

    public Stock_magasin chercherStockParId(Integer idMagasin) {
        Optional<Stock_magasin> stockMagasin = Stock_magasinrepository.findById(idMagasin);
        return stockMagasin.orElse(null);
    }

    public List<Stock_magasin> obtenirTousLesStocks() {
        return Stock_magasinrepository.findAll();
    }
}

