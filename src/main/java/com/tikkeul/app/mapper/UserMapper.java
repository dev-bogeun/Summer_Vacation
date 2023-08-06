package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {
//  관리자페이지에서 회원 리스트 조회
    public List<UserVO> adminSelectUserAll();

    //    아이디 중복검사
    public Optional<UserVO> selectById(String identification);

//        회원가입
    public void insert(UserVO userVO);


//        로그인
    @Select("SELECT ID, STATUS, ROLL FROM USERS WHERE IDENTIFICATION = #{identification} AND PASSWORD = #{password}")
    public  Optional<UserVO> selectByUserIdAndUserPassword(@Param("identification") String id,@Param("password") String password);

//  카카오 회원 업데이트
    public void updatekakao(UserVO kakaoUser);

    public void updateNaver(UserVO userVO);

    @Update("UPDATE USERS SET PASSWORD = #{password} WHERE IDENTIFICATION = #{identification}")
    public void updatepassword(@Param("identification") String id,@Param("password") String password);

    public String selectpassword(String identification, String password);
}
