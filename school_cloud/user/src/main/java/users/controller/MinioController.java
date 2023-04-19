package users.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import users.config.minio.MinioUtils;
import users.model.utilsDto.ResultData;

import java.util.List;

/**
 * @author qjp
 */
@Api(tags = "文件上传")
@Slf4j
@RequestMapping("/user/open")
@CrossOrigin
@RestController
public class MinioController {
    @Autowired
    private MinioUtils minioUtils;
    private String bucketName="test";

    private final String address = "http://121.36.100.147:9000";
    /**
     * 上传
     * @param file
     * @return
     */
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public ResultData upload(MultipartFile file) {
        List<String> upload = minioUtils.upload(new MultipartFile[]{file},bucketName);
        String path = address +"/"+bucketName+"/"+upload.get(0);
        return new ResultData("200","ok",path);
    }

}

