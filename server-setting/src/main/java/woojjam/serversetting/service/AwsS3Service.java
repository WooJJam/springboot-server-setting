//package woojjam.serversetting.service;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.CannedAccessControlList;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import com.amazonaws.util.IOUtils;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URISyntaxException;
//import java.time.Duration;
//
//@Service
//@RequiredArgsConstructor
//public class AwsS3Service {
//    @Value("${cloud.aws.s3.bucket}")
//    private String bucket;
////    private final S3Template s3Template;
//    private final AmazonS3 amazonS3;
//
//    public Object s3Test(MultipartFile multipartFile) throws IOException, URISyntaxException {
//
////        InputStream inputStream = multipartFile.getInputStream();
////        S3Resource image = s3Template.upload(bucket, LocalDateTime.now().toString(), inputStream);
//////        s3Template.deleteObject(bucket, "image");
////        S3Resource findImage = s3Operations.download(bucket, Objects.requireNonNull(image.getFilename()));
////        return findImage;
//
//        String originalFilename = multipartFile.getOriginalFilename();
//        InputStream is = multipartFile.getInputStream();
//        byte[] bytes = IOUtils.toByteArray(is);
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//
//        PutObjectRequest putObjectRequest =
//                new PutObjectRequest(bucket, originalFilename, byteArrayInputStream, null)
//                        .withCannedAcl(CannedAccessControlList.PublicRead);
//
//        amazonS3.putObject(putObjectRequest);
//
//        return amazonS3.getUrl(bucket, multipartFile.getOriginalFilename());
//    }
//}
