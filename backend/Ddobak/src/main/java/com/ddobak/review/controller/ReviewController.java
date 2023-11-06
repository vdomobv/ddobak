package com.ddobak.review.controller;

import com.ddobak.review.dto.request.ReviewRegisterRequest;
import com.ddobak.review.service.ReviewService;
import com.ddobak.security.util.LoginInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/register")
    public ResponseEntity<?> registerReview(@RequestPart("data") ReviewRegisterRequest req, @RequestPart("file")MultipartFile image, @AuthenticationPrincipal LoginInfo loginInfo){
        reviewService.registerReview(req,loginInfo);
        return ResponseEntity.ok("success");
    }

}
