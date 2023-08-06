package com.tikkeul.app.controller;

import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.DoranCommentDTO;
import com.tikkeul.app.domain.vo.DoranCommentVO;
import com.tikkeul.app.service.doranBoard.DoranCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/doranboard/*")
public class DoranCommentController {

    private final DoranCommentService doranCommentService;

    @PostMapping("write")
    public void write(@RequestBody DoranCommentVO doranCommentVO){
        doranCommentService.write(doranCommentVO);
    }

    @GetMapping("doranboard/{doranboardId}/{page}")
    public List<DoranCommentDTO> getList(@PathVariable int page, @PathVariable Long doranboardId){
        final Pagination pagination = new Pagination();
        pagination.setPage(page);
        pagination.progress();
        return doranCommentService.getList(doranboardId, pagination);
    }

    @PutMapping("modify")
//    @PatchMapping("modify")
    public void modify(@RequestBody DoranCommentVO doranCommentVO){
        doranCommentService.modify(doranCommentVO);
    }

    @DeleteMapping("{id}")
    public void remove(@PathVariable Long id){
        doranCommentService.remove(id);
    }
}






















