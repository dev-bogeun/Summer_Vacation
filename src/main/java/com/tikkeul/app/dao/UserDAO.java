package com.tikkeul.app.dao;

import com.tikkeul.app.domain.vo.UserVO;
import com.tikkeul.app.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;


















//홍윤기 작업공간

//  아이디 중복검사
    public Optional<UserVO> findById(String identification){
        return userMapper.selectById(identification);
    };

//  회원가입
    public RedirectView save(UserVO userVO){
        userVO.setLevelId(0L);
        userMapper.insert(userVO);
        return new RedirectView("/login");
    };
//  카카오계정 업데이트
    public void updatekakao(Optional<UserVO> kakaoUser){
        userMapper.updatekakao(kakaoUser.get());
    }

    //    로그인
    public Optional<UserVO> findByUserIdAndUserPassword( String identification, String password){
        return userMapper.selectByUserIdAndUserPassword(identification,password);
    };
//    네이버 회원 업데이트
    public void updateNaver(UserVO userVO) {
        userMapper.updateNaver(userVO);
    }
//  비밀번호 업데이트
    public void updatepassword(String identification, String password) {
        userMapper.updatepassword(identification, password);
    }
//    비밀번호 조회
    public String selectpassword(String identification, String password) {
       return userMapper.selectpassword(identification,password);
    }

//    //    회원 조회
//    public Optional<UserVO> findById(Long id){
//        return memberMapper.selectById(id);
//    }
}
