package com.example.demo.controller;

import com.example.demo.dao.DentistDAO;
import com.example.demo.model.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/dentists") // пути для всех обработчиков префикс
public class DentistController {
    private final DentistDAO dentistDAO;

    @Autowired
    public DentistController(DentistDAO treatmentDAO){
        this.dentistDAO = treatmentDAO;
    }

    @GetMapping
    public String index(Model model){
        List<Dentist> treatments = dentistDAO.index();
        model.addAttribute("dentists", treatments);
        return "people/dentist/index"; //
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        Dentist treatment = dentistDAO.show(id);
        model.addAttribute("dentist", treatment);
        return "people/dentist/show"; //
    }
}
