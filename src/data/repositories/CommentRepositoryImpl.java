package data.repositories;

import data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{
    private int count;
    List<Comment> commentDb = new ArrayList<>();
    @Override
    public Comment save(Comment comment) {
        if (comment.getId() != 0) update(comment);
        else {
            comment.setId(generateId());
            commentDb.add(comment);
        }
        return comment;
    }

    private int generateId() {
        return ++count;
    }

    private void update(Comment comment) {
        Comment savedComment = findById(comment.getId());
        savedComment.setCommenterName(comment.getCommenterName());
        savedComment.setComment(comment.getComment());

    }

    @Override
    public Comment findById(int id) {
        for (var comment: commentDb) if (comment.getId() == id) return comment;
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return commentDb;
    }

    @Override
    public long count() {
        return commentDb.size();
    }

    @Override
    public void delete(Comment comment) {
        commentDb.remove(comment);

    }

    @Override
    public void delete(int id) {
        commentDb.removeIf(comment -> comment.getId() == id);

    }
}
