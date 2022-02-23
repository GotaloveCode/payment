package com.mpf.beedeepayment.api;

import com.mpf.beedeepayment.dao.PaymentDataAccessService;
import com.mpf.beedeepayment.model.Bidbond;
import com.mpf.beedeepayment.model.Payment;
import com.mpf.beedeepayment.model.jackson.AccountResponse;
import com.mpf.beedeepayment.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class PaymentController {
    Logger logger = LoggerFactory.getLogger(PaymentDataAccessService.class);
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(path = "/payments")
    public ResponseEntity<Map<String, Object>> getPayments(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(required = false) String search) {
        try {
            Page<Payment> pagePayments;
            if (search.isEmpty())
                pagePayments = paymentService.getPayments(page);
            else
                pagePayments = paymentService.searchBy(search, page);

            Map<String, Object> response = new HashMap<>();
            response.put("data", pagePayments.getContent());
            response.put("current_page", pagePayments.getNumber());
            response.put("total", pagePayments.getTotalElements());
            response.put("to", pagePayments.getTotalPages());
            response.put("per_page", pagePayments.getSize());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/payments/unprocessed")
    public List<Bidbond> getUnprocessedPayments() {
        return paymentService.getUnprocessedPayments();
    }

    @RequestMapping(path = "/payments/{account}/account")
    public Optional<Payment> getByAccount(@PathVariable("account") String account) {
        return paymentService.getByAccount(account);
    }

    @RequestMapping(path = "/payments/account")
    public ResponseEntity<Map<String, Object>> getByPayableIds(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "payable_ids") List<String> payable_ids) {
        try {
            Page<Payment> pagePayments = paymentService.getByPayableIds(payable_ids, page);

            Map<String, Object> response = new HashMap<>();
            response.put("data", pagePayments.getContent());
            response.put("current_page", pagePayments.getNumber());
            response.put("total", pagePayments.getTotalElements());
            response.put("to", pagePayments.getTotalPages());
            response.put("per_page", pagePayments.getSize());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/payments/paid",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Optional<Payment> setPaid(@RequestBody AccountResponse account) {
        return paymentService.setProcessed(account.getAccount());
    }


    @RequestMapping(path = "payment/{payable_id}/sum")
    public ResponseEntity<Map<String, Object>> getSumByPayableId(@PathVariable("payable_id") String payable_id) {
        Map<String, Object> response = new HashMap<>();
        response.put("total", paymentService.getSumByPayableId(payable_id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}