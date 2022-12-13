package services;

import dto.requests.CreatePostRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostServiceImplTest {
    PostService postService;
    @BeforeEach
    void setUp() {
        postService = new PostServiceImpl();
    }
    @Test
    void test_that_create_works(){
        CreatePostRequest createPostRequest = new CreatePostRequest();
        createPostRequest.setTitle("new post");
        createPostRequest.setBody("Egusi i my best soup");
        postService.createPost(createPostRequest);
        assertEquals(1, postService.viewAllPost().size());
    }
}