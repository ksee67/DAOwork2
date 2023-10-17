package com.example.demo.controller;

import com.example.demo.dao.DentistDAO;
import com.example.demo.dao.InvoiceDAO;
import com.example.demo.model.Dentist;
import com.example.demo.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceDAO treatmentDAO;

    @Autowired
    public InvoiceController(InvoiceDAO treatmentDAO){
        this.treatmentDAO = treatmentDAO;
    }

    @GetMapping
    public String index(Model model){
        List<Invoice> treatments = treatmentDAO.index();
        model.addAttribute("invoices", treatments);
        return "people/invoice/index"; //
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        Invoice treatment = treatmentDAO.show(id);
        model.addAttribute("invoice", treatment);
        return "people/invoice/show"; //
    }
}
