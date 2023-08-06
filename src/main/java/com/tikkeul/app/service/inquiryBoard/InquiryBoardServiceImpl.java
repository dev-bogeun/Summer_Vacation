package com.tikkeul.app.service.inquiryBoard;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("inquiryBoard") @Primary
public class InquiryBoardServiceImpl implements InquiryBoardService {
}
