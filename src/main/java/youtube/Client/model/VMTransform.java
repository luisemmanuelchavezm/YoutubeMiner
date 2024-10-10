package youtube.Client.model;


import youtube.Client.model.VM.*;
import youtube.Client.model.caption.Caption;
import youtube.Client.model.channel.Channel;
import youtube.Client.model.comment.Comment;
import youtube.Client.model.videoSnippet.VideoSnippet;

import java.util.ArrayList;
import java.util.List;

public class VMTransform {

    public static List<VMCaption> ofCaption(List<Caption> Lcaption) {
        if (Lcaption == null) return null;
        List<VMCaption> captions = new ArrayList<>();
        for (Caption caption : Lcaption) {
        VMCaption cap = new VMCaption(caption.getId(), caption.getSnippet().getName(), caption.getSnippet().getLanguage());
        captions.add(cap);
    }
        return captions;
    }
    public static VMUser ofUser(Comment Luser){
        if (Luser == null) return null;

        VMUser user = new VMUser(null, Luser.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorDisplayName()
                , Luser.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorChannelUrl(),
                    Luser.getCommentSnippet().getTopLevelComment().getSnippet().getAuthorProfileImageUrl());



        return user;
    }
    public static List<VMComment> ofComment(List<Comment> Lcomment){
        if (Lcomment == null) return null;
        List<VMComment> comments = new ArrayList<>();
         for (Comment comment: Lcomment ) {
             VMComment com = new VMComment(comment.getCommentSnippet().getTopLevelComment().getId(), comment.getCommentSnippet().getTopLevelComment().getSnippet().getTextOriginal(),
                     comment.getCommentSnippet().getTopLevelComment().getSnippet().getPublishedAt(), ofUser(comment));
             comments.add(com);
         }
         return comments;
         }
    public static List<VMVideo> ofVideo(List<VideoSnippet> Lvideo){
        if (Lvideo == null) return null;
        List<VMVideo> videos = new ArrayList<>();
        for (VideoSnippet video: Lvideo) {
            VMVideo vid = new VMVideo(ofCaption(video.getCaptions()), ofComment(video.getComments()),
                    video.getSnippet().getPublishedAt(), video.getSnippet().getDescription(), video.getSnippet().getTitle(), video.getId().getVideoId());
            videos.add(vid);
        }
        return videos;
        }
    public static VMChannel ofChannel(Channel channel){
        return new VMChannel(channel.getId(), channel.getSnippet().getTitle(), channel.getSnippet().getDescription(),
                channel.getSnippet().getPublishedAt(),ofVideo(channel.getVideos()));
    }

}
