//package com.tikkeul.app.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import net.coobird.thumbnailator.Thumbnailator;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Controller
//@RequestMapping("/files/*")
//@Slf4j
//public class FileController {
//    //    파일 업로드
//    @PostMapping("upload")
//    @ResponseBody
//    public List<String> upload(@RequestParam("uploadFile") List<MultipartFile> uploadFiles) throws IOException {
//        String path = "C:/upload/" + getPath();
//        List<String> uuids = new ArrayList<>();
//        File file = new File(path);
//        if(!file.exists()){file.mkdirs();}
//
//        for (int i=0; i<uploadFiles.size(); i++){
//            uuids.add(UUID.randomUUID().toString());
//            uploadFiles.get(i).transferTo(new File(path, uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
//            if(uploadFiles.get(i).getContentType().startsWith("image")){
//                FileOutputStream out = new FileOutputStream(new File(path, "t_" + uuids.get(i) + "_" + uploadFiles.get(i).getOriginalFilename()));
//                Thumbnailator.createThumbnail(uploadFiles.get(i).getInputStream(), out, 100, 100);
//                out.close();
//            }
//        }
//        return uuids;
//    }
//
//    public String getPath(){
//        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//    }
//
//    //    파일 불러오기
//    @GetMapping("display")
//    @ResponseBody
//    public byte[] display(String fileName) throws IOException{
//        return FileCopyUtils.copyToByteArray(new File("C:/upload/", fileName));
//    }
//
//}