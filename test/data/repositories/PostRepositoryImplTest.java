package data.repositories;

import data.models.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PostRepositoryImplTest {
    PostRepository postRepository;
    @BeforeEach
    void setUp() {
        postRepository = new PostRepositoryImpl();
    }

    @Test
    void save_new_count_should_be_one_test(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");

        postRepository.save(post);

        assertEquals(1L, postRepository.count());
    }

    @Test
    void find_by_id_test(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);
        assertEquals(1L, postRepository.count());

        Post savedPost = postRepository.findById(1);
        assertEquals(post, savedPost);
        Post post2 = new Post();
        postRepository.save(post2);
        assertEquals(post2, postRepository.findById(2 ));
    }

    @Test
    void save_new_post_updatePost_count_is_one_test(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);

        Post updatedPost = new Post();
        updatedPost.setId(1);
        updatedPost.setBody("updated body");
        updatedPost.setTitle("updated title");
        postRepository.save(updatedPost);
        assertEquals(1L, postRepository.count());
        assertEquals(post, postRepository.findById(1));
        assertEquals("updated body", post.getBody());
        assertEquals("updated title", post.getTitle());
    }

    @Test
    void delete_item_count_isZero(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);

        assertEquals(1L, postRepository.count());
        postRepository.delete(1);
        assertEquals(0L, postRepository.count());
    }
    @Test
    void delete_and_append_post_without_repeating_id(){
        Post post = new Post();
        post.setBody("our post body");
        post.setTitle("our post title");
        postRepository.save(post);

        Post post2 = new Post();
        postRepository.save(post2);

        Post post3 = new Post();
        postRepository.save(post3);

        assertEquals(3L, postRepository.count());
        postRepository.delete(1);
        assertEquals(2L, postRepository.findAll().size());

        Post post4 = new Post();
        postRepository.save(post4);
        assertEquals(3L, postRepository.count());
        assertEquals(post4, postRepository.findById(4));
    }
}