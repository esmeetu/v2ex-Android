package com.firefly.v2ex.Topics;

import java.util.Date;

/**
 * Created by wangyapeng on 2017/8/28.
 */

public class HotTopic {

    /**
     * id : 386172
     * title : 求指教！ iOS 小萌新纠结腾讯工作 or 出国读 master
     * url : http://www.v2ex.com/t/386172
     * content : 楼主开学大三党，武汉读书。
     大一下在百度打杂，大二下拿了腾讯，阿里的实习 offer，选择了美丽的深圳实习。

     考核结果是 S 级，拿到腾讯的 special offer 了，HR 给了一个很满意的薪资。
     因为楼主读的是 3+2 的软件国际班，所以本来可以 3 年拿到本科学位。

     楼主很喜欢写代码，对 iOS ／ AR、VR 有过一点点的研究。在 TX 有一个 VR 全景直播相关专利

     现在很纠结，因为楼主不出国要 19 年才能拿到双证入职，所以不能在 18 年结束本科后直接工作。
     并且加权现在是 93.5，所以想出国读一个图像相关的 master。（因为会觉得 iOS ／ Unity 相关的客户端工程师发展的空间有限 =。=）

     但是很纠结，到底要不要放弃 offer。
     因为分手时出柜了所以和家里面有点矛盾，emmmm 所以现在经济是独立的，靠外包和实习养活自己。如果出国的话，想自己申请 Award。。。不然就让像父母求和，接受各种批评和治疗 =。=

     所以各位大神们有什么建议么 =。= 楼主女生。。。。
     * content_rendered : <p>楼主开学大三党，武汉读书。
     大一下在百度打杂，大二下拿了腾讯，阿里的实习 offer，选择了美丽的深圳实习。</p>
     <p>考核结果是 S 级，拿到腾讯的 special offer 了，HR 给了一个很满意的薪资。
     因为楼主读的是 3+2 的软件国际班，所以本来可以 3 年拿到本科学位。</p>
     <p>楼主很喜欢写代码，对 iOS ／ AR、VR 有过一点点的研究。在 TX 有一个 VR 全景直播相关专利</p>
     <p>现在很纠结，因为楼主不出国要 19 年才能拿到双证入职，所以不能在 18 年结束本科后直接工作。
     并且加权现在是 93.5，所以想出国读一个图像相关的 master。（因为会觉得 iOS ／ Unity 相关的客户端工程师发展的空间有限 =。=）</p>
     <p>但是很纠结，到底要不要放弃 offer。
     因为分手时出柜了所以和家里面有点矛盾，emmmm 所以现在经济是独立的，靠外包和实习养活自己。如果出国的话，想自己申请 Award。。。不然就让像父母求和，接受各种批评和治疗 =。=</p>
     <p>所以各位大神们有什么建议么 =。= 楼主女生。。。。</p>

     * replies : 128
     * member : {"id":240807,"username":"luluwang","tagline":"","avatar_mini":"//v2ex.assets.uxengine.net/gravatar/53d3223feb5191dda5404a1cec25b884?s=24&d=retro","avatar_normal":"//v2ex.assets.uxengine.net/gravatar/53d3223feb5191dda5404a1cec25b884?s=48&d=retro","avatar_large":"//v2ex.assets.uxengine.net/gravatar/53d3223feb5191dda5404a1cec25b884?s=73&d=retro"}
     * node : {"id":300,"name":"programmer","title":"程序员","title_alternative":"Programmer","url":"http://www.v2ex.com/go/programmer","topics":16902,"avatar_mini":"//v2ex.assets.uxengine.net/navatar/94f6/d7e0/300_mini.png?m=1503472334","avatar_normal":"//v2ex.assets.uxengine.net/navatar/94f6/d7e0/300_normal.png?m=1503472334","avatar_large":"//v2ex.assets.uxengine.net/navatar/94f6/d7e0/300_large.png?m=1503472334"}
     * created : 1503832644
     * last_modified : 1503832644
     * last_touched : 1503899620
     */

    private long id;
    private String title;
    private String url;
    private String content;
    private String content_rendered;
    private int replies;
    private MemberBean member;
    private NodeBean node;
    private long created;
    private long last_modified;
    private long last_touched;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent_rendered() {
        return content_rendered;
    }

    public void setContent_rendered(String content_rendered) {
        this.content_rendered = content_rendered;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public MemberBean getMember() {
        return member;
    }

    public void setMember(MemberBean member) {
        this.member = member;
    }

    public NodeBean getNode() {
        return node;
    }

    public void setNode(NodeBean node) {
        this.node = node;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public long getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(int last_modified) {
        this.last_modified = last_modified;
    }

    public long getLast_touched() {
        return last_touched;
    }

    public void setLast_touched(int last_touched) {
        this.last_touched = last_touched;
    }

    public static class MemberBean {
        /**
         * id : 240807
         * username : luluwang
         * tagline :
         * avatar_mini : //v2ex.assets.uxengine.net/gravatar/53d3223feb5191dda5404a1cec25b884?s=24&d=retro
         * avatar_normal : //v2ex.assets.uxengine.net/gravatar/53d3223feb5191dda5404a1cec25b884?s=48&d=retro
         * avatar_large : //v2ex.assets.uxengine.net/gravatar/53d3223feb5191dda5404a1cec25b884?s=73&d=retro
         */

        private int id;
        private String username;
        private String tagline;
        private String avatar_mini;
        private String avatar_normal;
        private String avatar_large;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTagline() {
            return tagline;
        }

        public void setTagline(String tagline) {
            this.tagline = tagline;
        }

        public String getAvatar_mini() {
            return avatar_mini;
        }

        public void setAvatar_mini(String avatar_mini) {
            this.avatar_mini = avatar_mini;
        }

        public String getAvatar_normal() {
            return avatar_normal;
        }

        public void setAvatar_normal(String avatar_normal) {
            this.avatar_normal = avatar_normal;
        }

        public String getAvatar_large() {
            return avatar_large;
        }

        public void setAvatar_large(String avatar_large) {
            this.avatar_large = avatar_large;
        }
    }

    public static class NodeBean {
        /**
         * id : 300
         * name : programmer
         * title : 程序员
         * title_alternative : Programmer
         * url : http://www.v2ex.com/go/programmer
         * topics : 16902
         * avatar_mini : //v2ex.assets.uxengine.net/navatar/94f6/d7e0/300_mini.png?m=1503472334
         * avatar_normal : //v2ex.assets.uxengine.net/navatar/94f6/d7e0/300_normal.png?m=1503472334
         * avatar_large : //v2ex.assets.uxengine.net/navatar/94f6/d7e0/300_large.png?m=1503472334
         */

        private int id;
        private String name;
        private String title;
        private String title_alternative;
        private String url;
        private int topics;
        private String avatar_mini;
        private String avatar_normal;
        private String avatar_large;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle_alternative() {
            return title_alternative;
        }

        public void setTitle_alternative(String title_alternative) {
            this.title_alternative = title_alternative;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getTopics() {
            return topics;
        }

        public void setTopics(int topics) {
            this.topics = topics;
        }

        public String getAvatar_mini() {
            return avatar_mini;
        }

        public void setAvatar_mini(String avatar_mini) {
            this.avatar_mini = avatar_mini;
        }

        public String getAvatar_normal() {
            return avatar_normal;
        }

        public void setAvatar_normal(String avatar_normal) {
            this.avatar_normal = avatar_normal;
        }

        public String getAvatar_large() {
            return avatar_large;
        }

        public void setAvatar_large(String avatar_large) {
            this.avatar_large = avatar_large;
        }
    }
}
