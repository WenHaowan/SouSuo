package wenhao.bawie.com.retrofit_rxjavasousuo.mvp.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import wenhao.bawie.com.retrofit_rxjavasousuo.bean.SouBean;

/**
 * Created by HP on 2018/11/8.
 */

public interface Api {
    @GET("product/searchProducts")
    Observable<SouBean> getSou(@Query("keywords") String keywords);
}
