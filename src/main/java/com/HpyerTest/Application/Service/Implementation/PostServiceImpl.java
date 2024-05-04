package com.HpyerTest.Application.Service.Implementation;


import com.HpyerTest.Application.Entity.Post;
import com.HpyerTest.Application.Repository.PostRepository;
import com.HpyerTest.Application.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Long createNewPost(String name, String contents) {
        Post post = new Post();
        post.setName(name);
        post.setContents(contents);
        Post savedPost = postRepository.save(post);
        return savedPost.getId();
    }

    @Override
    public String makeOutboundHttpCall() {
        String url = "http://worldtimeapi.org/api/timezone/Asia/Kolkata";
        return restTemplate.getForObject(url, String.class);
    }
}
