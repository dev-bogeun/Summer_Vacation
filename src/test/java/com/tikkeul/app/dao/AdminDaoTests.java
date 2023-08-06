package com.tikkeul.app.dao;


import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.InquiryBoardDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.vo.AnswerVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AdminDaoTests {

    @Autowired
    private AdminDAO adminDAO;

//    @Test
//    public void adminFindUserAllTest(Search search){
//        assertThat(adminDAO.adminSelectUserAll()).hasSize(2);
//        log.info(adminDAO.adminFindUserAll(search).toString());

//    }

    @Test
    public void adminDeleteUserTest(){
//        adminDAO.adminDeleteUser(20L);
    }

    @Test
    public void adminFindInquiryBoardTest(){
//        log.info(adminDAO.adminFindInquiryAll(Pagina).toString());
    }

//    @Test
//    public void adminFindInquiryTest(){
//        adminDAO.adminFindInquiry(5L).map(InquiryBoardDTO::getName).ifPresent(log::info);
//    }

//    @Test
//    public void adminSaveAnswerTest(){
//        AnswerVO answerVO = new AnswerVO();
//        answerVO.setAnswerContent("테스트11");
//        answerVO.setInquireId(5L);
//        adminDAO.adminSaveAnswer(answerVO);
//    }

    @Test
    public void adminFindDoranBoardAllTest(){
//        log.info(adminDAO.adminFindDoranBoardAll().toString());
    }

//    @Test
//    public void adminFindDoranBoardByIdTest(){
//        adminDAO.adminFindDoranBoardById(2L).map(DoranBoardDTO::getIdentification).ifPresent(log::info);
//    }

    @Test
    public void adminFindItemAllTest(){
//        log.info(adminDAO.adminFindItemAll().toString());
    }

    @Test
    public void adminDeleteInquiryTest(){
        adminDAO.adminDeleteInquiry(6L);
    }

}
