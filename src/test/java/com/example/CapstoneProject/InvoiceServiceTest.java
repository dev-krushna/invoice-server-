package com.example.CapstoneProject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CapstoneProject.Repository.InvoiceRepository;
import com.example.CapstoneProject.Service.InvoiceService;
import com.example.CapstoneProject.entity.Invoice;
import com.example.CapstoneProject.entity.User;

@SpringBootTest
public class InvoiceServiceTest {

    @Mock
    private InvoiceRepository invoiceRepositoryMock;

    @InjectMocks
    private InvoiceService invoiceService;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateInvoice_Success() {
        User user = new User();
        user.setId(1L);

        Invoice invoice = new Invoice();
        invoice.setClientName("Client A");
        invoice.setAmount(5000);
        invoice.setDate(new Date(0));
        invoice.setDescription("Test invoice");
        invoice.setUser(user);

        when(invoiceRepositoryMock.save(any(Invoice.class))).thenReturn(invoice);

        Invoice createdInvoice = invoiceService.createInvoice(invoice);

        assertNotNull(createdInvoice);
        assertEquals("Client A", createdInvoice.getClientName());
        assertEquals(5000, createdInvoice.getAmount());
        assertNotNull(createdInvoice.getDate());
        assertEquals("Test invoice", createdInvoice.getDescription());
        assertEquals(user, createdInvoice.getUser());

        verify(invoiceRepositoryMock, times(1)).save(any(Invoice.class));
    }
}
