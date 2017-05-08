package com.berchina.zx.zxexpress;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends Activity {

    private String TAG = getClass().getName();


    @BindView(R.id.lv)
    ListView lv;

    private String url = "http://www.kuaidi.com/index-ajaxselectcourierinfo-3934210648530-yunda.html";

    private List<Bean.DataBean> mBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        OkGo.get(url)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Bean bean = JsonUtils.jsonResult(s, new TypeToken<Bean>() {
                        });
                        Log.e(TAG, bean.toString());
                        mBean = bean.data;
                        setData();
                    }
                });

    }

    private void setData() {
        MyAdapter adapter = new MyAdapter(this, mBean);
        lv.setAdapter(adapter);
    }
}
