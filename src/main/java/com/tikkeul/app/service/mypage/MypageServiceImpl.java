package com.tikkeul.app.service.mypage;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("mypage") @Primary
public class MypageServiceImpl implements MypageService{
}
