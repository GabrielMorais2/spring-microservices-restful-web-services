package com.gabriel.rest.webservices.restfulwebservices.Model;

import com.gabriel.rest.webservices.restfulwebservices.Model.Request.PostRequestDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Request.UserRequestDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Response.PostResponseDto;
import com.gabriel.rest.webservices.restfulwebservices.Model.Response.UserResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    private final ModelMapper mapper;

    public PostMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public PostResponseDto mapToDto(Post post) {
        return mapper.map(post, PostResponseDto.class);
    }

    public Post mapToEntity(PostRequestDto postRequestDto) {
        return mapper.map(postRequestDto, Post.class);
    }

}
