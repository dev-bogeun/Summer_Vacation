package com.tikkeul.app.mapper;


import com.tikkeul.app.domain.dto.*;
import com.tikkeul.app.domain.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AdminMapper {
    /*회원*/
    //  관리자페이지에서 회원 리스트 조회
    public List<UserVO> adminSelectUserAll(@Param("pagination") Pagination pagination, @Param("search") Search search);

    //  관리자페이지에서 회원 총 수
    public int adminCountOfUser(@Param("search") Search search);

    //  관리자페이지에서 회원 수정
    public void adminUpdateUser(Long id);

    // 관리자페이지에서 회원 전환
    public void adminChangeUser(Long id);

    /*문의*/
    //    관리자 페이지에서 문의 내역 전체 조회
    public List<InquiryBoardDTO> adminSelectInquiryAll(@Param("pagination") Pagination pagination, @Param("search") Search search);

    //    관리자 페이지에서 문의 내역 상세 조회
    public Optional<InquiryBoardDTO> adminSelectInquiry(Long id);

    //   관리자 페이지에서 문의 답변
    public void adminInsertAnswer(AnswerVO answerVO);

    //   관리자 페이지에서 답변 여부
    public void adminUpdateInquiry(Long id);

    //    관리자 페이지에서 문의 삭제
    public void adminDeleteInquiry(Long id);


    //    관리자페이지에서 문의 글 총 개수
    public int selectCountOfInquiry(@Param("search") Search search);

    /*도란 게시판*/
    //    관리자페이지에서 도란도란 게시판 목록 조회
    public List<DoranBoardDTO> adminSelectDoranBoardAll(@Param("pagination") Pagination pagination, @Param("search") Search search);

    //  관리자페이지에서 도란게시판 글 총 개수
    public int selectCountOfDoranBoard(@Param("search") Search search);

    //    관리자페이지에서 도란게시판 상세 조회
    public Optional<DoranBoardDTO> adminSelectDoranBoard(Long id);

    //    관리자페이지에서 도란 삭제
    public void adminDeleteDoranBoard(Long id);
    /*제품*/
    //    관리자페이지에서 상품 목록 조회
    public List<ItemDTO> adminSelectItemAll(@Param("pagination") Pagination pagination, @Param("search") Search search);

    //    관리자페이지에서 상품 총 개수
    public int selectCountOfItem(@Param("search") Search search);

    /*메인 페이지*/
    public List<UserVO> adminMainSelectUser();

    public List<SavingLevelVO> adminMainSelectSavingLevel();

    public List<ItemDTO> adminMainSelectItem();

    public List<InquiryBoardDTO> adminMainSelectInquiry();




}