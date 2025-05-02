package com.rent.video.system.services;

import com.rent.video.system.dto.Video;
import com.rent.video.system.exchnage.*;
import com.rent.video.system.model.VideoEntity;
import com.rent.video.system.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoServiceImpl  implements VideoService {
    @Autowired
    VideoRepository videoRepository;

    @Autowired
    UserService userService;

    public List<Video> getAllVideoList(GetUserLoginRequest getUserLoginRequest)
    {
        GetUserLoginResponse loginResponse = userService.loginUserToApplication(getUserLoginRequest);
        List<Video> videoList = new ArrayList<>();
        if(loginResponse.getMessage().equals("login_success")) {
            List<VideoEntity> vEntityList = videoRepository.findAll();
            for (VideoEntity videoEn : vEntityList) {
                videoList.add(getVideoObj(videoEn));
            }
        }

        return videoList;
    }
    public Video getVideoObj(VideoEntity vEntity)
    {
        return new Video(vEntity.getVideoid(), vEntity.getTitle(),vEntity.getDirector(),vEntity.getAvlstatus());
    }

    public GetVideoResponse addVideoIntoAppln(GetVideoRequest urequest) {
        VideoEntity addedVentity = videoRepository.save( new VideoEntity(urequest.getTitle(),urequest.getDirector(),urequest.getAvlstatus()));
        GetVideoResponse getVideoResponse = new GetVideoResponse(getVideoObj(addedVentity));
        return getVideoResponse;
    }
       public int updateVideoAppln(VideoUpdateRequest updateRequest)
    {
        int isUpdated = videoRepository.updateVideo(updateRequest.getTitle(),updateRequest.getDirector());
        return isUpdated;
    }

    public int deleteVideoAppln(String vtitle)
    {
        int isDeleted = videoRepository.deleteVideo(vtitle);
        return isDeleted;
    }
}
