package wenhao.bawie.com.retrofit_rxjavasousuo.mvp.view;

import java.util.List;

import wenhao.bawie.com.retrofit_rxjavasousuo.bean.SouBean;

/**
 * Created by HP on 2018/11/8.
 */

public interface SouView {
    void success(List<SouBean.DataBean> data);
}
