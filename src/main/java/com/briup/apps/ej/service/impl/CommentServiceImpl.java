package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.CommentExample;
import com.briup.apps.ej.dao.CommentMapper;
import com.briup.apps.ej.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    private CommentMapper commentMapper;


    public List<Comment> findAllComment() {
        return null;
    }

    @Override
    public List<Comment> findCommentById(Long order_id) {
        CommentExample commentExample=new CommentExample();
        CommentExample.Criteria criteria=commentExample.createCriteria();
        criteria.andOrderIdEqualTo(order_id);
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public void deleteCommentById(Long id)throws Exception {
        Comment comment=commentMapper.selectByPrimaryKey(id);
        if(comment == null){
            throw new Exception("要删除的用户不存在");
        } else {
            commentMapper.deleteByPrimaryKey(id);
        }

    }
}
