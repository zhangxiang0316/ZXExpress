package com.berchina.zx.zxexpress;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by zx on 2017/3/13 16:50
 * 项目名称：ZxLib
 * 类描述：基类Adapter
 * 备注
 */
public abstract class ZxAdapter<T> extends BaseAdapter {

    protected List<T> datas;
    protected Activity context;
    protected LayoutInflater inflater;

    public ZxAdapter(Activity context, List<T> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (datas == null || datas.size() == 0) {
            return 0;
        }
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.isEmpty() ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setData(List<T> datas) {
        this.datas = datas;
    }

    /**
     * 做分页的时候，addData(分页加载的数据)即可
     */
    public void addData(List<T> list) {
        datas.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 添加一个Item到ListView的首选项
     */
    public void addFirstItem(T entity) {
        datas.add(0, entity);
        notifyDataSetChanged();
    }

    /**
     * 在ListView的底部添加一个Item
     */
    public void addItem(T entity) {
        datas.add(entity);
        notifyDataSetChanged();
    }

    /**
     * 删除指定位置的Item
     */
    public void delItem(int position) {
        datas.remove(position);
        notifyDataSetChanged();
    }

}
