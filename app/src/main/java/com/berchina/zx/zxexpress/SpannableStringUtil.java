package com.berchina.zx.zxexpress;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zx on 2017/5/8 13:56
 * 项目名称：ZXExpress
 * 类描述：
 * 备注
 */
public class SpannableStringUtil {

    public static SpannableString zhuanHuanTelUrl(final Context context, final String strTel) {
        SpannableString ss = new SpannableString(strTel);
        final List<String> list = getNumbers(strTel);
        if (list.size() > 0) {
            ss.setSpan(new ClickableSpan() {
                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setColor(Color.RED);       //设置文件颜色
                    ds.setUnderlineText(true);      //设置下划线
                }

                @Override
                public void onClick(View widget) {
                    new AlertDialog.Builder(context)
                            .setTitle("是否拨打电话")
                            .setMessage("电话号码"+list.get(0))
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    intent2Call(context, list.get(0));
                                }
                            })
                            .show();

                }
            }, strTel.indexOf(list.get(0)), strTel.indexOf(list.get(0)) + 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return ss;
    }

    /**
     * 跳转到拨打电话界面
     *
     * @param context
     * @param phoneNumber 传入的电话号码
     */
    public static void intent2Call(Context context, String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phoneNumber));
        callIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(callIntent);
    }

    /**
     * 从字符串中查找电话号码字符串
     */
    private static List<String> getNumbers(String content) {
        List<String> digitList = new ArrayList<String>();
        Pattern p = Pattern.compile("(\\d{11})");
        Matcher m = p.matcher(content);
        while (m.find()) {
            String find = m.group(1).toString();
            digitList.add(find);
        }
        return digitList;
    }
}
