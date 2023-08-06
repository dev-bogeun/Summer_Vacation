package com.tikkeul.app.service.doranBoard;


import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.DoranCommentDTO;
import com.tikkeul.app.domain.vo.DoranCommentVO;

import java.util.List;

public interface DoranCommentService {
    //    댓글 목록
    public List<DoranCommentDTO> getList(Long id, Pagination pagination);

    //    댓글 작성
    public void write(DoranCommentVO doranCommentVO);

    //    댓글 수정
    public void modify(DoranCommentVO doranCommentVO);

    //    댓글 삭제
    public void remove(Long id);

    //    게시글의 댓글 전체 삭제
    public void removeAll(Long postId);

    default DoranCommentDTO toDTO(DoranCommentVO doranCommentVO){
        DoranCommentDTO replyDTO = new DoranCommentDTO();
        replyDTO.setId(doranCommentVO.getId());
        replyDTO.setContent(doranCommentVO.getContent());
        replyDTO.setRegisterDate(doranCommentVO.getRegisterDate());
        replyDTO.setUpdateDate(doranCommentVO.getUpdateDate());
        return replyDTO;
    }
}
