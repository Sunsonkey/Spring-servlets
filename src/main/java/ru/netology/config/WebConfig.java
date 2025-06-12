package ru.netology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.netology.repository.PostRepository;
import ru.netology.repository.PostRepositoryStubImpl;
import ru.netology.service.PostService;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ru.netology.config")
public class WebConfig {
  @Bean
  public PostRepository postRepository() {
    return new PostRepositoryStubImpl();
  }

  @Bean
  public PostService postService(PostRepository repository) {
    return new PostService(repository);
  }
}