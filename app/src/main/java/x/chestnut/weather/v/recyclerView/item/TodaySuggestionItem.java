package x.chestnut.weather.v.recyclerView.item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chestnut.Common.ui.recyclerView.XHolder;
import com.chestnut.Common.ui.recyclerView.XItem;

import x.chestnut.weather.R;
import x.chestnut.weather.m.bean.WBean;
import x.chestnut.weather.v.recyclerView.adapter.SimpleAdapter;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/24 11:33
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class TodaySuggestionItem extends XItem<WBean.DailyForecastBean>{

    public TodaySuggestionItem(WBean.DailyForecastBean dailyForecastBean) {
        super(dailyForecastBean);
    }

    @Override
    public XHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new XHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_today_suggestion,null));
    }

    @Override
    public void onBindViewHolder(XHolder xHolder, int i) {
        Context context = xHolder.getItemHoldView().getContext();
        String s = context.getString(R.string.item_today_suggestion);
        String temp;
        temp = s.replace("{x}",data.washCarBrf);
        ((TextView)xHolder.getViewById(R.id.txt_car))
                .setText(temp.replace("{y}",data.washCarDesc));
        temp = s.replace("{x}",data.sportBrf);
        ((TextView)xHolder.getViewById(R.id.txt_sport))
                .setText(temp.replace("{y}",data.sportDesc));
        temp = s.replace("{x}",data.dressingBrf);
        ((TextView)xHolder.getViewById(R.id.txt_cloth))
                .setText(temp.replace("{y}",data.dressingDesc));
        temp = s.replace("{x}",data.uvBrf);
        ((TextView)xHolder.getViewById(R.id.txt_uv))
                .setText(temp.replace("{y}",data.uvDesc));
    }

    @Override
    public int getItemType() {
        return SimpleAdapter.TYPE_ITEM_TODAY_SUGGESTION;
    }

    @Override
    public void releaseRes() {

    }
}
