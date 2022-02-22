package com.example.smokingcessation.service;

import com.example.smokingcessation.model.Comment;
import com.example.smokingcessation.model.Post;
import com.example.smokingcessation.model.Session;
import com.example.smokingcessation.model.User;
import com.example.smokingcessation.repo.CommentRepository;
import com.example.smokingcessation.repo.PostRepository;
import com.example.smokingcessation.repo.SessionRepository;
import com.example.smokingcessation.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    @Autowired
    public PostService(PostRepository postRepository, CommentRepository commentRepository, UserRepository userRepository, SessionRepository sessionRepository){
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.userRepository= userRepository;
        this.sessionRepository = sessionRepository;
    }

    public List<Post> getLatestPosts(){
        List<Post> posts = postRepository.findAll();
        posts.sort(Comparator.comparing(Post::getDateTime));
        Collections.reverse(posts);
//        Comparator.comparing(Post::getDateTime)
        return posts;
    }

    public void addComment(String commentBody, String postId, String sessionID){
        Post post = postRepository.findById(postId).get();
        Session session = sessionRepository.findSessionByUuid(sessionID).get();
        String userId = session.getUserID();
        User user = userRepository.findById(userId).get();
        Comment comment = new Comment(user, commentBody,post, LocalDateTime.now());
        commentRepository.save(comment);
        post.addComment(comment);
        postRepository.save(post);
    }
}
