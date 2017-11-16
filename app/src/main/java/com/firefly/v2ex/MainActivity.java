package com.firefly.v2ex;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.firefly.v2ex.bean.GankBean;
import com.firefly.v2ex.net.IApi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_view)
    ListView listView;

    MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new MyAdapter();
        listView.setAdapter(adapter);


        IApi.getGankApi().getList().enqueue(new Callback<GankBean>() {
            @Override
            public void onResponse(Call<GankBean> call, Response<GankBean> response) {
                Log.d("TAG", response.body().toString());
                adapter.update(response.body().getResults());
            }

            @Override
            public void onFailure(Call<GankBean> call, Throwable t) {

            }
        });
    }

    public class MyAdapter extends BaseAdapter {

        private List<GankBean.ResultsBean> data = new ArrayList<>();

        @Override
        public int getCount() {
            return data.size();
        }

        public void update(List<GankBean.ResultsBean> data) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                convertView = layoutInflater.inflate(R.layout.item_view, null);

                viewHolder = new ViewHolder();
                viewHolder.imageView = (ImageView) convertView.findViewById(R.id.item_image);
                viewHolder.title = (TextView) convertView.findViewById(R.id.item_title);
                viewHolder.detail = (TextView) convertView.findViewById(R.id.item_detail);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }


            GankBean.ResultsBean bean = data.get(position);

            if (bean.getImages() != null && !bean.getImages().isEmpty()) {
                Picasso.with(parent.getContext()).load(bean.getImages().get(0)).into(viewHolder.imageView);
            }
            viewHolder.title.setText(bean.getWho());
            viewHolder.detail.setText(bean.getDesc());
            return convertView;
        }

        class ViewHolder {
            public ImageView imageView;
            public TextView title;
            public TextView detail;


        }
    }
}