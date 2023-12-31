package com.example.demo.dao;

import com.example.demo.model.Dentist;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component // определения, что DentistDAO является Spring-компонентом и управляется контейнером Spring
public class DentistDAO {
    private static int dentistCount = 0;
    private List<Dentist> dentists;

    {
        dentists = new ArrayList<>();

        addDentist(new Dentist(1,"Иванов Олег Петрович", "Стоматолог-терапевт", "js29023","ООО Балестом"));
        addDentist(new Dentist(2,"Сащенко Максим Валерьевич", "Стоматолог-хирург", "j50231","ООО Балестом"));
        addDentist(new Dentist(3,"Дуброва Анна Витальевна", "Детский стоматолог", "js23024","ООО Балестом"));
        addDentist(new Dentist(4,"Васильева Наталия Павловна", "Стоматолог-ортодонт", "js49023","ООО Балестом"));
    }

    public List<Dentist> index() {
        return dentists;
    }

    public Dentist show(int id) {
        return dentists.stream()
                .filter(dentist -> dentist.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addDentist(Dentist treatment) {
        treatment.setId(++dentistCount);
        dentists.add(treatment);
    }
}
