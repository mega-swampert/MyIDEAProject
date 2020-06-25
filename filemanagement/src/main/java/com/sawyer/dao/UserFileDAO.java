package com.sawyer.dao;

import com.sawyer.entity.UserFile;

import java.util.List;

public interface UserFileDAO {
    //根据登录用户ID获取该用户的文件列表
    List<UserFile> findByUserId(Integer id);

    //保存用户文件信息
    void save(UserFile userFile);

    //根据文件ID获取文件信息
    UserFile findById(Integer id);

    //更新文件信息
    void update(UserFile userFile);


    void delete(Integer id);
}
