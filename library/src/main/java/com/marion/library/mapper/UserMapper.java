package com.marion.library.mapper;

import com.marion.library.pojo.Users;

public interface UserMapper {

    Users findByName(String username);
}
