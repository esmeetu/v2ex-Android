package com.firefly.v2ex.Topics;

/**
 * Created by jason on 8/24/17.
 */
/**
 * A topic item representing a piece of content.
 */
public class TopicItem {
    public final long id;
    public final String title;
    public final String url;
    public final String content;
    public final String content_rendered;
    public final int relplies;
    public final Member member;
    public final Node node;
    public final long created;
    public final long last_modified;
    public final long last_touched;

    public TopicItem(long id, String title, String url, String content, String content_rendered,
                     int relplies, Member member, Node node, long created, long last_modified, long last_touched) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.content = content;
        this.content_rendered = content_rendered;
        this.relplies = relplies;
        this.member = member;
        this.node = node;
        this.created = created;
        this.last_modified = last_modified;
        this.last_touched = last_touched;
    }

    @Override
    public String toString() {
        return content;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public String getContent_rendered() {
        return content_rendered;
    }

    public int getRelplies() {
        return relplies;
    }

    public Member getMember() {
        return member;
    }

    public Node getNode() {
        return node;
    }

    public long getCreated() {
        return created;
    }

    public long getLast_modified() {
        return last_modified;
    }

    public long getLast_touched() {
        return last_touched;
    }
}