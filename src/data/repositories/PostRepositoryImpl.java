package data.repositories;


import data.models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepositoryImpl implements PostRepository{
private int count;
    private  List<Post> postDb = new ArrayList<>();
    @Override
    public Post save(Post post) {
        if (post.getId() != 0)update(post);
        else{

        post.setId(generateId());
        postDb.add(post);
        }

        return post;
    }
    private int generateId(){
        return ++count;
    }

    private void update(Post post) {
        Post savedPost = findById(post.getId());
        savedPost.setBody(post.getBody());
        savedPost.setTitle(post.getTitle());
    }

    @Override
    public Post findById(int id) {
        for (var post: postDb) if (post.getId() == id) return post;
        return null;
    }

    @Override
    public List<Post> findAll() {
        return postDb;
    }

    @Override
    public long count() {
        return postDb.size();
    }

    @Override
    public void delete(Post post) {
    postDb.remove(post);
    }

    @Override
    public void delete(int id) {
     postDb.removeIf(post -> post.getId() == id);
    }
}
