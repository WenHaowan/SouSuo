package wenhao.bawie.com.retrofit_rxjavasousuo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import wenhao.bawie.com.retrofit_rxjavasousuo.adapter.SouAdapter;
import wenhao.bawie.com.retrofit_rxjavasousuo.bean.SouBean;
import wenhao.bawie.com.retrofit_rxjavasousuo.mvp.presenter.SouPresenter;
import wenhao.bawie.com.retrofit_rxjavasousuo.mvp.view.SouView;

public class MainActivity extends AppCompatActivity implements SouView{

    private RecyclerView recy_view;
    private Button button_click;
    private EditText edit_sou;
    private SouPresenter souPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy_view = (RecyclerView) findViewById(R.id.recy_view);
        button_click = (Button) findViewById(R.id.button_click);
        edit_sou = (EditText) findViewById(R.id.edit_sou);
        recy_view.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        souPresenter = new SouPresenter(this);
        souPresenter.getSouSuo("笔记本");
        button_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Souname = edit_sou.getText().toString();
                if (TextUtils.isEmpty(Souname)){
                    return;
                }
                souPresenter.getSouSuo(Souname);
            }
        });
    }

    @Override
    public void success(List<SouBean.DataBean> data) {
        SouAdapter souAdapter = new SouAdapter(MainActivity.this, data);
        recy_view.setAdapter(souAdapter);
    }
}
