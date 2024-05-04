package com.HpyerTest.Application.Repository;

import com.HpyerTest.Application.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}
