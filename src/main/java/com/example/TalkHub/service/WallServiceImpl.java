package com.example.TalkHub.service;

import com.example.TalkHub.models.PostModel;
import com.example.TalkHub.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallServiceImpl implements WallService {

    private final PostRepository postRepository;

    @Autowired
    public WallServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<PostModel> getPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dateNow").descending());
        Page<PostModel> postPage = postRepository.findAll(pageable);
        return postPage.getContent();
    }

    @Override
    public void addPost(PostModel postModel) {
        postRepository.save(postModel);
    }

    @Override
    public PostModel getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }
}
