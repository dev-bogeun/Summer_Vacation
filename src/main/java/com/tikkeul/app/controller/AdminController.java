package com.tikkeul.app.controller;

import com.tikkeul.app.domain.dto.*;
import com.tikkeul.app.domain.vo.AnswerVO;
import com.tikkeul.app.domain.vo.ItemVO;
import com.tikkeul.app.domain.vo.SavingLevelVO;
import com.tikkeul.app.domain.vo.UserVO;
import com.tikkeul.app.service.admin.AdminService;
import com.tikkeul.app.service.item.ItemService;
import com.tikkeul.app.service.program.ProgramService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;
    private final ProgramService programService;
    private final ItemService itemService;

    //    회원
    @GetMapping("user/list")
    public void goToUserlist(Pagination pagination,Search search, Model model){
        pagination.setTotal(adminService.getUserTotal(search));
        pagination.progress();
        model.addAttribute("users", adminService.adminGetListUserAll(pagination,search));
    }

    @PostMapping("user/modify")
    @ResponseBody
    public void modifyUser(@RequestBody List<String> userIds){
        for (String userId : userIds) adminService.adminModifyUser(Long.valueOf(userId));
    }

    @PostMapping("user/modifyNormal")
    @ResponseBody
    public void modifyUserNormal(@RequestBody List<String> userIds){
        for (String userId : userIds) adminService.adminModifyUserNormal(Long.valueOf(userId));
    }

    //    문의
    @GetMapping("inquiry/list")
    public void goToinquirylist(Pagination pagination, Search search, Model model) {
        pagination.setTotal(adminService.getInquiryTotal(search));
        pagination.progress();
        model.addAttribute("inquirys", adminService.adminGetListInquiryAll(pagination, search));
    }

    @GetMapping("inquiry/read")
    public void readInquiry(Long id, Model model, AnswerVO answerVO){
        Optional<InquiryBoardDTO> checkInquiryBoardDTO = adminService.adminReadInquiry(id);
        if(checkInquiryBoardDTO.isPresent()) {
            model.addAttribute("inquiryBoard", checkInquiryBoardDTO.get());
        }
    }


    @PostMapping("inquiry/write")
    @Transactional(rollbackFor = Exception.class)
    public RedirectView write(AnswerVO answerVO,Long id){
        adminService.adminWriteAnswer(answerVO);
        adminService.adminModifyInquiry(id);
        return new RedirectView("/admin/inquiry/list");
    }

    @PostMapping("inquiry/delete")
    @ResponseBody
    public void removeInquiry(@RequestBody List<String> inquiryIds){
        for (String inquiryId : inquiryIds) adminService.adminRemoveInquiry(Long.valueOf(inquiryId));
    }

    //    도란 게시판
    @GetMapping("doranBoard/list")
    public void goToDoranBoardList(Pagination pagination, Search search, Model model){
        pagination.setTotal(adminService.getDoranBoardTotal(search));
        pagination.progress();
        model.addAttribute("doranBoards", adminService.adminGetListDoranBoardAll(pagination, search));
    }

    @GetMapping("doranBoard/read")
    public void readDoranBoard(Long id, Model model){
        Optional<DoranBoardDTO> checkDoranBoardDTO = adminService.adminReadDoranBoard(id);
        if(checkDoranBoardDTO.isPresent()) {
            model.addAttribute("doranBoard", checkDoranBoardDTO.get());
        }
//        checkDoranBoardDTO.ifPresent(doranBoardDTO -> model.addAttribute(doranBoardDTO));
    //        model.addAttribute("doranBoard",adminService.adminReadDoranBoard(id));
    }

    @PostMapping("doranBoard/delete")
    @ResponseBody
    public void removeDoranBoard(@RequestBody List<String> doranBoardIds){
        for (String doranBoardId : doranBoardIds ) adminService.adminRemoveDoranBoard(Long.valueOf(doranBoardId));
    }

    @GetMapping("item/list")
    public void goToItemList(Model model,Pagination pagination,Search search){
        pagination.setTotal(adminService.getItemTotal(search));
        pagination.progress();
        model.addAttribute("items",adminService.adminGetListItemAll(pagination,search));
    }

    @GetMapping("item/write")
    public void goToItemWriteForm(ItemDTO itemDTO){;}


    @PostMapping("item/write")
    public RedirectView writeItem(ItemDTO itemDTO){
        itemService.writeItem(itemDTO);

        return new RedirectView("/admin/item/list");
    }

    /* 프로그램*/
    @GetMapping("program/write")
    public void goToSavingLevelWriteForm(SavingLevelDTO savingLevelDTO){;}

    @PostMapping("program/write")
    public RedirectView writeSavingLevel(SavingLevelDTO savingLevelDTO){
        programService.writeSavingLevel(savingLevelDTO);
        return new RedirectView("/admin/program/list");
    }

    @GetMapping("program/list")
    public void goToProgramList(Model model){
        model.addAttribute("programs",programService.getSavingLevelAll());
    }

    @GetMapping(value = {"program/detail","program/modify"})
    public void detail(Long id, Model model){
        SavingLevelDTO savingLevelDTO = programService.getSavingLevel(id);
        model.addAttribute("savingLevels", savingLevelDTO);
    }

    @PostMapping("program/modify")
    public RedirectView modify(SavingLevelDTO savingLevelDTO, RedirectAttributes redirectAttributes){
        programService.modify(savingLevelDTO);
        redirectAttributes.addAttribute("id", savingLevelDTO.getId());
        return new RedirectView("/admin/program/detail");
    }

    @PostMapping("program/delete")
    public void removeProgram(@RequestBody List<String> programIds){
        for (String programId : programIds) programService.removeSavingLevel(Long.valueOf(programId));
    }

    /*메인 페이지*/
    @GetMapping("main")
    public void goToMain(Model model){
        model.addAttribute("mainusers",adminService.adminMainGetUser());
        model.addAttribute("mainsavinglevels",adminService.adminMainGetSavingLevel());
        model.addAttribute("mainitems",adminService.adminMainGetItem());
        model.addAttribute("maininquirys",adminService.adminMainGetInquiry());
    }
}