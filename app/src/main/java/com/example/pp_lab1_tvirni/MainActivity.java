package com.example.pp_lab1_tvirni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void prototype(View view){
        Intent intent = new Intent(MainActivity.this, PrototypeActivity.class);
        startActivity(intent);
    }

    public void singleton(View view){
        Intent intent = new Intent(MainActivity.this, SingletonActivity.class);
        startActivity(intent);
    }

    public void factory_method(View view){
        Intent intent = new Intent(MainActivity.this, FactoryMethodActivity.class);
        startActivity(intent);
    }

    public void builder(View view){
        Intent intent = new Intent(MainActivity.this, BuilderActivity.class);
        startActivity(intent);
    }

    public void abstract_factory(View view){
        Intent intent = new Intent(MainActivity.this, AbstractFactoryActivity.class);
        startActivity(intent);
    }
}
