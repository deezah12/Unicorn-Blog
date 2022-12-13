package data.repositories;

import data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {
    CommentRepository commentRepository;
    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }
    @Test
    void save_new_count_should_be_one_test(){
        Comment comment = new Comment();
        comment.setCommenterName("hadiza");
        comment.setComment("love u baby");

        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());
    }
    @Test
    void find_by_id_test(){
        Comment comment = new Comment();
        comment.setCommenterName("kay");
        comment.setComment("im a frontend man");

        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());

        Comment savedComment = commentRepository.findById(1);
        assertEquals(comment, savedComment);

        Comment comment2 = new Comment();
        commentRepository.save(comment2);
        assertEquals(comment2, commentRepository.findById(2));
    }

    @Test
    void save_new_post_updatePost_count_is_one_test(){
        Comment comment = new Comment();
        comment.setCommenterName("kay");
        comment.setComment("im a frontend man");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());

        Comment updatedComment = new Comment();
        updatedComment.setId(1);
        updatedComment.setCommenterName("olukay");
        updatedComment.setComment("im a react man");
        commentRepository.save(updatedComment);

        assertEquals(1L, commentRepository.count());
        assertEquals(comment, commentRepository.findById(1));
        assertEquals("olukay", comment.getCommenterName());
        assertEquals("im a react man", comment.getComment());

    }
    @Test
    void delete_item_count_isZero(){
        Comment comment = new Comment();
        comment.setCommenterName("kay");
        comment.setComment("im a frontend man");
        commentRepository.save(comment);
        assertEquals(1L, commentRepository.count());
        commentRepository.delete(1);
        assertEquals(0, commentRepository.count());
    }
    @Test
    void delete_and_append_post_without_repeating_id(){
        Comment comment = new Comment();
        comment.setCommenterName("kay");
        comment.setComment("im a frontend man");
        commentRepository.save(comment);

        Comment comment2 = new Comment();
        commentRepository.save(comment2);

        Comment comment3 = new Comment();
        commentRepository.save(comment3);

        commentRepository.delete(1);
        assertEquals(2L, commentRepository.count());

        Comment comment4 = new Comment();
        commentRepository.save(comment4);
        assertEquals(3L, commentRepository.count());
        assertEquals(comment4, commentRepository.findById(4));
    }
}