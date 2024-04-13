package woojjam.serversetting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import woojjam.serversetting.service.AwsS3Service;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/server-setting/s3")
public class S3Controller {

    private final AwsS3Service awsS3Service;
    @GetMapping("/test")
    public String s3Test() {
        return "upload";
    }

    @ResponseBody
    @PostMapping("/test")
    public String s3UploadTest(@RequestParam(name = "image")MultipartFile multipartFile) throws IOException {
        return awsS3Service.testS3(multipartFile);
    }
}
