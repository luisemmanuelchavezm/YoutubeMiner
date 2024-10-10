package youtube.Client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import youtube.Client.model.comment.Comment;
import youtube.Client.model.comment.CommentSearch;
import youtube.Client.model.videoSnippet.VideoSnippet;
import youtube.Client.model.videoSnippet.VideoSnippetSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    RestTemplate restTemplate;
    private final String Token= "AIzaSyDnJD1K6bRBblPvf1Z9hrJvIqFzH5-wPuo";

    public List<Comment> findAllComments(String id, String maxResults){
        try {
            String uri = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&videoId=" + id + "&key=" + Token + "&maxResults=" + maxResults;
            ResponseEntity<CommentSearch> comment = restTemplate.getForEntity(uri, CommentSearch.class);
            List<Comment> comments = comment.getBody().getItems();
            return comment.getBody().getItems();
        }
        catch (HttpStatusCodeException e){
            return new ArrayList<Comment>();


        }


    }
}
