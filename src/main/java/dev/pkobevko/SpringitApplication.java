package dev.pkobevko;

import dev.pkobevko.domain.Comment;
import dev.pkobevko.domain.Link;
import dev.pkobevko.repository.CommentRepository;
import dev.pkobevko.repository.LinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository) {
        return args -> {
            Link link = new Link("Google", "https://google.com");
            linkRepository.save(link);
            Comment comment = new Comment("Wow! This is Google!", link);
            commentRepository.save(comment);
            link.addComment(comment);
            System.out.println(link.getComments());
        };
    }
}
