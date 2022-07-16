package br.com.giovanederenevick.dsmeta.controllers;

import br.com.giovanederenevick.dsmeta.entities.Sale;
import br.com.giovanederenevick.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public Page<Sale> findSales(Pageable pageable) {

        return saleService.findSales(pageable);
    }

    @GetMapping(value = "/bydate")
    public Page<Sale> findSalesByDate(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                      @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                      Pageable pageable) {

        return saleService.findSalesByDate(minDate, maxDate, pageable);
    }
}
