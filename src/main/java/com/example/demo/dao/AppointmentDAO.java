package com.example.demo.dao;

import com.example.demo.model.Appointment;
import com.example.demo.model.Dentist;
import com.example.demo.model.Invoice;
import com.example.demo.model.Patient;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class AppointmentDAO {
    private static int treatmentCount = 0; // Переименовано
    private List<Appointment> treatments; // Переименовано

    {
        treatments = new ArrayList<>();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            // переобразуем строки в объект Date
            Date date1 = dateFormat.parse("01/10/2023");
            Date date2 = dateFormat.parse("11/10/2023");
            Date date3 = dateFormat.parse("19/02/2023");
            Date date4 = dateFormat.parse("20/02/2023");

            addTreatment(new Appointment(1, date1, "Артемов Иван Кириллович", "Иванов Олег Петрович"));
            addTreatment(new Appointment(2, date2, "Завьялова Валерия Анатольевна", "Сащенко Максим Валерьевич"));
            addTreatment(new Appointment(3, date3, "Тарасенко Виктор Львовович", "Дуброва Анна Витальевна"));
            addTreatment(new Appointment(4, date4, "Шубова Анна Федеоровна", "Васильева Наталия Павловна"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Appointment> index() {
        return treatments;
    }

    public Appointment show(int id) {
        return treatments.stream()
                .filter(treatment -> treatment.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addTreatment(Appointment treatment) {
        treatment.setId(++treatmentCount);
        treatments.add(treatment);
    }
}
