package x.chestnut.weather.v.recyclerView.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chestnut.Common.ui.recyclerView.XHolder;
import com.chestnut.Common.ui.recyclerView.XItem;

import java.text.SimpleDateFormat;
import java.util.Date;

import x.chestnut.weather.R;
import x.chestnut.weather.m.bean.WBean;
import x.chestnut.weather.v.recyclerView.adapter.SimpleAdapter;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/19 22:17
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class ToadyBrfItem extends XItem<WBean>{

    public ToadyBrfItem(WBean wBean) {
        super(wBean);
    }

    @Override
    public XHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new XHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_today_brf,null));
    }

    @Override
    public void onBindViewHolder(XHolder xHolder, int i) {
        Context context = xHolder.getItemHoldView().getContext();
        //城市
        ((TextView)xHolder.getViewById(R.id.txt_city)).setText(data.cityName);
        //当前温度
        ((TextView)xHolder.getViewById(R.id.txt_now_temp))
                .setText(context.getString(R.string.item_toady_brf_now_temp).replace("{x}",data.today.nowTemp));
        //简短描述
        String str = context.getString(R.string.item_today_brf_weather_brf).replace("{x}",data.today.txt);
        ((TextView)xHolder.getViewById(R.id.txt_weather_brf))
                .setText(str.replace("{y}",data.today.degreeOfComfortBrf));
        //上次更新时间
        SimpleDateFormat myFmt2=new SimpleDateFormat("HH:mm");
        ((TextView)xHolder.getViewById(R.id.txt_update_time))
                .setText(context.getString(R.string.item_today_brf_update_time).replace("{x}",myFmt2.format(new Date(data.today.updateTimestampMs))));
    }

    @Override
    public int getItemType() {
        return SimpleAdapter.TYPE_ITEM_TODAY_BRF;
    }

    @Override
    public void releaseRes() {

    }
}
