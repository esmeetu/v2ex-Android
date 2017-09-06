package com.firefly.v2ex;

import android.content.Context;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.firefly.v2ex.Topics.HotTopic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jason on 8/28/17.
 */

public class TopicAdapter extends ArrayAdapter<HotTopic> {
    private int resourceId;

    public TopicAdapter(Context context, int textViewResourceId, List<HotTopic> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HotTopic topic = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.topic_title = (TextView) view.findViewById(R.id.topic_title);
            viewHolder.topic_created = (TextView) view.findViewById(R.id.topic_created);
            view.setTag(viewHolder); // save viewHolder in view;
        } else {
            // cache
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // reacquire ViewHolder.
        }
        viewHolder.topic_title.setText(topic.getTitle());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时");
        String created = sdf.format(new Date(topic.getCreated() * 1000L));
        viewHolder.topic_created.setText(created);

        return view;
    }

    class ViewHolder {

        TextView topic_title;

        TextView topic_created;

    }
}
