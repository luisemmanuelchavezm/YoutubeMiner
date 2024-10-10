package youtube.Client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import youtube.Client.model.caption.Caption;
import youtube.Client.model.comment.Comment;
import youtube.Client.model.videoSnippet.VideoSnippet;
import youtube.Client.model.videoSnippet.VideoSnippetSearch;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CommentService commentService;
    @Autowired
    CaptionService captionService;
    private final String Token = "AIzaSyDnJD1K6bRBblPvf1Z9hrJvIqFzH5-wPuo";


    public List<VideoSnippet> findAllVideos(String id, String maxResults, String maxComments){
        String uri = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&channelId=" + id +
                "&key=" + Token + "&maxResults=" + maxResults;
        ResponseEntity<VideoSnippetSearch> videos = restTemplate.getForEntity(uri, VideoSnippetSearch.class);
        for(VideoSnippet video: videos.getBody().getItems()){
            video.setComments(commentService.findAllComments(video.getId().getVideoId(),maxComments));
            video.setCaptions(captionService.findAllCaptions(video.getId().getVideoId()));
        }
        return videos.getBody().getItems();
    }
    public List<VideoSnippet> findAllVideos(String id, String maxResults, String maxComments, String offset){
        String uri ="https://www.googleapis.com/youtube/v3/search?part=snippet&channelId="+id+"&key="+ Token+"&maxResults="+ maxResults+ "&offset="+offset;
        ResponseEntity<VideoSnippetSearch> videos= restTemplate.getForEntity(uri, VideoSnippetSearch.class);
        for(VideoSnippet video: videos.getBody().getItems()){
            if (video.getId().getVideoId()== null) {
                video.setComments(new ArrayList<Comment>());
                video.setCaptions(new ArrayList<Caption>());
            }
            else{video.setComments(commentService.findAllComments(video.getId().getVideoId(),maxComments));
                video.setCaptions(captionService.findAllCaptions(video.getId().getVideoId()));
            }
        }
        return videos.getBody().getItems();
    }
}
