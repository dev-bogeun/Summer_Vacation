package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.dto.DoranCommentDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.vo.DoranCommentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DoranCommentMapper {
    //    댓글 목록
    public List<DoranCommentDTO> selectAll(@Param("id") Long id, @Param("pagination") Pagination pagination);

    //    댓글 작성
    public void insert(DoranCommentVO doranCommentVO);

    //    댓글 수정
    public void update(DoranCommentDTO doranCommentDTO);

    //    댓글 삭제
    public void delete(Long id);

    //    게시글의 댓글 전체 삭제
    public void deleteAll(Long postId);
}
