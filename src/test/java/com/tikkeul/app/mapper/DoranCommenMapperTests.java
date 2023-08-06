package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.DoranCommentDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.vo.DoranCommentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class DoranCommenMapperTests {
    @Autowired
    private DoranCommentMapper doranCommentMapper;

    @Test
    public void insertTest() {
        DoranCommentVO doranCommentVO = new DoranCommentVO();
        doranCommentVO.setId(2L);
        doranCommentVO.setUserId(2L);
        doranCommentVO.setDoranboardId(29L);
        doranCommentVO.setContent("댓글 테스트");
        doranCommentMapper.insert(doranCommentVO);
    }


    @Test
    public void selectAllTest(){
    Pagination pagination = new Pagination();
    pagination.setPage(1); //화면에서 전달받은 페이지
        pagination.progress();
    doranCommentMapper.selectAll(29L,pagination).stream().map(DoranCommentDTO::toString).forEach(log::info);
}


}
