package com.example.demoGradleSecurity.rest;

import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/api/v1/upload", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
public class UploadController {

    @PostMapping
    public void uploadTest( MultipartFile file) {
        System.out.println("UPLOAD TEST");

        System.out.println(file.getName());
    }
}
