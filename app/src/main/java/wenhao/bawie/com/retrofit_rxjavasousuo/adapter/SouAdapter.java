package wenhao.bawie.com.retrofit_rxjavasousuo.adapter;

import android.app.job.JobInfo;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import wenhao.bawie.com.retrofit_rxjavasousuo.R;
import wenhao.bawie.com.retrofit_rxjavasousuo.bean.SouBean;

/**
 * Created by HP on 2018/11/8.
 */

public class SouAdapter extends RecyclerView.Adapter<SouAdapter.SouViewHolder>{

    private Context context;
    private List<SouBean.DataBean> list;

    public SouAdapter(Context context, List<SouBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public SouAdapter.SouViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.sou_adapter_layout, parent, false);
        SouViewHolder souViewHolder = new SouViewHolder(inflate);
        return souViewHolder;
    }

    @Override
    public void onBindViewHolder(SouAdapter.SouViewHolder holder, int position) {
        holder.text_title.setText(list.get(position).getTitle());
        holder.text_price.setText("价格:"+list.get(position).getPrice());
        String[] split = list.get(position).getImages().split("\\|");
        Glide.with(context).load(split[0]).into(holder.image_sou);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SouViewHolder extends RecyclerView.ViewHolder {

        private ImageView image_sou;
        private TextView text_title;
        private TextView text_price;

        public SouViewHolder(View itemView) {
            super(itemView);
            text_price = (TextView) itemView.findViewById(R.id.text_price);
            text_title = (TextView) itemView.findViewById(R.id.text_title);
            image_sou = (ImageView) itemView.findViewById(R.id.image_sou);
        }
    }
}
