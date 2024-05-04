package com.HpyerTest.Application.Service;

import com.HpyerTest.Application.Entity.Post;
import com.HpyerTest.Application.Model.PostRequest;

import java.util.List;

public interface PostService {
    Long createNewPost(String name, String contents);
    String makeOutboundHttpCall();
}
