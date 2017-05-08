package com.berchina.zx.zxexpress;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zx on 2017/5/8 13:36
 * 项目名称：ZXExpress
 * 类描述：
 * 备注
 */
public class MyAdapter extends ZxAdapter<Bean.DataBean> {

    public MyAdapter(Activity context, List<Bean.DataBean> datas) {
        super(context, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (position == 0) {
            holder.llLeft1.setVisibility(View.VISIBLE);
            holder.tvContent.setTextColor(context.getResources().getColor(R.color.red));
            holder.llLeft2.setVisibility(View.GONE);
            holder.ivLastLine1.setVisibility(View.VISIBLE);
        } else {
            holder.llLeft1.setVisibility(View.GONE);
            holder.tvContent.setTextColor(context.getResources().getColor(R.color.black));
            holder.llLeft2.setVisibility(View.VISIBLE);
        }
        if (position == getCount() - 1) {
            holder.ivLastLine.setVisibility(View.INVISIBLE);
            holder.ivLastLine1.setVisibility(View.INVISIBLE);
        }

        Bean.DataBean bean = datas.get(position);
        holder.tvContent.setText(SpannableStringUtil.zhuanHuanTelUrl(context, bean.context));
        holder.tvContent.setHighlightColor(Color.TRANSPARENT); //设置点击后的颜色为透明，否则会一直出现高亮
        holder.tvContent.setMovementMethod(LinkMovementMethod.getInstance());//开始响应点击事件
        holder.tvDate.setText(bean.time);

        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.ll_left1)
        LinearLayout llLeft1;
        @BindView(R.id.iv_last_line)
        ImageView ivLastLine;
        @BindView(R.id.ll_left2)
        LinearLayout llLeft2;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.iv_last_line1)
        ImageView ivLastLine1;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
