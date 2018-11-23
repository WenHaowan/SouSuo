package wenhao.bawie.com.retrofit_rxjavasousuo.mvp.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import wenhao.bawie.com.retrofit_rxjavasousuo.bean.SouBean;
import wenhao.bawie.com.retrofit_rxjavasousuo.mvp.model.HttpUtils;
import wenhao.bawie.com.retrofit_rxjavasousuo.mvp.view.SouView;

/**
 * Created by HP on 2018/11/8.
 */

public class SouPresenter implements IPresenter{
    private SouView souView;

    public SouPresenter(SouView souView) {
        this.souView = souView;
    }

    public void getSouSuo(String keywords){
        Observable<SouBean> sou = HttpUtils.getUtilsInstance().api.getSou(keywords);
        sou.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SouBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SouBean souBean) {
                        souView.success(souBean.getData());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void onDestroy() {
        if (souView!=null){
            souView=null;
        }
    }
}
