package com.marion.library.controller;

import com.marion.library.pojo.Kungfu;
import com.marion.library.service.KungfuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class KungfuController {

    @Autowired
    private KungfuService kungfuService;

    /**
     * 自定义的登陆首页
     * @return
     */
    @RequestMapping("/userlogin")
    public String login(){
        return "userlogin";
    }


    /**
     * 默认首页
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String kungfu(Model model){
        List<Kungfu> kungfus = kungfuService.kungfuName();
        model.addAttribute("kungfus",kungfus);
        return "welcome";
    }

    /**
     * 查看功法的对应修炼方法
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("/rank/{name}")
    public String rank(@PathVariable("name")String name, Model model){
        List<Kungfu> rank = kungfuService.findRank(name);
        model.addAttribute("rank",rank);
        model.addAttribute("name",name);
        return "page/kungfu";
    }

    /**
     * 跳转到创建功法的页面
     * @return
     */
    @RequestMapping("/insert")
    public String insert(){
        return "page/addlist";
    }

    /**
     * 创建功法
     * @return
     */
    @PostMapping("/addKungfu")
    public String addKungfu(Kungfu kungfu){
        kungfuService.addKungfu(kungfu);
        return "redirect:/";
    }

    /**
     * 删除功法
     * @param id
     * @return
     */
    @RequestMapping("/delete/{id}")
    public String deleteKungfu(@PathVariable("id") Long id){
        kungfuService.deleteKungfu(id);
        return "redirect:/";
    }

    /**
     * 修改数据之前信息回显
     * @param id
     * @param model
     * @return
     */

    @RequestMapping("/update/{id}")
    public String selectKungfu(@PathVariable("id")Long id,Model model){
        List<Kungfu> message = kungfuService.selectById(id);
        System.out.println(message);
        model.addAttribute("message",message);
        return "page/updatelist";
    }

    /**
     * 修改技能名称和说明
     * @param kungfu
     * @return
     */

    @RequestMapping("/updateKungfu")
    public String updateKungfu(Kungfu kungfu){
        System.out.println(kungfu);
        kungfuService.update(kungfu);
        return "redirect:/";
    }

    /**
     * 到功法等级添加页面
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("/insertRank/{name}")
    public String insertRank(@PathVariable("name") String name,Model model){
        model.addAttribute("parentName",name);
        return "page/addrank";
    }

    /**
     * 提交修改的功法等级
     * @param parentName
     * @param kungfu
     * @return
     */
    @RequestMapping("/addrank/{parentName}")
    public String addRank(@PathVariable("parentName")String parentName, Kungfu kungfu){
        System.out.println(parentName);
        kungfuService.addRank(parentName,kungfu);
        return "redirect:/rank/{parentName}";
    }

    /**
     * 修改技能等级数据的回显
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/updaterank/{name}/{id}")
    public String selectRank(@PathVariable("name")String name,@PathVariable("id")Long id,Model model){
        List<Kungfu> message = kungfuService.selectById(id);
        System.out.println(message);
        model.addAttribute("message",message);
        model.addAttribute("name",name);
        return "page/updaterank";
    }

    /**
     * 修改技能等级
     * @param name
     * @param kungfu
     * @return
     */

    @RequestMapping("/updateRank/{name}")
    public String updateRank(@PathVariable("name")String name, Kungfu kungfu){
        System.out.println(name);
        kungfuService.updateRank(kungfu);
        return "redirect:/rank/{name}";
    }


}
