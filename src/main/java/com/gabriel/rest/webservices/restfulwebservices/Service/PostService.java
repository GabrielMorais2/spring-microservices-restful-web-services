package com.gabriel.rest.webservices.restfulwebservices.Service;

import com.gabriel.rest.webservices.restfulwebservices.Model.Post;
import com.gabriel.rest.webservices.restfulwebservices.Model.PostMapper;
import com.gabriel.rest.webservices.restfulwebservices.Model.Request.PostRequestDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Request.UserRequestDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Response.PostResponseDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Response.UserResponseDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.User;
import com.gabriel.rest.webservices.restfulwebservices.Model.UserMapper;
import com.gabriel.rest.webservices.restfulwebservices.Repository.PostRepository;
import com.gabriel.rest.webservices.restfulwebservices.Repository.UserRepository;
import com.gabriel.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, PostMapper postMapper, UserRepository userRepository){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postMapper = postMapper;
    }

    public List<PostResponseDto> findAllPostsByUsers(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

        List<Post> posts = user.getPosts();

        return posts.stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public PostResponseDto save(PostRequestDto postRequestDto, Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));

        Post post = postMapper.mapToEntity(postRequestDto);
        post.setUser(user);

        postRepository.save(post);
        return postMapper.mapToDto(post);
    }

}
