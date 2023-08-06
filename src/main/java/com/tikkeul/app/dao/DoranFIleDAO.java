package com.tikkeul.app.dao;

import com.tikkeul.app.domain.vo.DoranFileVO;
import com.tikkeul.app.mapper.DoranFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DoranFIleDAO {
    private final DoranFileMapper doranFileMapper;

    //    파일 추가
    public void save(DoranFileVO doranFileVO){
        doranFileMapper.insert(doranFileVO);
    }

    //    파일 삭제
    public void delete(Long id){
        doranFileMapper.delete(id);
    }

    //    게시글의 파일 전체 삭제
    public void deleteAll(Long doranBoardId){
        doranFileMapper.deleteAll(doranBoardId);
    }

    //    파일 조회
    public List<DoranFileVO> findAll(Long doranBoardId){
        return doranFileMapper.selectAll(doranBoardId);
    }


}
