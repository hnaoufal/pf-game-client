package com.pr.gameclient.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RankingMapper {
    private UserMapper user;
    private String id;
    private int points;

    public RankingMapper() {
    }

    public RankingMapper(UserMapper user, String id, int points) {
        this.user = user;
        this.id = id;
        this.points = points;
    }

    @JsonProperty("user")
    public UserMapper getUser() {
        return user;
    }

    public void setUser(UserMapper user) {
        this.user = user;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("points")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

