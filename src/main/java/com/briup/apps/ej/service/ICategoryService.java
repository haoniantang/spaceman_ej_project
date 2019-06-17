package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();

    Category findCategoryById(long id);

    //查询所有父级分类
    List<Category> findAllParentCategory();

    void deleteCategoryById(long id) throws Exception;

    void insertCategory(Category category)throws Exception;

    void updateCategory(Category category)throws Exception;
}
