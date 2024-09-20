package com.example.stageproject.payload.response;

import java.util.List;

public class UserInfoResponse {
    private String _id;
    private String username;
    private String role;

    public UserInfoResponse(String _id, String username, String role) {
        this._id = _id;
        this.username = username;
        this.role = role;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
