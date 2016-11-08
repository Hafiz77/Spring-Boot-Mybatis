package com.mapper;

import com.entity.City;
import com.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Hafiz on 11/8/2016.
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USER ( firstname,lastname, email,password,age ,phone ) VALUES ( #{user.firstname}, #{user.lastname},#{user.email},#{user.password}, #{user.age},#{user.phone})")
    Integer insertUser(@Param("user") User user) throws Exception;

    @Select("select * from user where email = #{email}")
    User findByEmail(@Param("email") String email);

    @Select("select * from user where email = #{email} AND id!=#{id}")
    User findByEmailNotUser(@Param("email") String email,@Param("id") Integer id);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where email = #{email} AND password = #{password}")
    User login(@Param("email") String email,@Param("password") String password);


    @Select("select * from user")
    List<User> getUsers();

    @Update("UPDATE USER SET firstname = #{user.firstname},lastname = #{user.lastname},email = #{user.email},phone = #{user.phone},age = #{user.age} WHERE id = #{user.id}")
    Integer updateUser(@Param("user") User user) throws Exception;

    @Delete("DELETE from user where id = #{id}")
    Integer deleteById(@Param("id") Integer id);



}
