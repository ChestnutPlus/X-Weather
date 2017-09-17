package x.chestnut.weather.base;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/17 14:32
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public interface MvpBasePresenter {
    /**
     * View层订阅Presenter层
     */
    void onSubscribe();

    /**
     * View层解除订阅
     */
    void onUnSubscribe();
}
