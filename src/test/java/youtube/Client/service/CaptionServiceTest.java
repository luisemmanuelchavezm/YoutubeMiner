package youtube.Client.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import youtube.Client.model.caption.Caption;

import java.util.List;

@SpringBootTest
class CaptionServiceTest {
    @Autowired
    CaptionService service;
    @Test
    @DisplayName("Find all captions given its id")
    void findAllCaptions() {
        List<Caption> captions = service.findAllCaptions("Pv0iVoSZzN8");
        System.out.println(captions);
    }
}