package com.tikkeul.app.service.doranBoard;

import com.tikkeul.app.dao.DoranBoardDAO;
import com.tikkeul.app.dao.DoranCommentDAO;
import com.tikkeul.app.dao.DoranFIleDAO;
import com.tikkeul.app.domain.dto.DoranBoardDTO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.Search;
import com.tikkeul.app.domain.type.FileType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("doranBoard") @Primary
public class DoranBoardServiceImpl implements DoranBoardService {
    /*도란보드 최보근*/
    private final DoranBoardDAO doranBoardDAO;
    private final DoranCommentDAO doranCommentDAO;
    private final DoranFIleDAO doranFIleDAO;

    /*게시글 목록*/
    @Override
    public List<DoranBoardDTO> getList(Pagination pagination, Search search) {
//        게시글 전체목록
        final List<DoranBoardDTO> doranBoards = doranBoardDAO.findAll(pagination, search);
//        게시글 하나씩 첨부파일 목록 담기
        doranBoards.forEach(doranBoard -> doranBoard.setFiles(doranFIleDAO.findAll(doranBoard.getId())));
        return doranBoards;
    }

    /*게시글 추가*/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void write(DoranBoardDTO doranBoardDTO) {
        doranBoardDAO.save(doranBoardDTO);
        for(int i=0; i<doranBoardDTO.getFiles().size(); i++){
            doranBoardDTO.getFiles().get(i).setDoranBoardId(doranBoardDTO.getId());
            if(doranBoardDTO.getFiles().get(i).getFileType() == null){
                doranBoardDTO.getFiles().get(i).setFileType(FileType.NON_REPRESENTATIVE.name());
            }
             doranFIleDAO.save(doranBoardDTO.getFiles().get(i));
        }
    }

    /*게시글 조회*/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<DoranBoardDTO> read(Long id) {
        final Optional<DoranBoardDTO> foundDoranBoard = doranBoardDAO.findById(id);
        if(foundDoranBoard.isPresent()){
            foundDoranBoard.get().setFiles(doranFIleDAO.findAll(foundDoranBoard.get().getId()));
        }
        return foundDoranBoard;
    }

    /*게시글 수정*/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(DoranBoardDTO doranBoardDTO) {
        doranBoardDAO.setPostDTO(doranBoardDTO);
//      추가
        doranBoardDTO.getFiles().forEach(file -> {
            if(file.getFileType() == null) {
                file.setFileType(FileType.NON_REPRESENTATIVE.name());
            }
            file.setDoranBoardId(doranBoardDTO.getId());
            doranFIleDAO.save(file);

        });
//      삭제
        doranBoardDTO.getFileIdsForDelete().forEach(doranFIleDAO::delete);
    }

    /*게시글 삭제*/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id) {
        doranBoardDAO.delete(id);
        doranCommentDAO.delete(id);
        doranFIleDAO.delete(id);
    }

    /*게시글 */
    @Override
    public int getTotal(Search search) {
        return doranBoardDAO.findCountOfPost(search);
    }


    
}
