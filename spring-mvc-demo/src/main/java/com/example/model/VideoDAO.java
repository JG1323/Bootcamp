package com.example.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {
	
    public void addVideo(Video video) throws SQLException {
        String query = "INSERT INTO Videos (title, director, cli_id) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, video.getTitle());
            pst.setString(2, video.getDirector());
            pst.setInt(3, video.getCliId());
            pst.executeUpdate();
        }
    }

    public Video getVideo(int id) throws SQLException {
        String query = "SELECT * FROM Videos WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Video video = new Video();
                    video.setId(rs.getInt("id"));
                    video.setTitle(rs.getString("title"));
                    video.setDirector(rs.getString("director"));
                    video.setId(rs.getInt("cli_id"));
                    return video;
                }
            }
        }
        return null;
    }

    public List<Video> getAllVideos() throws SQLException {
        List<Video> videos = new ArrayList<>();
        String query = "SELECT * FROM Videos";
        try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Video video = new Video();
                video.setId(rs.getInt("id"));
                video.setTitle(rs.getString("title"));
                video.setDirector(rs.getString("director"));
                video.setId(rs.getInt("cli_id"));
                videos.add(video);
            }
        }
        return videos;
    }

    public void updateVideo(Video video) throws SQLException {
        String query = "UPDATE Videos SET title = ?, director = ?, cli_id = ? WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, video.getTitle());
            pst.setString(2, video.getDirector());
            pst.setInt(3, video.getCliId());
            pst.setInt(4, video.getId());
            pst.executeUpdate();
        }
    }

    public void deleteVideo(int id) throws SQLException {
        String query = "DELETE FROM Videos WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        }
    }
}