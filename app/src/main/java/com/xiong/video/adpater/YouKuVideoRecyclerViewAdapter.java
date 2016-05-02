package com.xiong.video.adpater;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.xiong.video.Constant;
import com.xiong.video.FrescoX;
import com.xiong.video.R;
import com.xiong.video.bean.YouKuVideoInfo;
import com.xiong.video.util.ScreenUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * YouKuVideoRecyclerViewAdapter
 * Created by 杨超 on 2016/5/2.
 */
public class YouKuVideoRecyclerViewAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<YouKuVideoInfo> list;
    private LayoutInflater inflater;

    public YouKuVideoRecyclerViewAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public List<YouKuVideoInfo> getList() {
        return list;
    }

    public void setList(List<YouKuVideoInfo> list) {
        this.list = list;
    }

    @Override

    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_youku_video, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        YouKuVideoInfo videoInfo = list.get(position);
        itemViewHolder.sdvPreview.setImageURI(Uri.parse(videoInfo.getBigThumbnail()));
        itemViewHolder.sdvPreview.getLayoutParams().width = ScreenUtils.getScreenWidth(context) / 2;
        itemViewHolder.sdvPreview.getLayoutParams().height
                = (int) (ScreenUtils.getScreenWidth(context) / Constant.YOUKU_IMAGE_PROFORTION) / 2;
        itemViewHolder.tvTitle.setText(videoInfo.getTitle());
        itemViewHolder.tvWatchCount.setText(String.valueOf(videoInfo.getView_count()));
        itemViewHolder.tvCommentCount.setText(String.valueOf(videoInfo.getComment_count()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.sdv_preview)
        SimpleDraweeView sdvPreview;
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.tv_watch_count)
        TextView tvWatchCount;
        @Bind(R.id.tv_comment_count)
        TextView tvCommentCount;

        ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            FrescoX.duang(context, sdvPreview);
        }
    }
}
