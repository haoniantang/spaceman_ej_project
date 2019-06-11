package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.service.ICommentService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @ApiOperation("通过订单id查询评论")
    @GetMapping("findCommentById")
    public Message findCommentById(
            @ApiParam(value = "order_id",required = true)
            @RequestParam(value = "order_id") Long order_id){
        if(order_id != null){
            List<Comment> findCommentList=commentService.findCommentById(order_id);
            if(findCommentList.size()==0){

                return MessageUtil.success("根据订单id查询订单评论成功,该订单暂无评论！");
            }else {
                return MessageUtil.success("根据订单id查询订单评论成功！",findCommentList);
            }
        }else{
            return MessageUtil.error("查询失败:订单号获取失败！");
        }
    }

    @ApiOperation("通过评论id删除对应评论")
    @GetMapping("deleteCommentById")
    public Message deleteCommentById(
            @ApiParam(value = "主键",required = true)
            @RequestParam("id") long id)throws Exception{
        try{
            commentService.deleteCommentById(id);
            return MessageUtil.success("删除成功!");
        } catch(Exception e) {
            e.printStackTrace();
            return MessageUtil.error("删除失败:"+e.getMessage());
        }
    }

    @ApiOperation("新增一条评论")
    @GetMapping("insertComment")
    public Message insertComment(Comment comment){
        comment.setCommentTime(new Date().getTime());//若前端提交的对象含有时间则此行可注释掉
        commentService.insertComment(comment);
        return  MessageUtil.success("评论成功！");
    }
}
