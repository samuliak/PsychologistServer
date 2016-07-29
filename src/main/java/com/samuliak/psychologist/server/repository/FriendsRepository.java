package com.samuliak.psychologist.server.repository;

import com.samuliak.psychologist.server.entity.Friends;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendsRepository extends CrudRepository<Friends, Integer>{
    @Query("select f from Friends f where f.doctor_login_one like :login and f.isFriend = true or f.doctor_login_two like :login " +
            "and f.isFriend = true")
    List<Friends> findAllFriendsByLogin(@Param("login") String login);

    @Query("select f from Friends f where f.doctor_login_one like :login and f.isFriend = false or f.doctor_login_two like :login " +
            "and f.isFriend = false")
    List<Friends> findAllFriendsRequestByLogin(String login);

}
