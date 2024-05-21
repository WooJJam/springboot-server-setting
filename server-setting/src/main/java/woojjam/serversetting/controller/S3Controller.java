//package woojjam.serversetting.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import woojjam.serversetting.service.AwsS3Service;
//
//import java.io.IOException;
//import java.net.URISyntaxException;
//
//@Controller
//@RequiredArgsConstructor
//@RequestMapping("/server-setting/s3")
//public class S3Controller {
//
//    private final AwsS3Service awsS3Service;
//    @GetMapping("/test")
//    public String s3Test() {
//        return "upload";
//    }
//
//    @ResponseBody
//    @PostMapping("/test")
//    public Object s3UploadTest(@RequestParam(name = "image")MultipartFile multipartFile) throws IOException, URISyntaxException {
//        return awsS3Service.s3Test(multipartFile);
//    }
//}
