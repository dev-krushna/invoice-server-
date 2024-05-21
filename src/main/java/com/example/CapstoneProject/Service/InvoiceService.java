package com.example.CapstoneProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CapstoneProject.Repository.InvoiceRepository;
import com.example.CapstoneProject.entity.Invoice;
import com.example.CapstoneProject.entity.User;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice) {
        // Add logic for invoice creation (e.g., save invoice to database)
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> findByUser(User user) {
        return invoiceRepository.findByUser(user);
    }
}
