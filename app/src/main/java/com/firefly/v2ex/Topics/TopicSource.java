package com.firefly.v2ex.Topics;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class TopicSource {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<TopicItem> HOTS = new ArrayList<TopicItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<Long, TopicItem> HOTS_MAP = new HashMap<>();

//    private static TopicItem createTopicItem(int position) {
//        return new TopicItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}
