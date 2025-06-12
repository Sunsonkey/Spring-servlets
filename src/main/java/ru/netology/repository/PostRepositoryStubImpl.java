package ru.netology.repository;

import ru.netology.model.Post;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class PostRepositoryStubImpl implements PostRepository {
  private final List<Post> posts = new CopyOnWriteArrayList<>();
  private final AtomicLong counter = new AtomicLong(0);

  @Override
  public List<Post> all() {
    return posts;
  }

  @Override
  public Optional<Post> getById(long id) {
    return posts.stream()
            .filter(p -> p.getId() == id)
            .findFirst();
  }

  @Override
  public Post save(Post post) {
    if (post.getId() == 0) {
      post.setId(counter.incrementAndGet());
      posts.add(post);
      return post;
    } else {
      posts.replaceAll(p -> p.getId() == post.getId() ? post : p);
      return post;
    }
  }

  @Override
  public void removeById(long id) {
    posts.removeIf(p -> p.getId() == id);
  }
}