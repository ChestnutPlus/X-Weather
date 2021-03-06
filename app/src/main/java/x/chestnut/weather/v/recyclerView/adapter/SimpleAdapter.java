package x.chestnut.weather.v.recyclerView.adapter;

import com.chestnut.Common.ui.recyclerView.XAdapter;
import com.chestnut.Common.ui.recyclerView.XHolder;
import com.chestnut.Common.ui.recyclerView.XItem;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/4/30 21:27
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class SimpleAdapter extends XAdapter<XItem> {

    /*在这里统一Item的类型*/
    public static final int TYPE_ITEM_TODAY_BRF = 0;
    public static final int TYPE_ITEM_OTHER_DAY_BRF = 1;
    public static final int TYPE_ITEM_TODAY_DETAIL = 2;
    public static final int TYPE_ITEM_TODAY_SUGGESTION = 3;


    /**
     * 如果子类需要在onBindViewHolder 回调的时候做的操作可以在这个方法里做
     */
    @Override
    protected void onViewHolderBound(XHolder holder, int position) {
        
    }
}
