package com.firefly.v2ex.Topics;

/**
 * Created by jason on 8/24/17.
 */

public class Node {
    private final long id;
    private final String name;
    private final String title;
    private final String title_alternative;
    private final String url;
    private final int topics;
    private final String avatar_mini;
    private final String avatar_normal;
    private final String avatar_large;

    public Node(long id, String name, String title, String title_alternative, String url, int topics, String avatar_mini, String avatar_normal, String avatar_large) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.title_alternative = title_alternative;
        this.url = url;
        this.topics = topics;
        this.avatar_mini = avatar_mini;
        this.avatar_normal = avatar_normal;
        this.avatar_large = avatar_large;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle_alternative() {
        return title_alternative;
    }

    public String getUrl() {
        return url;
    }

    public int getTopics() {
        return topics;
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
