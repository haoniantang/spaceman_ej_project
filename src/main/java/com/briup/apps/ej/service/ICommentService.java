package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Comment;

import java.util.List;

public interface ICommentService {

    //
    public List<Comment> findAllComment();

    //根据订单id查询评论
    public List<Comment> findCommentByOrderId(Long order_id);
    //根据评论id删除该订单评论
    public void deleteCommentById(Long id)throws Exception;
    //根据order_id添加对一个订单添加一个评论
    public void insertComment(Comment comment);

}
