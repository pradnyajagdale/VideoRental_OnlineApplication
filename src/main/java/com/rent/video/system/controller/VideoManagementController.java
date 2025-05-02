package com.rent.video.system.controller;


import com.rent.video.system.dto.Video;
import com.rent.video.system.exchnage.*;
import com.rent.video.system.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apivideo")
public class VideoManagementController {

    @Autowired
    VideoService videoService;

    @GetMapping("/video/ping")
    public String ping()
    {
        return "pong";
    }

    @GetMapping("/video/list")
    public ResponseEntity<List<Video>> getVideoList(@RequestBody GetUserLoginRequest getUserLoginRequest)
    {
        List<Video> videoList = videoService.getAllVideoList(getUserLoginRequest);
        return ResponseEntity.ok().body(videoList);
    }

    @PostMapping("/video/add")
    public ResponseEntity<GetVideoResponse> addVideoEntry(@RequestBody GetVideoRequest getVideoRequest)
    {
        GetVideoResponse getVideoResponse = videoService.addVideoIntoAppln(getVideoRequest);
        return ResponseEntity.ok().body(getVideoResponse);
    }

    @PutMapping("/video/update")
    public ResponseEntity<Integer> modifyVideoEntry(@RequestBody VideoUpdateRequest updateRequest)
    {    int isUpdate =  videoService.updateVideoAppln(updateRequest);
        return ResponseEntity.ok().body(isUpdate);
    }
    @DeleteMapping("/video/delete/{title}")
    public ResponseEntity<Integer> deleteVideoEntry(@PathVariable String vtitle)
    {
        int isDelete = videoService.deleteVideoAppln(vtitle);
        return ResponseEntity.ok().body(isDelete);
    }
}
