package com.example.demo.dao;

import com.example.demo.model.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class  PatientDAO {
    private static int PEOPLE_COUNT;
    private List<Patient> people;

    {
        people = new ArrayList<>();

        people.add(new Patient(++PEOPLE_COUNT, "Артемов Иван Кириллович", 25, "Муж", "ул. Домодедовская, д.23"));
        people.add(new Patient(++PEOPLE_COUNT, "Завьялова Валерия Анатольевна", 30, "Жен", "ул. Петровского, д.32"));
        people.add(new Patient(++PEOPLE_COUNT, "Тарасенко Виктор Львовович", 40, "Муж", "проспект вернадского, д.5"));
        people.add(new Patient(++PEOPLE_COUNT, "Шубова Анна Федеоровна", 35, "Жен", "ул. малышева, д.19"));
    }

    public List<Patient> index() {
        return people;
    }

    public Patient show(int id){
        return people.stream().filter(personModel ->
                personModel.getId() == id)
                .findAny()
                .orElse(null);
    }

}
