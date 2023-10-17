package com.example.demo.dao;

import com.example.demo.model.Treatment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TreatmentDAO {
    private static int treatmentCount = 0; // Переименовано
    private List<Treatment> treatments; // Переименовано

    {
        treatments = new ArrayList<>();

        addTreatment(new Treatment(1,"Пломбирование зуба", "Установка пломбы в зуб для лечения кариеса", 5000.69));
        addTreatment(new Treatment(2,"Чистка зубов", "Профессиональная чистка зубов у стоматолога", 1500.99));
        addTreatment(new Treatment(3,"Удаление зуба мудрости", "Хирургическое удаление зуба мудрости", 9000.89));
        addTreatment(new Treatment(4,"Установка пластинки", "Установка пластинки у хирурга-стоматолога", 15000.90));
    }

    public List<Treatment> index() {
        return treatments;
    }

    public Treatment show(int id) {
        return treatments.stream()
                .filter(treatment -> treatment.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addTreatment(Treatment treatment) {
        treatment.setId(++treatmentCount);
        treatments.add(treatment);
    }
}
