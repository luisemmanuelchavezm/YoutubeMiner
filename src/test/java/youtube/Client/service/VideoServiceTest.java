package youtube.Client.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import youtube.Client.model.videoSnippet.VideoSnippet;

import java.util.List;

@SpringBootTest
class VideoServiceTest {

    @Autowired
    VideoService service;

    @Test
    @DisplayName("Get all videos given a channelId")
    void findAllVideo(){
        List<VideoSnippet> video = service.findAllVideos("UCtakZatUqY-XaihWfMnz07w", "4","10");
        System.out.println(video);
    }
}