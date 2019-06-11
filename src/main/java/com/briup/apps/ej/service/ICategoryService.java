package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(long id);

    void deleteById(long id) throws Exception;

    void insert(Category category)throws Exception;

    void updatePrimaryKey(Category category)throws Exception;
}
