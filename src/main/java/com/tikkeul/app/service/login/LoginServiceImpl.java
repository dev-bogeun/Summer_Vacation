package com.tikkeul.app.service.login;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;

@Service
@RequiredArgsConstructor
@Qualifier("login") @Primary
public class LoginServiceImpl<NaverCallback> implements LoginService{
}
