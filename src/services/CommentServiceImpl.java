package services;

import data.models.Comment;
import data.models.Post;
import data.repositories.CommentRepository;
import data.repositories.CommentRepositoryImpl;
import dto.requests.CreateCommentRequest;

import java.util.List;

public class CommentServiceImpl implements CommentService{
    private CommentRepository commentRepository = new CommentRepositoryImpl();

    @Override
    public void createComment(CreateCommentRequest creatCommentRequest) {

        Comment comment = new Comment();
        comment.setComment(creatCommentRequest.getComment());
        comment.setCommenterName(creatCommentRequest.getCommenterName());
        commentRepository.save(comment);
    }

    @Override
    public void updateComment(int id, String commenterName, String comment) {
        Comment updatedComment = new Comment();
        updatedComment.setId(id);
        updatedComment.setCommenterName(commenterName);
        updatedComment.setComment(comment);
        commentRepository.save(updatedComment);
    }

    @Override
    public void deleteComment(int id) {

    }

    @Override
    public Comment viewComment(int id) {
        return null;
    }

    public List<Comment> viewAllComment() {
        return commentRepository.findAll();
    }
}
