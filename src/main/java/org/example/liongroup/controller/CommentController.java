package org.example.liongroup.controller;

import org.example.liongroup.dto.CommentDto;
import org.example.liongroup.model.Comment;
import org.example.liongroup.model.Result;
import org.example.liongroup.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id) {
        Comment comment = commentService.getById(id);
        return comment;
    }

    @PostMapping
    public Result create(@RequestBody CommentDto commentDto) {
        Result result = commentService.create(commentDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        Result result = commentService.update(id, commentDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        Result result = commentService.delete(id);
        return result;
    }
}
