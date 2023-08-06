package com.tikkeul.app.service.doranBoard;

import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.vo.DoranBoardVO;

import java.util.List;
import java.util.Optional;

public interface DoranBoardService {
    //    게시글 목록
    public List<DoranBoardDTO> getList(Pagination pagination, Search search);

    //    게시글 추가
    public void write(DoranBoardDTO doranBoardDTO);

    //    게시글 조회
    public Optional<DoranBoardDTO> read(Long id);

    //    게시글 수정
    public void modify(DoranBoardDTO doranBoardDTO);

    //    게시글 삭제
    public void remove(Long id);

    //    게시글 전체 개수 조회
    public int getTotal(Search search);




    default DoranBoardDTO toDTO(DoranBoardVO doranBoardVO) {
        DoranBoardDTO doranBoardDTO = new DoranBoardDTO();
        doranBoardDTO.setId(doranBoardVO.getId());
        doranBoardDTO.setTitle(doranBoardVO.getTitle());
        doranBoardDTO.setViewCount(doranBoardVO.getViewCount());
        doranBoardDTO.setRegisterDate(doranBoardVO.getRegisterDate());
        doranBoardDTO.setUpdateDate(doranBoardVO.getUpdateDate());
        doranBoardDTO.setUserId(doranBoardVO.getUserId());
        doranBoardDTO.setItemId(doranBoardVO.getItemId());
        return doranBoardDTO;
    }
}

