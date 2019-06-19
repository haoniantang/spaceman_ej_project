package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.service.IProductService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Api(description = "产品管理相关接口")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @ApiOperation("根据产品id查询")
    @PostMapping("findProductById")
    public  Message findProductById(
            @ApiParam(value = "主键",required = true)
            @RequestParam("id") Long id) throws Exception{
        try{
            Product product=productService.findProductById(id);
            return MessageUtil.success("上线商品总数",product);
        }catch (Exception e){
            e.getStackTrace();
            return MessageUtil.error("查询产品失败："+e.getMessage());

        }

    }

    @ApiOperation("根据姓名模糊查询")
    @GetMapping("findProductByName")
    public  Message findProductByName(
            @ApiParam(value = "查询关键字",required = true)
            @RequestParam("name") String  name) throws Exception{
        try{
            List<Product> products=productService.findProductByName(name);
            return MessageUtil.success("上线商品总数",products);
        }catch (Exception e){
            e.getStackTrace();
            return MessageUtil.error("查询产品失败："+e.getMessage());

        }

    }

    @ApiOperation("获得上线商品总数")
    @PostMapping("productNum")
    public  Message productNum(){
        long num=productService.productNum();
        return MessageUtil.success("上线商品总数",num);
    }

    @ApiOperation("查询全部上线产品")
    @PostMapping("findAllProduct")
    public Message findAllProduct(){
        List<Product> allProduct=productService.findAllProduct();
        return  MessageUtil.success("查询全部上线产品成功",allProduct);
    }

    @ApiOperation("分页查询上线产品")
    @PostMapping("findProductByPage")
    public Message findProductByPage(
            @ApiParam(value = "页号",required = true)
            @RequestParam("currentPage")int currentPage){
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
    @PostMapping("findProductByCategoryId")
    public Message findProductByCategoryId(
            @ApiParam(value = "分类id",required = true)
            @RequestParam("category_id")Long category_id){
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
    @PostMapping("insertProduct")
    public Message insertProduct(@Valid @ModelAttribute Product product) {
        product.setStatus("1");
        productService.insertProduct(product);
        return MessageUtil.success("添加产品成功！");
    }

    @ApiOperation("批量添加产品")
    @PostMapping("insertBathProduct")
    public Message insertBathProduct(
            @ApiParam(value = "批量添加产品",required = true)
            @RequestBody List<Product> products) {
        try {
            productService.insertBathProduct(products);
            return MessageUtil.success("添加产品成功！");
        }catch (Exception e){
            e.getStackTrace();
            return MessageUtil.error("添加产品失败！"+e.getMessage());
        }
    }

    @ApiOperation("更新产品")
    @PostMapping("updateProduct")
    public Message updateProduct(@Valid @ModelAttribute Product product){
        productService.updateProduct(product);
        return MessageUtil.success("更新产品成功！");
    }

    @ApiOperation("批量更新产品状态")
    @GetMapping("UpdateBatchProductStatus")
    public Message UpdateBatchProductStatus(
            @ApiParam(value = "批量更新产品",required = true)
            @RequestParam("status") String status,
            @RequestParam(value = "idList") List<Long> idList){
        Map<String,Object> map = new HashMap<String,Object>();
        if(status.equals("0")||status.equals("1")) {
            try {
                map.put("idList", idList);
                map.put("status", status);
                productService.UpdateBatchProductStatus(map);
                return MessageUtil.success("更新产品成功！");
            }catch (Exception e){
                e.getStackTrace();
                return MessageUtil.error("更新产品失败！"+e.getMessage());
            }
        }else {
            return  MessageUtil.error("警告传值错误！");
        }
    }

    @ApiOperation("删除产品")
    @GetMapping("deleteProductById")
    public Message deleteProductById(
            @ApiParam(value = "主键",required = true)
            @RequestParam("id") Long id)throws Exception{
        try{
            productService.deleteProductById(id);
            return MessageUtil.success("删除成功!");
        }catch (Exception e){
            e.getStackTrace();
            return MessageUtil.error("删除失败:"+e.getMessage());
        }
    }

    @ApiOperation("批量删除产品")
    @GetMapping("deleteBathProduct")
    public Message deleteBathProduct(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "idList")List<Long> idList){
        try{
            productService.deleteBathProduct(idList);
            return MessageUtil.success("删除成功!");
        }catch (Exception e){
            e.getStackTrace();
            return MessageUtil.error("删除失败:"+e.getMessage());
        }
    }
}
