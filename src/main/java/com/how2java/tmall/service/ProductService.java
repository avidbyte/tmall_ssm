package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Product;

import java.util.List;

public interface ProductService {
    /**
     * 新增
     * @param p
     */
    void add(Product p);
    void delete(int id);
    void update(Product p);
    Product get(int id);
    List list(int cid);
}
