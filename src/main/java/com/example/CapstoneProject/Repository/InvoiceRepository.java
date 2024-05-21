package com.example.CapstoneProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CapstoneProject.entity.Invoice;
import com.example.CapstoneProject.entity.User;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByUser(User user);
}
