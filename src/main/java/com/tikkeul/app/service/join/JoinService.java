package com.tikkeul.app.service.join;

import com.tikkeul.app.domain.vo.UserVO;
import org.apache.catalina.User;

import java.util.Optional;

public interface JoinService {
    //    아이디 중복검사
    public Optional<UserVO> checkId(String identification);

    //        회원가입
    public void join(UserVO userVO);

    //    로그인
    public Optional<UserVO> login(String identification, String password);

//        카카오회원 업데이트
    public void updateKakaoUser(Optional<UserVO> kakaoUser);

//         네이버유저 업데이트
    public void updateNaverUser(UserVO userVO);

//         비밀번호 업데이트
    public void updatePassword(String identification, String password);

//        비밀번호 찾기
    public String findPassword(String identification, String password);

////      회원 조회
//    public Optional<UserVO> getMember(Long id);


}
