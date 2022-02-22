package com.example.smokingcessation.repo;

import com.example.smokingcessation.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository  extends MongoRepository<Post, String> {
}
