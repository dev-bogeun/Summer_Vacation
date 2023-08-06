package com.tikkeul.app.service.join;

import com.tikkeul.app.dao.UserDAO;
import com.tikkeul.app.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("join") @Primary
@Slf4j
public class JoinServiceImpl implements JoinService{
    public final UserDAO userDAO;
//  아이디 찾기
    @Override
    public Optional<UserVO> checkId(String identification) {
    return userDAO.findById(identification);
    }

//  회원가입
    @Override
    public void join(UserVO userVO) {
        userDAO.save(userVO);
    }

//  일반 로그인
    @Override
    public Optional<UserVO> login(String identification, String password) {
        return userDAO.findByUserIdAndUserPassword(identification,password);
    }

//  카카오 회원 업데이트
    @Override
    public void updateKakaoUser(Optional<UserVO> kakaoUser) {userDAO.updatekakao(kakaoUser);}

//  네이버 회원 업데이트
    @Override
    public void updateNaverUser(UserVO userVO) { userDAO.updateNaver(userVO);}

//   비밀번호 수정
    @Override
    public void updatePassword(String identification, String password) { userDAO.updatepassword(identification,password);}

//  비밃번호 찾기
    @Override
    public String findPassword(String identification, String password) {return userDAO.selectpassword(identification,password);}


//    @Override
//    public Optional<UserVO> getMember(Long id) {
//        return userDAO.findById(id);
//    }

}
