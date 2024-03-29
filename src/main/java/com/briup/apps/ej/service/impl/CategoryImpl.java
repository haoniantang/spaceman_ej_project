package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.CategoryExample;
import com.briup.apps.ej.dao.CategoryMapper;
import com.briup.apps.ej.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryImpl implements ICategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAllCategory() {
        CategoryExample example=new CategoryExample();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category findCategoryById(long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> findAllParentCategory() {
        CategoryExample example=new CategoryExample();
        example.createCriteria().andParentIdIsNull();
        return categoryMapper.selectByExample(example);
    }

    @Override
    public void deleteCategoryById(long id) throws Exception {
        Category category=categoryMapper.selectByPrimaryKey(id);
        if(category==null){
            throw new Exception("删除的分类不存在！");
        }else{
            categoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void insertCategory(Category category) throws Exception {
        Category category1=categoryMapper.selectByPrimaryKey(category.getId());
        if(category1==null){
            categoryMapper.insert(category);
        }else{
            throw new Exception("增加的Id已存在");
        }

    }


    @Override
    public void updateCategory(Category category) throws Exception {
        Category category1=categoryMapper.selectByPrimaryKey(category.getId());
        if(category1==null){
            throw new Exception("更新的Id分类不存在！");
        }else{
            categoryMapper.updateByPrimaryKeySelective(category);
        }
    }
}
