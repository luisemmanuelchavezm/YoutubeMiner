package youtube.Client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import youtube.Client.model.VM.VMChannel;
import youtube.Client.model.channel.Channel;
import youtube.Client.model.channel.ChannelSearch;
import youtube.Client.model.channel.ChannelSnippet;
import youtube.Client.model.videoSnippet.VideoSnippet;
import youtube.Client.model.videoSnippet.VideoSnippetSearch;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    VideoService videoService;
    private final String Token= "AIzaSyDnJD1K6bRBblPvf1Z9hrJvIqFzH5-wPuo";

    public Channel findChannel(String id, String maxVideos, String maxComments ){
        String uri ="https://www.googleapis.com/youtube/v3/channels?key="+Token+ "&part=snippet&id="+id;
        ResponseEntity<ChannelSearch> channel= restTemplate.getForEntity(uri, ChannelSearch.class);
        channel.getBody().getItems().get(0).setVideos(videoService.findAllVideos(id, maxVideos, maxComments));
        return channel.getBody().getItems().get(0);
    }
    public VMChannel createChannel(VMChannel channelVm) {
        String uriVm = "http://localhost:8080/videominer/channels";
        ResponseEntity<VMChannel> vmChannel = restTemplate.postForEntity(uriVm, channelVm, VMChannel.class);
        return vmChannel.getBody();
    }

}
