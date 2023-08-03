package com.gabriel.rest.webservices.restfulwebservices.Controller;

import com.gabriel.rest.webservices.restfulwebservices.Model.Request.PostRequestDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Request.UserRequestDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Response.PostResponseDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Response.UserResponseDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.User;
import com.gabriel.rest.webservices.restfulwebservices.Service.PostService;
import com.gabriel.rest.webservices.restfulwebservices.Service.UserService;
import com.gabriel.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostResponseDto>> getAllPosts(@PathVariable Long id) {
        List<PostResponseDto> postDtoList = postService.findAllPostsByUsers(id);
        return ResponseEntity.ok(postDtoList);
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<PostResponseDto> createPost(@Valid @RequestBody PostRequestDto postRequestDto, @PathVariable Long id) {
        PostResponseDto userDto = postService.save(postRequestDto, id);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(userDto);
    }

}
