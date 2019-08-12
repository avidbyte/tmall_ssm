package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Category;


import java.util.List;

public interface CategoryService {
    //查询所有Category
    List<Category> list();

    //添加一个分类
    void add(Category category);

    //删除一个分类
    void delete(int id);

    //为编辑界面返回需要编辑的分类信息
    Category get(int id);

    //更新分类
    void update(Category category);
}