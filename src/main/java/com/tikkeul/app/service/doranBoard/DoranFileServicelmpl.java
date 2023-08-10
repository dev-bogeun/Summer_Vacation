package com.tikkeul.app.service.doranBoard;

import com.tikkeul.app.dao.DoranFIleDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DoranFileServicelmpl implements DoranFileService {
    private final DoranFIleDAO doranFIleDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id){
        doranFIleDAO.delete(id);
    }
}
