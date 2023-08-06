package com.tikkeul.app.mapper;

import com.tikkeul.app.domain.vo.DoranFileVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoranFileMapper {
    //    파일 추가
    public void insert(DoranFileVO doranFileVO);

    //    파일 삭제
    public void delete(Long id);

    //    게시글의 파일 전체 삭제
    public void deleteAll(Long doranBoardId);


    //    파일 조회
    public List<DoranFileVO> selectAll(Long doranBoardId);

    //    어제 날짜 파일 조회
    public List<DoranFileVO> selectYesterday();
}
