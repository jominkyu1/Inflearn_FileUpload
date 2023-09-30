package hello.upload.file;

import hello.upload.domain.UploadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class FileStore {

    private final String FILE_DIR = "src/main/resources/static/uploads/";

    public Path getFullPath(String fileName) {
        return Paths.get(FILE_DIR + fileName);
    }

    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> storeFileResult = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                UploadFile uploadFile = storeFile(multipartFile);
                storeFileResult.add(uploadFile);
            }
        }

        return storeFileResult;
    }

    public UploadFile storeFile(MultipartFile multiPartFile) throws IOException {
        if(multiPartFile.isEmpty()){
            return null;
        }

        //originalFilename
        String originalFilename = multiPartFile.getOriginalFilename();
        //originalFilename -> UUID filename
        String storeFileName = createStoreFileName(originalFilename);

        //실제업로드 진행
        multiPartFile.transferTo(getFullPath(storeFileName));

        log.info("Original Filename={}", originalFilename);
        log.info("Store Filename={}", storeFileName);

        return new UploadFile(originalFilename, storeFileName);
    }

    private String createStoreFileName(String originalFilename) {
        //txt
        String ext = extractExt(originalFilename);

        String uuid = UUID.randomUUID().toString();

        return uuid + "." + ext;
    }

    //확장자 분리 메서드
    private String extractExt(String originalFilename){
        int position = originalFilename.lastIndexOf(".");
        return originalFilename.substring(position + 1);
    }
}
