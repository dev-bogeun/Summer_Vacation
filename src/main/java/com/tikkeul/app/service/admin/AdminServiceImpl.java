package com.tikkeul.app.service.admin;

import com.tikkeul.app.dao.AdminDAO;
import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.InquiryBoardDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.dao.UserDAO;
import com.tikkeul.app.domain.dto.*;
import com.tikkeul.app.domain.vo.AnswerVO;
import com.tikkeul.app.domain.vo.ItemVO;
import com.tikkeul.app.domain.vo.SavingLevelVO;
import com.tikkeul.app.domain.vo.UserVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("admin") @Primary
public class AdminServiceImpl implements AdminService {
    private final AdminDAO adminDAO;
    //  회원
    @Override
    public List<UserVO> adminGetListUserAll(Pagination pagination, Search search) {
        return adminDAO.adminFindUserAll(pagination, search);
    }

    @Override
    public int getUserTotal(Search search) {
        return adminDAO.findCountOfUser(search);
    }

    @Override
    public void adminModifyUserNormal(Long id) {
        adminDAO.adminChangeUser(id);
    }

    @Override
    public void adminModifyUser(Long id) {
        adminDAO.adminSetUser(id);
    }


    //    문의
    @Override
    public List<InquiryBoardDTO> adminGetListInquiryAll(Pagination pagination, Search search) {
        return adminDAO.adminFindInquiryAll(pagination, search);
    }

    @Override
    public Optional<InquiryBoardDTO> adminReadInquiry(Long id) {
        return adminDAO.adminFindInquiry(id);
    }

    @Override
    public int getInquiryTotal(Search search) {
        return adminDAO.findCountOfInquiry(search);
    }

    @Override
    public void adminWriteAnswer(AnswerVO answerVO) {
        adminDAO.adminSaveAnswer(answerVO);
    }

    @Override
    public void adminModifyInquiry(Long id) {
        adminDAO.adminSetInquiry(id);
    }

    @Override
    public void adminRemoveInquiry(Long id) {
        adminDAO.adminDeleteInquiry(id);
    }

    //    도란 게시판
    @Override
    public List<DoranBoardDTO> adminGetListDoranBoardAll(Pagination pagination, Search search) {
        return adminDAO.adminFindDoranBoardAll(pagination, search);
    }

    @Override
    public int getDoranBoardTotal(Search search) {
        return adminDAO.findCountOfDoranBoard(search);
    }

    @Override
    public Optional<DoranBoardDTO> adminReadDoranBoard(Long id) {
        return adminDAO.adminFindDoranBoardById(id);
    }

    @Override
    public void adminRemoveDoranBoard(Long id) {
        adminDAO.adminDeleteDoranBoard(id);
    }

    @Override
    public List<ItemDTO> adminGetListItemAll(Pagination pagination, Search search) {
        return adminDAO.adminFindItemAll(pagination, search);
    }

    @Override
    public int getItemTotal(Search search) {
        return adminDAO.findCountOfItem(search);
    }

    @Override
    public List<UserVO> adminMainGetUser() {
        return adminDAO.adminMainFindUser();
    }

    @Override
    public List<SavingLevelVO> adminMainGetSavingLevel() {
        return adminDAO.adminMainFindSavingLevel();
    }

    @Override
    public List<ItemDTO> adminMainGetItem() {
        return adminDAO.adminMainFindItem();
    }

    @Override
    public List<InquiryBoardDTO> adminMainGetInquiry() {
        return adminDAO.adminMainFindInquiry();
    }


}