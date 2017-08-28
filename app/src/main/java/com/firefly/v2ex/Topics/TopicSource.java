package com.firefly.v2ex.Topics;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

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

    public static final String V2EX_HOTS_URL = "https://www.v2ex.com/Api/topics/hot.json";

    public static void getHots() {
        Api api = new Api();
        String hotsJsonResponse = null;
        List<TopicItem> hots = null;
        try {
            hotsJsonResponse = api.run(V2EX_HOTS_URL);
            Moshi moshi = new Moshi.Builder().build();
            Type type = Types.newParameterizedType(List.class, TopicItem.class);
            JsonAdapter<List<TopicItem>> adapter = moshi.adapter(type);
            hots = adapter.fromJson(hotsJsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!hots.isEmpty()) {
            HOTS.addAll(hots);
            for (TopicItem topic : hots) {
                HOTS_MAP.put(topic.id, topic);
            }
        }
    }
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
