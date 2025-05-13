package org.example.liongroup.service;

import org.example.liongroup.dto.CommentDto;
import org.example.liongroup.model.Comment;
import org.example.liongroup.model.Profile;
import org.example.liongroup.model.Result;
import org.example.liongroup.repo.CommentRepo;
import org.example.liongroup.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ProfileRepo profileRepo;

    public List<Comment> getAll(){
        return commentRepo.findAll();
    }

    public Comment getById(Long id){
        Optional<Comment> optional = commentRepo.findById(id);
        return optional.get();
    }

    public Result create(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setText(commentDto.getText());

        Optional<Profile> profileOptional = profileRepo.findById(commentDto.getProfileID());
        Profile profile = profileOptional.get();
        comment.setProfileID((List<Profile>) profile);

        comment.setLikeCount(commentDto.getLikeCount());
        commentRepo.save(comment);

        return new Result(true, "Comment created");
    }

    public Result update(Long id, CommentDto commentDto) {
        Optional<Comment> optional = commentRepo.findById(id);
        if (optional.isPresent()) {
            Comment comment = optional.get();
            comment.setText(commentDto.getText());
            comment.setProfileID((List<Profile>) profileRepo);
            comment.setLikeCount(commentDto.getLikeCount());
            commentRepo.save(comment);

            return new Result(true, "Comment updated");
        }
        return new Result(false, "Comment not found");
    }

    public Result delete(Long id){
        commentRepo.deleteById(id);
        return new Result(true, "Comment deleted");
    }
    
}
