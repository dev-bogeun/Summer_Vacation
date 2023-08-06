package com.tikkeul.app.service.payment;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("payment") @Primary
public class PaymentServiceImpl implements PaymentService{
}
