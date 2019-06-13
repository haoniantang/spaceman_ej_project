package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.service.ICategoryService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService  categoryService;

    //返回所有的分类信息
    @GetMapping("findAllCategory")
    public Message findAll(){
        List<Category> list=categoryService.findAll();
        return MessageUtil.success("message", list);
    }
    //根据Id查找分类信息
    @GetMapping("findByCateGoryId")
    public Message findById(long id){
        Category category=categoryService.findById(id);
        return MessageUtil.success("success", category);
    }

    //根据Id删除分类信息
    @GetMapping("deleteByCateGoryId")
    public Message deleteById(long id){
        try{
            categoryService.deleteById(id);
            return MessageUtil.success("删除分类成功！");
        }catch(Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    //增加新的分类信息
    @GetMapping("insertCateGory")
    public Message insert(Category category){
        try{
            categoryService.insert(category);
            return MessageUtil.success("增加新的分类成功!");
        }catch(Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    //根据Id更新分类信息
    @GetMapping("updateCateGory")
    public Message update(Category category){
        try{
            categoryService.updatePrimaryKey(category);
            return MessageUtil.success("更新分类成功！");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.success(e.getMessage());
        }
    }

}
