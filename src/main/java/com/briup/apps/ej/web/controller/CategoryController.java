package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.service.ICategoryService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(description = "类别管理相关接口")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService  categoryService;

    //返回所有的分类信息
    @ApiOperation("查询所有分类信息")
    @GetMapping("findAllCategory")
    public Message findAllCategory(){
        List<Category> list=categoryService.findAllCategory();
        return MessageUtil.success("message", list);
    }
    //根据Id查找分类信息
    @ApiOperation("通过id查询分类信息")
    @GetMapping("findByCateGoryId")
    public Message findCategoryById(long id){
        Category category=categoryService.findCategoryById(id);
        return MessageUtil.success("success", category);
    }

    //根据Id删除分类信息
    @ApiOperation("通过id删除分类信息")
    @GetMapping("deleteCateGoryById")
    public Message deleteCategoryById(long id){
        try{
            categoryService.deleteCategoryById(id);
            return MessageUtil.success("删除分类成功！");
        }catch(Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    //增加新的分类信息
    @ApiOperation("添加新的分类信息")
    @PostMapping("insertCateGory")
    public Message insertCategory(Category category){
        try{
            categoryService.insertCategory(category);
            return MessageUtil.success("增加新的分类成功!");
        }catch(Exception e){
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    //根据Id更新分类信息
    @ApiOperation("通过id更新分类信息")
    @PostMapping("updateCateGory")
    public Message updateCategory(Category category){
        try{
            categoryService.updateCategory(category);
            return MessageUtil.success("更新分类成功！");
        }catch (Exception e){
            e.printStackTrace();
            return MessageUtil.success(e.getMessage());
        }
    }

}
