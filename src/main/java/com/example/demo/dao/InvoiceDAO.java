package com.example.demo.dao;
import com.example.demo.model.Dentist;
import com.example.demo.model.Invoice;
import com.example.demo.model.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class InvoiceDAO {
    private static int treatmentCount = 0; // Переименовано
    private List<Invoice> treatments; // Переименовано

    {
        treatments = new ArrayList<>();

        addTreatment(new Invoice(1, "Артемов Иван Кириллович", 25000, true));
        addTreatment(new Invoice( 2,"Завьялова Валерия Анатольевна", 3000, false));
        addTreatment(new Invoice( 3,"Тарасенко Виктор Львовович", 4500, false));
        addTreatment(new Invoice( 4,"Шубова Анна Федеоровна", 3800, true));
    }

    public List<Invoice> index() {
        return treatments;
    }

    public Invoice show(int id) {
        return treatments.stream()
                .filter(treatment -> treatment.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addTreatment(Invoice treatment) {
        treatment.setId(++treatmentCount);
        treatments.add(treatment);
    }
}
