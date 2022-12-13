package services;

import data.models.Comment;
import data.models.Post;
import dto.requests.CreateCommentRequest;

import java.util.List;

public interface CommentService {
    void createComment(CreateCommentRequest creatCommentRequest);
    void updateComment(int id, String commenterName, String comment);
    void deleteComment(int id);
    Comment viewComment(int id);

    List<Comment> viewAllComment();
}
