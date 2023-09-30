package hello.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Controller
@RequestMapping("/spring")
public class SpringUploadController {

    private final static String fileDir = "src/main/resources/static/uploads/";

    @GetMapping("/upload")
    public String newFile(HttpServletRequest request) {
        return "upload-form";
    }


    @PostMapping("/upload")
    public String saveFile2(@RequestParam String itemName,
                           @RequestParam MultipartFile file,
                           HttpServletRequest request) throws IOException {

        log.info("request={}", request);
        log.info("itemName={}", itemName);
        log.info("multipartFile={}", file);

        if(!file.isEmpty()){
            Path fullPath = Paths.get(fileDir + file.getOriginalFilename());
            file.transferTo(fullPath);
            log.info("저장된 fullpath={}", fullPath);
        }

        return "upload-form";
    }
}
