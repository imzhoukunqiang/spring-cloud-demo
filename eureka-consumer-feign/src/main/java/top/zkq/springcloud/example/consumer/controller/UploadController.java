package top.zkq.springcloud.example.consumer.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import top.zkq.springcloud.example.consumer.client.UploadService;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author zkq
 * @version 1.0
 * @date 2019/3/7 14:33
 */
@RestController
public class UploadController {


    @Resource
    private UploadService uploadService;

    @GetMapping("/filename")
    public String filename() {
        File f = new File("d:\\work\\create_trigger_bigdata(1).sql");
        FileItem fileItem;
        fileItem = new DiskFileItemFactory().createItem("file", MediaType.MULTIPART_FORM_DATA_VALUE, true, f.getName());

        try (InputStream input = new FileInputStream(f); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }
        CommonsMultipartFile file = new CommonsMultipartFile(fileItem);
        return uploadService.handleFileUpload(file);
    }
}
