package com.example.model;

import com.example.model.Video;
import com.example.model.VideoDAO;

import java.sql.SQLException;
import java.util.List;

public class VideoController {
    private VideoDAO videoDAO;

    public VideoController() {
        videoDAO = new VideoDAO();
    }

    public void addVideo(Video video) throws SQLException {
        videoDAO.addVideo(video);
    }

    public Video getVideo(int id) throws SQLException {
        return videoDAO.getVideo(id);
    }

    public List<Video> getAllVideos() throws SQLException {
        return videoDAO.getAllVideos();
    }

    public void updateVideo(Video video) throws SQLException {
        videoDAO.updateVideo(video);
    }

    public void deleteVideo(int id) throws SQLException {
        videoDAO.deleteVideo(id);
    }
}
