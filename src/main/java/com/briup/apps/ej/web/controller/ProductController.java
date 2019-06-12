package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.service.IProductService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @ApiOperation("获得上线商品总数")
    @GetMapping("productNum")
    public  Message productNum(){
        long num=productService.productNum();
        return MessageUtil.success("上线商品总数",num);
    }

    @ApiOperation("查询全部上线产品")
    @GetMapping("findAllProduct")
    public Message findAllProduct(){
        List<Product> allProduct=productService.findAllProduct();
        return  MessageUtil.success("查询全部上线产品成功",allProduct);
    }

    @ApiOperation("分页查询上线产品")
    @GetMapping("findProductByPage")
    public Message findProductByPage(int currentPage){
        //设置页越界检查
        List<Product> pageProduct=productService.findProductByPage(currentPage);
        //判断结果是否为空
        if(pageProduct.get(0)==null) {
            return MessageUtil.error("查询当前页的上线产品失败,没有查询到结果！");
        }else{
            return MessageUtil.success("查询当前页的上线产品成功！", pageProduct);
        }
    }

    @ApiOperation("根据分类id查询上线产品")
    @GetMapping("findProductByCategoryId")
    public Message findProductByCategoryId(Long category_id){
        //查询分类是否存在

        List<Product> categoryProduct=productService.findProductByCategoryId(category_id);
        //判断结果是否为空
        if(categoryProduct.size()==0) {
            return MessageUtil.error("该分类没有查询到结果！");
        }else{
            return MessageUtil.success("查询当前页的上线产品成功！", categoryProduct);
        }
    }

    @ApiOperation("添加产品")
    @GetMapping("insertProduct")
    public Message insertProduct(Product product) {
        product.setStatus("1");
        productService.insertProduct(product);
        return MessageUtil.success("添加产品成功！");
    }

    @ApiOperation("更新产品")
    @GetMapping("updateProduct")
    public Message updateProduct(Product product){
        productService.updateProduct(product);
        return MessageUtil.success("更新产品成功！");
    }
}