package com.marion.library.service;

import com.marion.library.mapper.KungfuMapper;
import com.marion.library.pojo.Kungfu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class KungfuServiceImpl implements KungfuService {
    @Autowired
    private KungfuMapper kungfuMapper;

    @Override
    public List<Kungfu> kungfuName() {
        return kungfuMapper.kungfu();
    }

    @Override
    public List<Kungfu> findRank(String name) {
        return kungfuMapper.findRank(name);
    }

    @Override
    public void addKungfu(Kungfu kungfu) {
        try {
            Date date = new Date();
            kungfu.setCreateTime(date);
            kungfu.setUpdateTime(date);
            kungfu.setParentId(1);
            kungfuMapper.addKungfu(kungfu);
        }catch (Exception e){
            new RuntimeException("添加失败");
        }
    }

    @Override
    public void deleteKungfu(Long id) {
        kungfuMapper.deleteKungfu(id);
    }

    @Override
    public List<Kungfu> selectById(Long id) {
        List<Kungfu> message = kungfuMapper.selectById(id);
        return message;
    }

    @Override
    public void update(Kungfu kungfu) {
        try{
            Date date=new Date();
            kungfu.setUpdateTime(date);
            kungfuMapper.update(kungfu);
        }catch (Exception e){
            new RuntimeException("更新失败");
        }

    }

    @Override
    public void addRank(String parentName,Kungfu kungfu) {
        try {
            Date date = new Date();
            kungfu.setCreateTime(date);
            kungfu.setUpdateTime(date);
            Long parentId = kungfuMapper.findByName(parentName);
            kungfu.setParentId(parentId);//
            kungfuMapper.addRank(kungfu);
        }catch (Exception e){
            new RuntimeException("添加失败");
        }
    }

    @Override
    public void updateRank(Kungfu kungfu) {
        try{
            Date date=new Date();
            kungfu.setUpdateTime(date);
            kungfuMapper.updateRank(kungfu);
        }catch (Exception e){
            new RuntimeException("更新失败");
        }
    }


}
