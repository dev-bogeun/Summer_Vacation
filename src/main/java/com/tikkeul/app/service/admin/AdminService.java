package com.tikkeul.app.service.admin;

import com.tikkeul.app.domain.dto.*;
import com.tikkeul.app.domain.vo.AnswerVO;
import com.tikkeul.app.domain.vo.ItemVO;
import com.tikkeul.app.domain.vo.SavingLevelVO;
import com.tikkeul.app.domain.vo.UserVO;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;


public interface AdminService {
    /* 회원 */
    //    관리자페이지에서 회원 목록 조회
    public List<UserVO> adminGetListUserAll(Pagination pagination, Search search);

    //    관리자 페이지에서 회원 총 수
    public int getUserTotal(Search search);


    // 관리자페이지에서 회원 전환
    public void adminModifyUserNormal(Long id);

    // 관리자페이지에서 회원 수정
    public void adminModifyUser(Long id);



    /*문의 내역*/
    //    관리자 페이지에서 문의 내역 전체 조회
    public List<InquiryBoardDTO> adminGetListInquiryAll(Pagination pagination, Search search);

    //    관리자 페이지에서 문의 내역 상세 조회
    public Optional<InquiryBoardDTO> adminReadInquiry(Long id);

    //    관리자 페이지에서 문의 내역 전체 개수 조회
    public int getInquiryTotal(Search search);

    //    관리자 페이지에서 문의 답변
    public void adminWriteAnswer(AnswerVO answerVO);

    //    관리자 페이지에서 문의 답변 여부
    public void adminModifyInquiry(Long id);

    //  관리자 페이지에서 문의 삭제
    public void adminRemoveInquiry(Long id);


    /*도란 게시판*/
    //    관리자 페이지에서 도란보드 목록 조회
    public List<DoranBoardDTO> adminGetListDoranBoardAll(Pagination pagination, Search search);

    //    관리자 페이지에서 도란 보드 총 개수
    public int getDoranBoardTotal(Search search);

    //    관리자 페이지에서 도란보드 상세 조회
    public Optional<DoranBoardDTO> adminReadDoranBoard(Long id);

    //    관리자 페이지에서 도란 보드 삭제
    public void adminRemoveDoranBoard(Long id);



    /*상품*/
    //    관리자 페이지에서 상품 목록 조회
    public List<ItemDTO> adminGetListItemAll(Pagination pagination, Search search);

    // 관리자 페이지에서 상품 총 개수
    public int getItemTotal(Search search);


    /*메인*/
    public List<UserVO> adminMainGetUser();

    public List<SavingLevelVO> adminMainGetSavingLevel();

    public List<ItemDTO> adminMainGetItem();

    public List<InquiryBoardDTO> adminMainGetInquiry();

}