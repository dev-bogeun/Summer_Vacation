package com.tikkeul.app.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("review") @Primary
public class ReviewServiceImpl implements ReviewService{
}
