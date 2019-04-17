package com.brian.mvc.androidmvcpattern.controller.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.brian.mvc.androidmvcpattern.R;
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
    }

    @Override
    public void readProtiesSuccess(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startloading() {

    }

    @Override
    public void stopLoading() {

    }

    @OnClick({R.id.btn_read_file, R.id.tv_goto_second})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_read_file:
                mMainModel.requsetFile(MainActivity.this, "", this);
                break;
            case R.id.tv_goto_second:
                break;
        }
    }
}
