    package com.example.rishi.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

    public class ActivityNavigator extends AppCompatActivity {

        public void navigation(View view){
        switch(view.getId()) {
            case R.id.btnGreet:
                Intent in = new Intent(getApplicationContext(), GreetUserActivity.class);
                startActivity(in);
                break;
            case R.id.btnBenchmark:
                Intent bench = new Intent(getApplicationContext(), Benchmark.class);
                startActivity(bench);
                break;
            case R.id.btnCalculator:
                Intent context = new Intent(getApplicationContext(), SimpleCalculatorActivity.class);
                startActivity(context);
                break;
            case R.id.btnWeb:
                Intent web = new Intent(getApplicationContext(), WebViewActivity.class);
                startActivity(web);
                break;
            case R.id.btnToast:
                Intent toast = new Intent(getApplicationContext(), ToastActivity.class);
                startActivity(toast);
                break;

            case R.id.btnGoogle:
                Intent google = new Intent(getApplication(), GoogleNewsActivity.class);
                google.putExtra("news","Google News");
                startActivity(google);
                break;
            case R.id.btnFelight:
                Intent felight = new Intent(getApplication(), GoogleNewsActivity.class);
                felight.putExtra("news","Felight News");
                startActivity(felight);
                break;
            case R.id.btnSendtext:
                Intent text = new Intent(getApplication(), SendTextActivity.class);
                startActivity(text);
                break;
        }


        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_navigator);

    }
}








