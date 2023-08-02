package com.gabriel.rest.webservices.restfulwebservices.Repository;

import com.gabriel.rest.webservices.restfulwebservices.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
