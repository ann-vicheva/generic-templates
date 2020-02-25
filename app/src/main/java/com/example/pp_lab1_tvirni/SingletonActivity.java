package com.example.pp_lab1_tvirni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingletonActivity extends AppCompatActivity {

    public static final class Singleton {
        private static Singleton instance;
        public String value;

        private Singleton(String value) {
            this.value = value;
        }

        public static Singleton getInstance(String value) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }

    //--------------------------------------------

    Singleton anotherSingleton;

    TextView tv;
    Button b_create_intance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);

        Singleton singleton = Singleton.getInstance("First value");

        tv=(TextView) findViewById(R.id.tv);
        b_create_intance=(Button) findViewById(R.id.create_intance);
    }

    public void create_intance(View view){
        anotherSingleton = Singleton.getInstance("Second value");
        tv.setText(tv.getText()+"\n"
                +"A new instance of the class was created with the value:"
                +anotherSingleton.value);
    }

    public void clear(View view){
        anotherSingleton=null;
        tv.setText("");
    }

}
