package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.ProductExample;
import com.briup.apps.ej.dao.ProductMapper;
import com.briup.apps.ej.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public long productNum(){
        ProductExample  productExample=new ProductExample();
        productExample.createCriteria().andStatusEqualTo("1");
        long num=productMapper.countByExample(productExample);
        return num;
    }
    //查询所有
    @Override
    public List<Product> findAllProduct() {
        ProductExample productExample=new ProductExample();
        ProductExample.Criteria criteria=productExample.createCriteria();
        criteria.andStatusEqualTo("1");
        List<Product> findAllProductList=productMapper.selectByExample(productExample);
        return findAllProductList;
    }
    //分页查询
    @Override
    public List<Product> findProductByPage(int currentPage){
        int rows=5;
        ProductExample productExample=new ProductExample();
        ProductExample.Criteria criteria=productExample.createCriteria();
        int start = (currentPage - 1) * rows;
        criteria.andStatusEqualTo("1");
        //分页查询中的一页数量
        productExample.setPageSize(rows);
        // 开始查询的位置
        productExample.setStartRow(start);
        List<Product> findProductByPageList=productMapper.selectByExample(productExample);
        return findProductByPageList;
    }

    @Override
    public List<Product> findProductByCategoryId(Long category_id) {
        ProductExample productExample=new ProductExample();
        ProductExample.Criteria criteria=productExample.createCriteria();
        criteria.andStatusEqualTo("1").andCategoryIdEqualTo(category_id);
        List<Product> findProductByCategoryIdList=productMapper.selectByExample(productExample);
        return findProductByCategoryIdList;
    }

    @Override
    public void deleteProductById(Long id) throws Exception {
        Product product=productMapper.selectByPrimaryKey(id);
        if(product == null){
            throw new Exception("要删除的产品不存在");
        } else {
            productMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void insertProduct(Product product) {
        productMapper.insertSelective(product);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateByPrimaryKeySelective(product);
    }
}