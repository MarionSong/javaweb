package com.marion.library.mapper;

import com.marion.library.pojo.Kungfu;

import java.util.List;



public interface KungfuMapper {
    List<Kungfu> kungfu();
    List<Kungfu> findRank(String name);

    void addKungfu(Kungfu kungfu);

    void deleteKungfu(Long id);

    List<Kungfu> selectById(Long id);

    void update(Kungfu kungfu);

    Long findByName(String parentName);

    void addRank(Kungfu kungfu);

    void updateRank(Kungfu kungfu);
}
