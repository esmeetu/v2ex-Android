package com.firefly.v2ex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firefly.v2ex.Topics.HotTopic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by jason on 8/28/17.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {

    private List<HotTopic> mTopicList;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时");


    static class ViewHolder extends RecyclerView.ViewHolder {
        View topicView;
        TextView topicTitle;
        TextView topicCreated;


        public ViewHolder(View view) {
            super(view);
            topicView = view;
            topicTitle = (TextView) view.findViewById(R.id.topic_title);
            topicCreated = (TextView) view.findViewById(R.id.topic_created);
        }
    }

    public HotAdapter(List<HotTopic> mTopicList) {
        this.mTopicList = mTopicList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.topic_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.topicView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int positon = holder.getAdapterPosition();
                HotTopic topic = mTopicList.get(positon);
                Toast.makeText(view.getContext(), topic.getContent(), Toast.LENGTH_LONG).show();
            }
        });
        holder.topicCreated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int positon = holder.getAdapterPosition();
                HotTopic topic = mTopicList.get(positon);
                Toast.makeText(view.getContext(), "Last modified: " + sdf.format(new Date(topic.getLast_modified() * 1000L)) +
                        "\nLast touched: " + sdf.format(new Date(topic.getLast_touched() * 1000L)), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HotTopic topic = mTopicList.get(position);
        holder.topicTitle.setText(topic.getTitle());
        String created = sdf.format(new Date(topic.getCreated() * 1000L));
        holder.topicCreated.setText(created);
    }

    @Override
    public int getItemCount() {
        return mTopicList.size();
    }

}
