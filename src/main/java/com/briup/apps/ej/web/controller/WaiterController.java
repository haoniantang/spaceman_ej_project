package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.service.IWaiterService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(description = "服务员管理相关接口")
@RestController
@RequestMapping("/waiter")
public class WaiterController {
    @Autowired
    private IWaiterService waiterService;

    @ApiOperation("模糊查询服务员信息")
    @GetMapping("query")
    public Message query(Waiter waiter){
        List<Waiter> list = waiterService.query(waiter);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("查询所有服务员信息")
    @GetMapping("findAllWaiter")
    public Message findAllWaiter(){
        List<Waiter> list = waiterService.findAllWaiter();
        return MessageUtil.success("success",list);
    }

    @ApiOperation("通过id查询服务员信息")
    @GetMapping("findWaiterById")
    public Message findWaiterById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        Waiter waiter = waiterService.findWaiterById(id);
        return MessageUtil.success("success",waiter);
    }

    @ApiOperation("保存或更新服务员信息")
    @GetMapping("saveOrUpdateWaiter")
    public Message saveOrUpdateWaiter(@Valid @ModelAttribute Waiter waiter){
        try {
            waiterService.saveOrUpdateWaiter(waiter);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除服务员信息")
    @GetMapping("deleteWaiterById")
    public Message deleteWaiterById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            waiterService.deleteWaiterById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id恢复服务员信息")
    @GetMapping("recoverWaiterById")
    public Message recoverWaiterById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            waiterService.recoverWaiterById(id);
            return MessageUtil.success("恢复成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @PostMapping("batchDeleteWaiter")
    @ApiOperation("批量删除服务员信息")
    public Message batchDeleteWaiter(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        waiterService.batchDeleteWaiter(ids);
        return MessageUtil.success("批量删除成功");
    }

}