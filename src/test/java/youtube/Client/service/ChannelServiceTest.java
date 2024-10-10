package youtube.Client.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import youtube.Client.model.VM.VMChannel;
import youtube.Client.model.VMTransform;
import youtube.Client.model.channel.Channel;

@SpringBootTest
class ChannelServiceTest {

    @Autowired
    ChannelService service;
    @Test
    @DisplayName("Get a channel given a videoId") //
    void findChannel() {
        Channel channel = service.findChannel("UCtakZatUqY-XaihWfMnz07w", "5", "5");
        System.out.println(channel.getVideos());
    }

    @Test
    @DisplayName("Create a channel given its Id")
    void createChannel() {
        Channel channel = service.findChannel("UCtakZatUqY-XaihWfMnz07w","2","2");
        VMChannel channelVm = VMTransform.ofChannel(channel);
        VMChannel channelVmCreated = service.createChannel(channelVm);
        System.out.println(channelVmCreated);
    }
}