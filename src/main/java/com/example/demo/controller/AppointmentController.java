package com.example.demo.controller;

import com.example.demo.dao.AppointmentDAO;
import com.example.demo.dao.DentistDAO;
import com.example.demo.model.Appointment;
import com.example.demo.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentDAO treatmentDAO;

    @Autowired
    public AppointmentController(AppointmentDAO treatmentDAO){
        this.treatmentDAO = treatmentDAO;
    }

    @GetMapping
    public String index(Model model){
        List<Appointment> treatments = treatmentDAO.index();
        model.addAttribute("appointments", treatments);
        return "people/appointment/index"; //
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        Appointment treatment = treatmentDAO.show(id);
        model.addAttribute("appointment", treatment);
        return "people/appointment/show"; //
    }
}
