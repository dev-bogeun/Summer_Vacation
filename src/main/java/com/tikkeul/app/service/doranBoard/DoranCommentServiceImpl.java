package com.tikkeul.app.service.doranBoard;

import com.tikkeul.app.dao.DoranCommentDAO;
import com.tikkeul.app.domain.dto.Pagination;
import com.tikkeul.app.domain.dto.DoranCommentDTO;
import com.tikkeul.app.domain.vo.DoranCommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoranCommentServiceImpl implements DoranCommentService {
    private final DoranCommentDAO doranCommentDAO;

    @Override
    public List<DoranCommentDTO> getList(Long id, Pagination pagination) {
        return doranCommentDAO.findAll(id, pagination);
    }

    @Override
    public void write(DoranCommentVO doranCommentVO) {
        doranCommentDAO.save(doranCommentVO);
    }

    @Override
    public void modify(DoranCommentVO doranCommentVO) {
        doranCommentDAO.setReply(toDTO(doranCommentVO));
    }

    @Override
    public void remove(Long id) {
        doranCommentDAO.delete(id);
    }

    @Override
    public void removeAll(Long postId) {
        doranCommentDAO.deleteAll(postId);
    }
}
