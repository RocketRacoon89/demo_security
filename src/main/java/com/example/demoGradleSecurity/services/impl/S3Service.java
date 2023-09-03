//package com.example.demoGradleSecurity.services.impl;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.*;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.FileCopyUtils;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//@Slf4j
//@Service
//public class S3Service {
//
//    private final static String bucketName = "liketutorial";
//
//    private final AmazonS3 s3client;
//
//    @Autowired
//    public S3Service(AmazonS3 s3client) {
//        this.s3client = s3client;
//    }
//
//    public void createBucket() {
////        String bucketName = "liketutorial";
//
//        if (s3client.doesBucketExistV2(bucketName)) {
//            System.out.println("Bucket {} already exists, use a different name "+bucketName);
////            log.info("Bucket {} already exists, use a different name",bucketName);
//            return;
//        }
//
//        s3client.createBucket(bucketName);
//    }
//
//    public void listBuckets() {
//        List<Bucket> buckets = s3client.listBuckets();
////        log.info("buckets: {}", buckets);
//    }
//
////    @SneakyThrows
////    public void uploadFile() {
//////        String bucketName = "liketutorial";
////        ClassLoader loader = S3Service.class.getClassLoader();
////        File file = new File(loader.getResource("liketutorial.txt").getFile());
////        s3client.putObject(bucketName,"liketutorial.txt", file);
////    }
//
//    @SneakyThrows
//    public void uploadFile(String fileName) {
////        String bucketName = "liketutorial";
//        System.out.println("1 S3Service_UploadFile - fileName = "+fileName);
//        ClassLoader loader = S3Service.class.getClassLoader();
//        System.out.println("2 S3Service_UploadFile - fileName = "+fileName);
//        File file = new File(loader.getResource(fileName).getFile());
//        s3client.putObject(bucketName,fileName, file);
//    }
//
//    public void listFiles() {
////        String bucketName = "liketutorial";
//        ObjectListing objects = s3client.listObjects(bucketName);
//        for(S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
////            log.info("File name: {}", objectSummary.getKey());
//        }
//    }
//
////    @SneakyThrows
////    public void downloadFile() throws IOException {
//////        String bucketName = "liketutorial";
////        S3Object s3Object = s3client.getObject(bucketName, "liketutorial.txt");
////        S3ObjectInputStream inputStream = s3Object.getObjectContent();
////        File file = new File("<PUT_DESIRED_PATH_HERE>");
////        FileCopyUtils.copy(inputStream, new FileOutputStream(file));
////    }
//
//    @SneakyThrows
//    public void downloadFile(String fileName) throws IOException {
////        String bucketName = "liketutorial";
//        S3Object s3Object = s3client.getObject(bucketName, fileName);
//        S3ObjectInputStream inputStream = s3Object.getObjectContent();
//        File file = new File("<PUT_DESIRED_PATH_HERE>");
//        FileCopyUtils.copy(inputStream, new FileOutputStream(file));
//    }
//
////    public void deleteFile() {
////        String bucketName = "liketutorial";
////        s3client.deleteObject(bucketName, "liketutorial.txt");
////    }
//
//    public void deleteFile(String fileName) {
////        String bucketName = "liketutorial";
//        s3client.deleteObject(bucketName, fileName);
//    }
//}
