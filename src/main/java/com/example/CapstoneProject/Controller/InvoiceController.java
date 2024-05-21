package com.example.CapstoneProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.CapstoneProject.Service.InvoiceService;
import com.example.CapstoneProject.entity.Invoice;
import com.example.CapstoneProject.entity.User;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/create")
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice createdInvoice = invoiceService.createInvoice(invoice);
        return ResponseEntity.ok(createdInvoice);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Invoice>> getInvoicesByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        List<Invoice> invoices = invoiceService.findByUser(user);
        return ResponseEntity.ok(invoices);
    }
}
