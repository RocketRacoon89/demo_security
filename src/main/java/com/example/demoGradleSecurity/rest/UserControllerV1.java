package com.example.demoGradleSecurity.rest;

import com.example.demoGradleSecurity.config.FileResponse;
import com.example.demoGradleSecurity.entity.UserEntity;
import com.example.demoGradleSecurity.services.StorageService;
import com.example.demoGradleSecurity.services.UserService;
//import com.example.demoGradleSecurity.services.impl.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.*;
import java.io.File;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserControllerV1 {

    @Autowired
    private UserService userService;

    @Autowired
    private StorageService storageService;

//    @Autowired
//    private S3Service s3Service;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable int id) {
        return userService.findById(id);
    }

//    @GetMapping("/email")
//    public UserEntity getUser(@PathVariable String email) {
//        return userService.findByEmail(email);
//    }

    @PostMapping
    public UserEntity addUser(@RequestBody UserEntity user) {
        return userService.saveUser(user);
    }

    @PutMapping
    public UserEntity updateUser(@RequestBody UserEntity user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }

    @PostMapping(value = "/up")
    @ResponseBody
    public FileResponse uploadTest(@RequestParam("file") MultipartFile file) {
        String name = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/download").path(name).toUriString();

        System.out.println("UPLOAD TEST "+ file.getOriginalFilename());

        String fileName = file.getOriginalFilename();

        System.out.println("UPLOAD TEST 2"+ fileName);

//        s3Service.uploadFile(fileName);

        return new FileResponse(name, uri, file.getContentType(), file.getSize());

    }


}
