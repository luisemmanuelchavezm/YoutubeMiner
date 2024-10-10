package youtube.Client.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import youtube.Client.model.VMTransform;
import youtube.Client.model.comment.Comment;

import java.util.List;

@SpringBootTest
class CommentServiceTest {
    @Autowired
    CommentService service;
    @Test
    @DisplayName("Find all comments given its id")
    void findComment() {
        List<Comment> comment = service.findAllComments("9lIoHJKw6IA", "5");
        System.out.println(VMTransform.ofComment(comment));
    }
}