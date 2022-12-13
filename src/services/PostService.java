package services;

import data.models.Post;
import dto.requests.CreatePostRequest;

import java.util.Collection;
import java.util.List;

public interface PostService {

    void createPost(CreatePostRequest creatPostRequest);
    void updatePost(int id, String title, String body);
    void deletePost(int id);
    Post viewPost(int id);

    List<Post> viewAllPost();
}
