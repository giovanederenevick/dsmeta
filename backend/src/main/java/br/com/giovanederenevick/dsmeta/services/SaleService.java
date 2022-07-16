package br.com.giovanederenevick.dsmeta.services;

import br.com.giovanederenevick.dsmeta.entities.Sale;
import br.com.giovanederenevick.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> findSales() {

        return saleRepository.findAll();
    }
}
