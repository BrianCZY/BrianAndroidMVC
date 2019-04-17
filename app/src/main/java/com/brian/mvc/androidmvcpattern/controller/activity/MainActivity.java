package com.brian.mvc.androidmvcpattern.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brian.mvc.androidmvcpattern.R;
import com.brian.mvc.androidmvcpattern.bean.PropertiesBean;
import com.brian.mvc.androidmvcpattern.contract.MainContract;
import com.brian.mvc.androidmvcpattern.model.MainModelImpl;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 读取proties 资源文件
 */
public class MainActivity extends AppCompatActivity implements MainContract.IView {

    @BindView(R.id.btn_read_file)
    Button btnReadFile;
    @BindView(R.id.tv_goto_second)
    Button tvGotoSecond;
    MainModelImpl mMainModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainModel = new MainModelImpl();
        mMainModel.bindView(this);
    }

    @Override
    public void readProtiesSuccess(PropertiesBean propertiesBean) {
        Toast.makeText(MainActivity.this,
                "baseUrl = " + propertiesBean.getBaseUrl() + " \ntestUrl = " + propertiesBean.getTestUrl(),
                Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onError(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_read_file, R.id.tv_goto_second})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_read_file:
                String config_file = "config.properties";
                mMainModel.requsetFile(MainActivity.this, config_file);
                break;
            case R.id.tv_goto_second:
                break;
        }
    }
}
