package woojjam.serversetting.service;

import io.awspring.cloud.s3.S3Resource;
import io.awspring.cloud.s3.S3Template;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

@Service
@RequiredArgsConstructor
public class AwsS3Service {
    @Value("${spring.cloud.aws.s3.bucket}")
    private String bucket;
    private final S3Presigner s3Presigner;
    private final S3Template s3Template;

//    public String createPreSignedUrlForUpload(String path) {
//        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
//                .bucket(bucket)
//                .key(path)
//                .contentType("image/jpeg")
//                .build();
//
//        PutObjectPresignRequest putObjectPresignRequest = PutObjectPresignRequest.builder()
//                .signatureDuration(Duration.ofMinutes(5))
//                .putObjectRequest(putObjectRequest)
//                .build();
//
//        return s3Presigner.presignPutObject(putObjectPresignRequest).url().toString();
//    }

    @Data
    @Getter
    @AllArgsConstructor
    static class Person {
        private String name;
        private String gender;
    }
    public String testS3(MultipartFile multipartFile) throws IOException {

        InputStream inputStream = multipartFile.getInputStream();
        S3Resource image = s3Template.upload(bucket, "image", inputStream);
        s3Template.deleteObject(bucket, "image");
        return "success";
    }


}
