package com.gabriel.rest.webservices.restfulwebservices.Repository;

import com.gabriel.rest.webservices.restfulwebservices.Model.Post;
import com.gabriel.rest.webservices.restfulwebservices.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
