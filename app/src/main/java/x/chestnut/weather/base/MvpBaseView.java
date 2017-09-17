package x.chestnut.weather.base;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2017/9/17 14:31
 *     desc  :
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */

public interface MvpBaseView<T> {
    /**
     * View层绑定Presenter
     * @param presenter T presenter
     */
    void setPresenter(T presenter);
}
