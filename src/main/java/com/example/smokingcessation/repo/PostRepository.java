package com.example.smokingcessation.repo;

import com.example.smokingcessation.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long> {
}
