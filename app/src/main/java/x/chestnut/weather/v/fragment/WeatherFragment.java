package x.chestnut.weather.v.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.androidadvance.topsnackbar.TSnackbar;
import com.chestnut.Common.utils.ConvertUtils;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import x.chestnut.weather.R;
import x.chestnut.weather.contract.WeatherContract;
import x.chestnut.weather.m.bean.WBean;
import x.chestnut.weather.p.WeatherPresenter;
import x.chestnut.weather.v.recyclerView.adapter.SimpleAdapter;
import x.chestnut.weather.v.recyclerView.decoration.SpacesItemDecoration;
import x.chestnut.weather.v.recyclerView.item.OtherDayBrfItem;
import x.chestnut.weather.v.recyclerView.item.ToadyBrfItem;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/18 21:50
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public class WeatherFragment extends Fragment implements WeatherContract.V{

    public static final String KEY_CITY = "KEY_CITY";
    private boolean OpenLog = true;
    private String TAG = "WeatherFragment";
    private String city;

    private WeatherPresenter weatherPresenter;

    private ProgressBar progressBar;
    private SimpleAdapter simpleAdapter;
    private MaterialRefreshLayout refreshLayout;
    private MaterialRefreshListener materialRefreshListener = new MaterialRefreshListener() {
        @Override
        public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
            refreshLayout.finishRefresh();
        }
    };

    public static WeatherFragment get(String city) {
        WeatherFragment weatherFragment = new WeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_CITY,city);
        weatherFragment.setArguments(bundle);
        return weatherFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null) {
            city = getArguments().getString(KEY_CITY,"深圳");
        }
        else
            city = "深圳";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather,container,false);
        weatherPresenter = new WeatherPresenter(this,city);
        weatherPresenter.onSubscribe();
        progressBar = view.findViewById(R.id.progress_bar);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.addItemDecoration(new SpacesItemDecoration(ConvertUtils.dp2px(view.getContext(),8)));
        simpleAdapter = new SimpleAdapter();
        recyclerView.setAdapter(simpleAdapter);
        refreshLayout = view.findViewById(R.id.refresh_layout);
        refreshLayout.setShowArrow(false);
        refreshLayout.setShowProgressBg(false);
        refreshLayout.setWaveShow(false);
        refreshLayout.setMaterialRefreshListener(materialRefreshListener);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        weatherPresenter.updateAllData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        weatherPresenter.onUnSubscribe();
    }

    @Override
    public void setPresenter(WeatherContract.P presenter) {

    }

    @Override
    public void notifyUpdateStart() {
        if (WeatherFragment.this.getView()!=null)
            TSnackbar.make(WeatherFragment.this.getView(),"loading...",TSnackbar.LENGTH_SHORT).show();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void notifyUpdateFail() {
        if (WeatherFragment.this.getView()!=null)
            TSnackbar.make(WeatherFragment.this.getView(),"(*+﹏+*)~ error ...",TSnackbar.LENGTH_LONG).show();
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void notifyUpdateEnd(WBean wBean) {
        if (WeatherFragment.this.getView()!=null)
            TSnackbar.make(WeatherFragment.this.getView(),"o(*￣▽￣*)ブ...",TSnackbar.LENGTH_LONG).show();
        if (wBean!=null) {
            if (wBean.today!=null) {
                simpleAdapter.add(new ToadyBrfItem(wBean));
            }
            if (wBean.dailyForecastBeanList!=null) {
                for (WBean.DailyForecastBean d : wBean.dailyForecastBeanList) {
                    simpleAdapter.add(new OtherDayBrfItem(d));
                }
            }
            simpleAdapter.notifyDataSetChanged();
        }
        progressBar.setVisibility(View.INVISIBLE);
    }
}
