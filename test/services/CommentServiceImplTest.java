package services;

import dto.requests.CreateCommentRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentServiceImplTest {
    CommentService commentService;
    @BeforeEach
    void setUp() {
        commentService = new CommentServiceImpl();
    }

    @Test
    void test_that_create_works(){
        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
        createCommentRequest.setCommenterName("olugbenga");
        createCommentRequest.setComment("i dont like java");
        commentService.createComment(createCommentRequest);
        assertEquals(1, commentService.viewAllComment().size());
    }
    @Test
    void test_that_update_works(){
        CreateCommentRequest createCommentRequest = new CreateCommentRequest();
        createCommentRequest.setCommenterName("olugbenga");
        createCommentRequest.setComment("i dont like java");
        commentService.createComment(createCommentRequest);
        assertEquals(1, commentService.viewAllComment().size());

        commentService.updateComment(1, "oluwa","i like java");
       
    }

}