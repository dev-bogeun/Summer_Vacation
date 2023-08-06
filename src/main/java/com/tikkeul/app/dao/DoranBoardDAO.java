package com.tikkeul.app.dao;

import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.vo.DoranBoardVO;
import com.tikkeul.app.mapper.DoranBoardMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DoranBoardDAO {
/*도란보드 최보근*/
    private final DoranBoardMapper doranBoardMapper;

    //    게시글 목록
    public List<DoranBoardDTO> findAll(Pagination pagination, Search search) {
        return doranBoardMapper.selectAll(pagination, search);
    }

    //    게시글 추가
    public void save(DoranBoardDTO doranBoardDTO) { doranBoardMapper.insert(doranBoardDTO); }

    //    게시글 상세보기
    public Optional<DoranBoardDTO> findById(Long id) {
        return doranBoardMapper.select(id);
    }

    //    게시글 수정
    public void setPostDTO(DoranBoardDTO doranBoardDTO) {
        doranBoardMapper.update(doranBoardDTO);
    }

    //    게시글 삭제
    public void delete(Long id) {
        doranBoardMapper.delete(id);
    }

    //    게시글 총 개수
    public int findCountOfPost(Search search){
        return  doranBoardMapper.selectCountOfPost(search);
    }

}
