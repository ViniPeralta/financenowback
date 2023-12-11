package com.peralta.financenow.persistence.user;

import com.peralta.financenow.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from tb_users where username = :username", nativeQuery = true)
    User findByUserName(String username);

    @Query(value = "select * from tb_users where email = :email", nativeQuery = true)
    User findByEmail(String email);

    @Query(value = "select * from tb_users where username = :username and password = :password", nativeQuery = true)
    User findByUsernameAndPassword(String username, String password);

    @Query(value = "select * from tb_users where id = :id", nativeQuery = true)
    User getById(Long id);
}
