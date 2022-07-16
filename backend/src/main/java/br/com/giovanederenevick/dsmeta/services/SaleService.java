package br.com.giovanederenevick.dsmeta.services;

import br.com.giovanederenevick.dsmeta.entities.Sale;
import br.com.giovanederenevick.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Page<Sale> findSales(Pageable pageable) {

        return saleRepository.findAll(pageable);
    }

    public Page<Sale> findSalesByDate(String minDate, String maxDate, Pageable pageable) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = "".equals(minDate) ? today.minusYears(1) : LocalDate.parse(minDate);
        LocalDate max = "".equals(maxDate) ? today : LocalDate.parse(maxDate);

        return saleRepository.findSalesByDate(min, max, pageable);
    }
}
