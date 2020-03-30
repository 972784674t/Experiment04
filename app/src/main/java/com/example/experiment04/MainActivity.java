package com.example.experiment04;

import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.example.experiment04.databinding.ActivityMainBinding;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Calculator myCalculator;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myCalculator = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(Calculator.class);
        binding.setMyCalculator(myCalculator);
        binding.setLifecycleOwner(this);
        initView(myCalculator);
    }

    /**
     * 界面初始化
     * @param myCalculator
     */
    public void initView(Calculator myCalculator){
        MaterialButton btn0 = findViewById(R.id.btn_C0);
        MaterialButton btn1 = findViewById(R.id.btn_C1);
        MaterialButton btn2 = findViewById(R.id.btn_C2);
        MaterialButton btn3 = findViewById(R.id.btn_C3);
        MaterialButton btn4 = findViewById(R.id.btn_C4);
        MaterialButton btn5 = findViewById(R.id.btn_C5);
        MaterialButton btn6 = findViewById(R.id.btn_C6);
        MaterialButton btn7 = findViewById(R.id.btn_C7);
        MaterialButton btn8 = findViewById(R.id.btn_C8);
        MaterialButton btn9 = findViewById(R.id.btn_C9);
        MaterialButton btnjia = findViewById(R.id.btn_Cjia);
        MaterialButton btnjian = findViewById(R.id.jian);
        MaterialButton btnchen = findViewById(R.id.btn_CX);
        MaterialButton btnchu = findViewById(R.id.btn_chu);
        MaterialButton btndeng = findViewById(R.id.btn_C15);
        MaterialButton btndm = findViewById(R.id.btn_Cm);
        MaterialButton btndian = findViewById(R.id.btn_Cdiain);
        MaterialButton btnc = findViewById(R.id.btn_CC);
        MaterialButton btndel = findViewById(R.id.btn_X);
        MaterialButton btnyu = findViewById(R.id.btn_yu);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnjia.setOnClickListener(this);
        btnjian.setOnClickListener(this);
        btnchen.setOnClickListener(this);
        btnchu.setOnClickListener(this);
        btndeng.setOnClickListener(this);
        btndm.setOnClickListener(this);
        btndian.setOnClickListener(this);
        btnc.setOnClickListener(this);
        btndel.setOnClickListener(this);
        btnyu.setOnClickListener(this);

        //退格按钮icon居中
        final MaterialButton button_del = findViewById(R.id.btn_X);
        getIconcenter(button_del);
        //旋转屏幕按钮居中
        final MaterialButton buttonChange = findViewById(R.id.btn_Cm);
        getIconcenter(buttonChange);

        //界面ondestroy后初始化
//        TextView t1 = findViewById(R.id.Formula);
//        TextView t2 = findViewById(R.id.res);
//        if( myCalculator.Formula != " " ) {
//            t1.setText( myCalculator.getFormula() );
//        }
//        if( myCalculator.Result != "0" ) {
//            t2.setText("=" + myCalculator.getResult());
//        }
    }

    /**
     * 按钮图标居中
     * @param btn
     */
    public void getIconcenter(final MaterialButton btn){
        btn.post(new Runnable() {
            @Override
            public void run() {
                int btnwidth = btn.getWidth();
                btn.measure(0, 0);
                int iconwidth = btn.getIcon().getIntrinsicWidth();
                int paddingleft = ( btnwidth - iconwidth  ) / 2;
                btn.setPadding( paddingleft , 0, 0, 0 );
            }
        });
    }

    /**
     * 点击事件重写
     * @param v
     */
    @Override
    public void onClick(View v) {

        TextView Textstr = findViewById(R.id.Formula);
        String str = Textstr.getText().toString();
        TextView textres = findViewById(R.id.res);
        switch ( v.getId() ) {
            case R.id.btn_C0:
                str+="0";
                myCalculator.Formula = str;
                Textstr.setText(str);
                break;
            case R.id.btn_C1:
                str+="1";
                myCalculator.Formula = str;
                Textstr.setText(str);
                break;
            case R.id.btn_C2:
                str+="2";
                myCalculator.Formula = str;
                Textstr.setText(str);
                break;
            case R.id.btn_C3:
                str+="3";
                myCalculator.Formula = str;
                Textstr.setText(str);
                break;
            case R.id.btn_C4:
                str+="4";
                myCalculator.Formula = str;
                Textstr.setText(str);
                break;
            case R.id.btn_C5:
                str+="5";
                myCalculator.Formula = str;
                Textstr.setText(str);
                break;
            case R.id.btn_C6:
                str+="6";
                myCalculator.Formula = str;
                Textstr.setText(str);
                break;
            case R.id.btn_C7:
                str+="7";
                myCalculator.Formula = str;
                Textstr.setText(str);
                break;
            case R.id.btn_C8:
                str+="8";
                myCalculator.Formula = str;
                Textstr.setText(str);
                break;
            case R.id.btn_C9:
                str+="9";
                myCalculator.Formula = str;
                Textstr.setText(str);
                break;
            case R.id.btn_chu:
                if(str.length()!=0){
                    str+="/";
                    myCalculator.Formula = str;
                    Textstr.setText(str);
                }break;
            case R.id.btn_CX:
                if(str.length()!=0){
                    str+="*";
                    myCalculator.Formula = str;
                    Textstr.setText(str);
                }break;
            case R.id.btn_Cdiain:
                if(str.length()!=0 ){
                    str+=".";
                    myCalculator.Formula = str;
                    Textstr.setText(str);
                }break;
            case R.id.btn_Cjia:
                if(str.length()!=0){
                    str+="+";
                    myCalculator.Formula = str;
                    Textstr.setText(str);
                }break;
            case R.id.jian:
                if(str.length()!=0){
                    str+="-";
                    myCalculator.Formula = str;
                    Textstr.setText(str);
                }break;
            case R.id.btn_yu:
                if(str.length()!=0){
                    str+="%";
                    myCalculator.Formula = str;
                    Textstr.setText(str);
                }break;
            case R.id.btn_X:
                if(str.length()>=1) {
                    myCalculator.Formula = str;
                    str = str.substring(0, str.length() - 1);
                    Textstr.setText(str);
                    //如果字符串长度大于等于1，就前删一个字符
                }
                break;
            case R.id.btn_CC:
                str="";
                myCalculator.Formula = str;
                myCalculator.Result = null;
                Textstr.setText(str);
                textres.setText("0");
                break;
            case R.id.btn_Cm:
                myCalculator.Formula = str;
                Textstr.setText(str);
                getScreenMessage();
                break;
            case R.id.btn_C15:
                String formula = Textstr.getText().toString();
                try {
                    ReversePolishMultiCalc.doCalc(ReversePolishMultiCalc.doMatch(formula));
                    String res = String.valueOf(ReversePolishMultiCalc.RESULT);
                    myCalculator.Result = res;
                    textres.setText("="+res);
                    myCalculator.save();
                } catch (Exception e) {
                    textres.setText("错误的表达式");
                }
                break;
        }

   }

    /**
     * 旋转屏幕
     */
    public void getScreenMessage(){
        Configuration cfg = getResources().getConfiguration();
        //判断当前屏幕是否横屏
        if ( cfg.orientation == Configuration.ORIENTATION_LANDSCAPE ){
            MainActivity.this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        }else {
            MainActivity.this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE );
        }
    }

}
