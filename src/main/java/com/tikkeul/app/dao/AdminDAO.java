package com.tikkeul.app.dao;

import com.tikkeul.app.domain.dto.*;
import com.tikkeul.app.domain.vo.AnswerVO;
import com.tikkeul.app.domain.vo.ItemVO;
import com.tikkeul.app.domain.vo.SavingLevelVO;
import com.tikkeul.app.domain.vo.UserVO;
import com.tikkeul.app.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class AdminDAO {

    @Autowired
    private final AdminMapper adminMapper;

    /*회원*/
    public List<UserVO> adminFindUserAll(Pagination pagination, Search search){
        return adminMapper.adminSelectUserAll(pagination, search);
    }

    // 관리자페이지 회원 총 수
    public int findCountOfUser(Search search){
        return adminMapper.adminCountOfUser(search);
    }

    // 관리자페이지에서 회원 삭제
    public void adminChangeUser(Long id){
        adminMapper.adminChangeUser(id);
    }

    // 관리자페이지에서 회원 수정
    public void adminSetUser(Long id){
        adminMapper.adminUpdateUser(id);
    }

    /* 문의 */
    //    관리자 페이지에서 문의 내역 전체 조회
    public List<InquiryBoardDTO> adminFindInquiryAll(Pagination pagination, Search search){
        return adminMapper.adminSelectInquiryAll(pagination, search);
    }

    //    관리자 페이지에서 문의 내역 상세 조회
    public Optional<InquiryBoardDTO> adminFindInquiry(Long id){
        return adminMapper.adminSelectInquiry(id);
    }

    //  관리자페이지에서  문의 내역 총개수
    public int findCountOfInquiry(Search search){
        return adminMapper.selectCountOfInquiry(search);
    }


    //    관리자 페이지에서 문의 답변
    public void adminSaveAnswer(AnswerVO answerVO){
        adminMapper.adminInsertAnswer(answerVO);
    }

    //  관리자 페이지에서 문의 답변 여부
    public void adminSetInquiry(Long id){
        adminMapper.adminUpdateInquiry(id);
    }

    //    관리자 페이지에서 문의 삭제
    public void adminDeleteInquiry(Long id){
        adminMapper.adminDeleteInquiry(id);
    }

    /*----------------------------------------------------------------------------------*/
    /*도란 게시판*/
    //    관리자 페이지에서 도란보드 목록 조회
    public List<DoranBoardDTO> adminFindDoranBoardAll(Pagination pagination, Search search){
        return adminMapper.adminSelectDoranBoardAll(pagination, search);
    }

    //  관리자 페이지에서 도란 보드 총 개수
    public int findCountOfDoranBoard(Search search){
        return adminMapper.selectCountOfDoranBoard(search);
    }

    //    관리자 페이지에서 도란 보드 상세조회
    public Optional<DoranBoardDTO> adminFindDoranBoardById(Long id){
        return adminMapper.adminSelectDoranBoard(id);
    }

    //    관리자 페이지에서 도란 보드 삭제
    public void adminDeleteDoranBoard(Long id){
        adminMapper.adminDeleteDoranBoard(id);
    }

    /*----------------------------------------------------------------------------------*/
    /*상품*/
    //    관리자 페이지에서 상품 목록 조회
    public List<ItemDTO> adminFindItemAll(Pagination pagination, Search search){
        return adminMapper.adminSelectItemAll(pagination, search);
    }
    //  관리자 페이지에서 상품 총 개수
    public int findCountOfItem(Search search){
        return adminMapper.selectCountOfItem(search);
    }

    /*메인 페이지*/
    public List<UserVO> adminMainFindUser(){
        return adminMapper.adminMainSelectUser();
    }

    public List<SavingLevelVO> adminMainFindSavingLevel(){
        return adminMapper.adminMainSelectSavingLevel();
    }

    public List<ItemDTO> adminMainFindItem(){
        return adminMapper.adminMainSelectItem();
    }

    public List<InquiryBoardDTO> adminMainFindInquiry(){
        return adminMapper.adminMainSelectInquiry();
    }

}