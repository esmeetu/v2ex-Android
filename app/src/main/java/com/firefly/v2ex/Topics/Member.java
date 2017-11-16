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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != member.id) return false;
        if (username != null ? !username.equals(member.username) : member.username != null)
            return false;
        if (tagline != null ? !tagline.equals(member.tagline) : member.tagline != null)
            return false;
        if (avatar_mini != null ? !avatar_mini.equals(member.avatar_mini) : member.avatar_mini != null)
            return false;
        if (avatar_normal != null ? !avatar_normal.equals(member.avatar_normal) : member.avatar_normal != null)
            return false;
        return avatar_large != null ? avatar_large.equals(member.avatar_large) : member.avatar_large == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (tagline != null ? tagline.hashCode() : 0);
        result = 31 * result + (avatar_mini != null ? avatar_mini.hashCode() : 0);
        result = 31 * result + (avatar_normal != null ? avatar_normal.hashCode() : 0);
        result = 31 * result + (avatar_large != null ? avatar_large.hashCode() : 0);
        return result;
    }
}
