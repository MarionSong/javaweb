package com.marion.library.service;

import com.marion.library.pojo.Kungfu;

import java.util.List;
import java.util.Map;

public interface KungfuService {
    List<Kungfu> kungfuName();

    List<Kungfu> findRank(String name);

    void addKungfu(Kungfu kungfu);

    void deleteKungfu(Long id);

    List<Kungfu> selectById(Long id);

    void update(Kungfu kungfu);

    void addRank(String parentName,Kungfu kungfu);

    void updateRank(Kungfu kungfu);
}
