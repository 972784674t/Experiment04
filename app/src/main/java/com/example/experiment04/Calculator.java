package com.example.experiment04;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;



public class Calculator extends AndroidViewModel {
    String TAG = "MyTAG";
    String Formula ;
    String Result ;
    String CalculatorData = getApplication().getResources().getString(R.string.CalculatorData);

    public Calculator(@NonNull Application application ) {
        super(application);
    }

    public String getFormula() {
        SharedPreferences shp = getApplication().getSharedPreferences(CalculatorData,Context.MODE_PRIVATE);
        String f = shp.getString("Formula"," ");
        return f;
    }

    public String getResult() {
        SharedPreferences shp = getApplication().getSharedPreferences(CalculatorData,Context.MODE_PRIVATE);
        String r = shp.getString("Result","0");
        Log.d(TAG ,"r:"+r);
        return "=" + r;
    }

    void save(){
        SharedPreferences shp = getApplication().getSharedPreferences(CalculatorData,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putString("Formula",Formula);
        editor.putString("Result",Result);
        editor.apply();
    }

}
