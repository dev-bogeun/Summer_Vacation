package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.vo.DoranBoardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DoranBoardMapper {
    /*도란보드 최보근*/
//    게시글 목록
    public List<DoranBoardDTO> selectAll(@Param("pagination") Pagination pagination, @Param("search") Search search);

//    게시글 추가
    public void insert(DoranBoardDTO doranBoardDTO);

//    게시글 상세보기
    public Optional<DoranBoardDTO> select(Long Id);

//  게시글 수정
    public void update(DoranBoardDTO doranBoardDTO);

//    게시글 삭제
    public void delete(Long id);

//    게시글 총 개수
    public int selectCountOfPost(@Param("search") Search search);

}
