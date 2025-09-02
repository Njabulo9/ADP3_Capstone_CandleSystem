package ac.za.cput.controller;

import ac.za.cput.domain.Invoice;
import ac.za.cput.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/invoice")
@Transactional
public class InvoiceController {
    private final InvoiceService service;

    @Autowired
    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Invoice create(@RequestBody Invoice invoice) {
        return service.create(invoice);
    }

    @GetMapping("/read/{invoiceNumber}")
    public Invoice read(@PathVariable String invoiceNumber) {
        return service.read(invoiceNumber);
    }

    @PutMapping("/update")
    public Invoice update(@RequestBody Invoice invoice) {
        return service.update(invoice);
    }

    @GetMapping("/find/{invoiceNumber}")
    public Optional<Invoice> findByInvoiceNumber(@PathVariable String invoiceNumber) {
        return service.findByInvoiceNumber(invoiceNumber);
    }

    @GetMapping("/all")
    public List<Invoice> getAll() {
        return service.getAll();
    }
}