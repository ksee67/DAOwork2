package com.example.demo.controller;

import com.example.demo.dao.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PatientController {

    private PatientDAO _personDAO;

    @Autowired
    public PatientController(PatientDAO personDAO){
        _personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", _personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model){
        // Вывод определенного пользователя
        model.addAttribute("person", _personDAO.show(id));
        return "people/show";
    }

}
