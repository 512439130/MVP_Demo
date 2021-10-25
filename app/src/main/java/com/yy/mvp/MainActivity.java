package com.yy.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yy.mvp.bean.User;
import com.yy.mvp.presenter.IPresenter;
import com.yy.mvp.presenter.MainPresenter;
import com.yy.mvp.view.IView;

/**
 * MVP Demo
 * View层（视图层）只关心View展示，用户屏幕事件，无业务逻辑，解耦
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, IView {
    private EditText etUser;
    private EditText etPass;
    private Button btnLogin;
    private ProgressDialog progressDialog;

    //Presenter
    private IPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);
        initView();
    }

    private void initView() {
        etUser = findViewById(R.id.er_user);
        etPass = findViewById(R.id.et_pass);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("正在登录,请稍后");
    }


    @Override
    public void onClick(View v) {
        String user = etUser.getText().toString().trim();
        String pass = etPass.getText().toString().trim();
        mainPresenter.login(user,pass);
    }

    @Override
    public void showProgressDialog() {
        if(progressDialog != null){
            progressDialog.show();
        }
    }

    @Override
    public void hideProgressDialog() {
        if(progressDialog != null){
            progressDialog.hide();
        }
    }

    @Override
    public void loginOnSuccess(User user) {
        Toast.makeText(this,"登录成功\n" + user.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginOnFailure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}