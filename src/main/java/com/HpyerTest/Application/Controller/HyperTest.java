package com.HpyerTest.Application.Controller;

import com.HpyerTest.Application.Model.ApiResponse;
import com.HpyerTest.Application.Model.PostRequest;
import com.HpyerTest.Application.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;


@RestController
public class HyperTest {

    @Value("${api.endpoint.prefix}")
    private String apiEndpoint;

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod. POST,value = "/api/{apiEndpoint}")
    public ResponseEntity<?> createNewPost(@RequestBody PostRequest postRequest) {
        Long postId = null;
        String httpResponseBody = null;
        try {
            postId = postService.createNewPost(postRequest.getPostName(), postRequest.getPostContents());
            httpResponseBody = postService.makeOutboundHttpCall();
            return ResponseEntity.ok(new ApiResponse(postId, httpResponseBody));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(postId,httpResponseBody));
        }
    }
}
