package cn.edu.ncu.jiluan.bbs.controller;

import cn.edu.ncu.jiluan.bbs.service.PostService;
import cn.edu.ncu.jiluan.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class ViewController {
    @Autowired
    private PostService postService;
    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/post/{postId}",method = RequestMethod.GET)
    public String GetPostContent(@PathVariable Integer postId, Model model){
        model.addAttribute("post",postService.findPostEntityByPostId(postId));
        model.addAttribute("replyList",replyService.findReplyEntitiesByPostId(postId));
        return "postContent";
    }
}
