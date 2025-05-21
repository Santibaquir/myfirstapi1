package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Sale;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class SaleService {
    private final List<Sale> sales = new ArrayList<>();

    @PostConstruct
    public void init() {
        sales.add(new Sale("001", "Laptop Dell", 3500000f, "Venta por mostrador"));
        sales.add(new Sale("002", "Teclado Logitech", 250000f, "Venta online"));
    }

    public List<Sale> getAllSales() {
        return sales;
    }

    public Sale getSaleByCode(String code) {
        for (Sale s : sales) {
            if (s.getSaleCode().equals(code)) return s;
        }
        return null;
    }
}
