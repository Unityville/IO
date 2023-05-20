package com.unityville.IO.controllers;

import com.unityville.IO.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private CommentService commentService;

//    @PostMapping
//    public Comment saveComment(Comment comment) {
//        return commentService.save(comment);
//    }

}
