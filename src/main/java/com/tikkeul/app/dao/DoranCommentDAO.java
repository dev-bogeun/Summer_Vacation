package com.tikkeul.app.dao;

import com.tikkeul.app.domain.dto.DoranCommentDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.vo.DoranCommentVO;
import com.tikkeul.app.mapper.DoranCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoranCommentDAO {
    private final DoranCommentMapper doranCommentMapper;

    //    댓글 목록
    public List<DoranCommentDTO> findAll(Long id, Pagination pagination){
        return doranCommentMapper.selectAll(id, pagination);
    }

    //    댓글 작성
    public void save(DoranCommentVO doranCommentVO){
        doranCommentMapper.insert(doranCommentVO);
    }

    //    댓글 수정
    public void setReply(DoranCommentDTO doranCommentDTO){
        doranCommentMapper.update(doranCommentDTO);
    }

    //    댓글 삭제
    public void delete(Long id){
        doranCommentMapper.delete(id);
    }

    //    게시글의 댓글 전체 삭제
    public void deleteAll(Long postId){
        doranCommentMapper.deleteAll(postId);
    }
}
