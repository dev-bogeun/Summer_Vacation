package com.tikkeul.app.controller;


import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.vo.DoranBoardVO;
import com.tikkeul.app.service.doranBoard.DoranBoardService;
import com.tikkeul.app.service.join.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/doranboard/*")
@RequiredArgsConstructor
public class DoranBoardController {
    /*도란보드 최보근*/

    private final DoranBoardService doranBoardService;
    private final HttpSession session;
    private final JoinService joinService;

    /*목록 가져오기*/
    @GetMapping("doranboard")
    public void list(Pagination pagination, Search search, Model model) {
        pagination.setTotal(doranBoardService.getTotal(search));
        pagination.progress();
        model.addAttribute("doranboards", doranBoardService.getList(pagination, search));

    }

    /*게시글 추가*/
    @GetMapping("doranwrite")
    public void goToWriteForm(DoranBoardDTO doranBoardDTO, Model model) {
//        model.addAttribute("memberName",joinService.get((Long)session.getAttribute("id")).get().getName());

    }

    @PostMapping("doranwrite")
    public RedirectView write(DoranBoardDTO doranBoardDTO) {
        log.info(doranBoardDTO.toString());
        doranBoardDTO.setUserId((Long)session.getAttribute("id"));
        doranBoardService.write(doranBoardDTO);
        return new RedirectView("/doranboard/doranboard");
    }

    /*게시글 상세보기*/
    @GetMapping(value = {"dorandetail", "doranmodify"})
    public void read(Long id, Pagination pagination, Search search, Model model){
        model.addAttribute("doranboard", doranBoardService.read(id).get());
    }

    /*게시글 수정*/
    @PostMapping("doranmodify")
    public RedirectView modify(DoranBoardDTO doranBoardDTO, RedirectAttributes redirectAttributes){
        log.info(doranBoardDTO.toString());
        doranBoardService.modify(doranBoardDTO);
        redirectAttributes.addAttribute("id", doranBoardDTO.getId());
        return new RedirectView("/doranboard/doranboard");
    }

    /*게시글 삭제*/
    @GetMapping("remove")
    public RedirectView remove(Long id) {
        doranBoardService.remove(id);
        return new RedirectView("/doranboard/doranboard");
    }

    public String getPath(){
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }




}
