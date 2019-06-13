package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();

    Category findCategoryById(long id);

    void deleteCategoryById(long id) throws Exception;

    void insertCategory(Category category)throws Exception;

    void updateCategory(Category category)throws Exception;
}
