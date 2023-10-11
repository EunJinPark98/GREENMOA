package com.green.GreenClassRoom.util;

import com.green.GreenClassRoom.board.vo.QnaBoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtil {
    //파일 첨부 기능(단일 파일 업로드)
    public static QnaBoardVO uploadFile(MultipartFile img){
        QnaBoardVO qnaBoardVO = null;

        //첨부파일을 선택했다면...
        if(!img.isEmpty()){
            qnaBoardVO = new QnaBoardVO();

            //첨부파일
            String originFileName = img.getOriginalFilename();

            //첨부될 파일명
            String uuid = UUID.randomUUID().toString();

            int dotIndex = originFileName.lastIndexOf(".");
            String extension = originFileName.substring(dotIndex);
            String attachedFileName = uuid + extension;

            //파일 첨부
            try {
                File file = new File(ConstantVariable.UPLOAD_PATH + attachedFileName);
                img.transferTo(file);

                qnaBoardVO.setOriginFileName(originFileName);
                qnaBoardVO.setAttachedFileName(attachedFileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return qnaBoardVO;
    }

}







