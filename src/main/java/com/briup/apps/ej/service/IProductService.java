package com.briup.apps.ej.service;


import com.briup.apps.ej.bean.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {

    //产品数
    public  long productNum();

    public Product findProductById(Long id)throws Exception;

    //根据产品id查询产品信息
    //public Product find

    //查询所有产品
    public List<Product> findAllProduct();

    //根据页号进行分页查询
    public List<Product> findProductByPage(int currentPage);

    //根据分类id查询该分类下的所有产品
    public List<Product> findProductByCategoryId(Long category_id);

    //根据商品id删除该商品
    public void deleteProductById(Long id)throws Exception;

    //批量删除
    public void deleteBathProduct(List<Long> id)throws Exception;

    //添加一种产品
    public void insertProduct(Product product);

    //批量添加产品
    public  void insertBathProduct(List<Product> products);

    //修改商品的信息
    public void updateProduct(Product product);

    //批量修改商品状态
    public void UpdateBatchProductStatus(Map<String,Object> map) throws Exception;

    //如果需要可增加返回商品信息及商品分类的数据集合
}
