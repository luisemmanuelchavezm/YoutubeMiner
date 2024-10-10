package youtube.Client.service;

import org.aspectj.weaver.patterns.IToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import youtube.Client.model.caption.Caption;
import youtube.Client.model.caption.CaptionSearch;
import youtube.Client.model.comment.Comment;
import youtube.Client.model.comment.CommentSearch;
import youtube.Client.model.videoSnippet.VideoSnippet;
import youtube.Client.model.videoSnippet.VideoSnippetSearch;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;
    private final String Token= "AIzaSyDnJD1K6bRBblPvf1Z9hrJvIqFzH5-wPuo";

    public List<Caption> findAllCaptions(String id){

            String uri = "https://www.googleapis.com/youtube/v3/captions?part=snippet&videoId=" + id + "&key=" + Token;
            ResponseEntity<CaptionSearch> comment = restTemplate.getForEntity(uri, CaptionSearch.class);
            return comment.getBody().getItems();

    }
}