package com.example.webshopshoe_be.Service;


import com.example.webshopshoe_be.Entity.Payment;
import com.example.webshopshoe_be.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    public Payment updatePayment(Long id, Payment payment) {
        // Tìm payment cũ
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));

        // Cập nhật các trường dữ liệu của payment nếu có thay đổi
        if (payment.getStatus() != null) {
            existingPayment.setStatus(payment.getStatus());
        }
        if (payment.getAmount() != null) {
            existingPayment.setAmount(payment.getAmount());
        }
        if (payment.getPaymentDate() != null) {
            existingPayment.setPaymentDate(payment.getPaymentDate());
        }

        // Lưu payment đã được cập nhật
        return paymentRepository.save(existingPayment);
    }
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}