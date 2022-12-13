package services;

import data.models.Post;
import data.repositories.PostRepository;
import data.repositories.PostRepositoryImpl;
import dto.requests.CreatePostRequest;

import java.util.List;

public class PostServiceImpl implements PostService{
    private PostRepository postRepository = new PostRepositoryImpl();
    @Override
    public void createPost(CreatePostRequest creatPostRequest) {
        Post post = new Post();
        post.setTitle(creatPostRequest.getTitle());
        post.setBody(creatPostRequest.getBody());
        postRepository.save(post);
    }

    @Override
    public void updatePost(int id, String title, String body) {

    }

    @Override
    public void deletePost(int id) {

    }

    @Override
    public Post viewPost(int id) {
        return null;
    }

    @Override
    public List<Post> viewAllPost() {
        return postRepository.findAll();
    }
}
