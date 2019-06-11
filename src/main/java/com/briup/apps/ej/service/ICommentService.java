package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Comment;

import java.util.List;

public interface ICommentService {

    //
    public List<Comment> findAllComment();

    //根据订单id查询评论
    public List<Comment> findCommentById(Long order_id);

}
