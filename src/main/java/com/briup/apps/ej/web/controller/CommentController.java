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
            @RequestParam(value = "order_id") long order_id){
        List<Comment> commentList=commentService.findCommentById(order_id);
        return MessageUtil.success("根据订单id查询订单评论成功！",commentList);
    }
}