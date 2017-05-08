package com.berchina.zx.zxexpress;

import java.util.List;

/**
 * Created by zx on 2017/5/8 13:25
 * 项目名称：ZXExpress
 * 类描述：
 * 备注
 */
public class Bean {


    /**
     * company : 韵达快递
     * companytype : yunda
     * data : [{"context":"到达：贵州都匀市公司 由 已签收 签收","time":"2016-08-21 19:47:14"},{"context":"到达：贵州都匀市公司 指定：小围寨分部(1111-1111111) 派送","time":"2016-08-21 09:45:36"},{"context":"到达：贵州贵阳分拨中心 发往：贵州都匀市公司","time":"2016-08-20 06:32:38"},{"context":"到达：贵州贵阳分拨中心 上级站点：福建晋江分拨中心","time":"2016-08-20 06:17:24"},{"context":"到达：福建晋江分拨中心 发往：贵州贵阳分拨中心","time":"2016-08-18 21:48:53"},{"context":"到达：福建晋江分拨中心","time":"2016-08-18 21:46:25"},{"context":"到达：福建市场部台江服务部 已收件","time":"2016-08-18 08:30:44"},{"context":"到达：福建市场部台江服务部 发往：贵州贵阳分拨中心","time":"2016-08-18 06:48:19"},{"context":"到达：福建市场部台江服务部 已收件","time":"2016-08-18 06:37:54"},{"context":"到达：福建市场部台江服务部 已收件","time":"2016-08-18 05:51:57"}]
     * exceed :
     * ico : /data/upload/201407/yd_logo.gif
     * nu : 1202247993797
     * phone : 95546
     * rank : 2.4
     * reason :
     * status : 6
     * success : true
     * time :
     * timeused : --
     * url : http://www.yundaex.com
     */

    public String company;
    public String companytype;
    public String exceed;
    public String ico;
    public String nu;
    public String phone;
    public String rank;
    public String reason;
    public int status;
    public boolean success;
    public String time;
    public String timeused;
    public String url;

    public List<DataBean> data;


    @Override
    public String toString() {
        return "Bean{" +
                "company='" + company + '\'' +
                ", companytype='" + companytype + '\'' +
                ", exceed='" + exceed + '\'' +
                ", ico='" + ico + '\'' +
                ", nu='" + nu + '\'' +
                ", phone='" + phone + '\'' +
                ", rank='" + rank + '\'' +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", success=" + success +
                ", time='" + time + '\'' +
                ", timeused='" + timeused + '\'' +
                ", url='" + url + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * context : 到达：贵州都匀市公司 由 已签收 签收
     * time : 2016-08-21 19:47:14
     */
    public static class DataBean {
        public String context;
        public String time;

        @Override
        public String toString() {
            return "DataBean{" +
                    "context='" + context + '\'' +
                    ", time='" + time + '\'' +
                    '}';
        }
    }
}
