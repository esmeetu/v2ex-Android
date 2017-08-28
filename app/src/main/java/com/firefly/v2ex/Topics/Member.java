package com.firefly.v2ex.Topics;

/**
 * Created by jason on 8/24/17.
 */

public class Member {
    private final long id;
    private final String username;
    private final String tagline;
    private final String avatar_mini;
    private final String avatar_normal;
    private final String avatar_large;

    public Member(long id, String username, String tagline, String avatar_mini, String avatar_normal, String avatar_large) {
        this.id = id;
        this.username = username;
        this.tagline = tagline;
        this.avatar_mini = avatar_mini;
        this.avatar_normal = avatar_normal;
        this.avatar_large = avatar_large;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTagline() {
        return tagline;
    }

    public String getAvatar_mini() {
        return avatar_mini;
    }

    public String getAvatar_normal() {
        return avatar_normal;
    }

    public String getAvatar_large() {
        return avatar_large;
    }
}
