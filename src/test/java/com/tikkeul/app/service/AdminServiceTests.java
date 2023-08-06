package com.tikkeul.app.service;


import com.tikkeul.app.domain.dto.InquiryBoardDTO;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.vo.AnswerVO;
import com.tikkeul.app.service.admin.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Slf4j
public class AdminServiceTests {

    @Autowired
    private AdminService adminService;

    @Test
    public void adminFindUserAllTest(Search search){
//        assertThat(adminService.adminGetListUserAll(search)).isNotNull();
//        log.info(adminService.adminGetListUserAll().toString());
    }

    @Test
    public void adminDeleteUserTest(){
//        adminService.adminRemoveUser(21L);
    }

    @Test
    public void adminGetListinquiryAllTest(){
//        assertThat(adminService.adminGetListInquiryAll());
    }

    @Test
    public void adminGetInquiryTest(){
//        adminService.adminReadInquiry(5L).map(InquiryBoardDTO::toString).ifPresent(log::info);
    }

    @Test
    public void adminWriteAnswerTest(){
        AnswerVO answerVO = new AnswerVO();
        answerVO.setAnswerContent("서비스테스트122");
        answerVO.setInquireId(5L);
        adminService.adminWriteAnswer(answerVO);
    }

    @Test
    public void adminGetListDoranBoardAllTest(){
//        assertThat(adminService.adminGetListDoranBoardAll());
    }
}
