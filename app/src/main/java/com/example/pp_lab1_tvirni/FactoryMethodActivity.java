package com.example.pp_lab1_tvirni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import static com.example.pp_lab1_tvirni.FactoryMethodActivity.CoffeeType.AMERICANO;
import static com.example.pp_lab1_tvirni.FactoryMethodActivity.CoffeeType.ESPRESSO;

public class FactoryMethodActivity extends AppCompatActivity {

    //----------------------------
    public class Coffee {
        public void grindCoffee(){
            // перемалываем кофе
        }
        public void makeCoffee(){
            // делаем кофе
        }
        public void pourIntoCup(){
            // наливаем в чашку
        }
    }
    //----------------------------
    public class Americano extends Coffee {}
    public class Espresso extends Coffee {}
    //----------------------------
    public enum CoffeeType {
        ESPRESSO,
        AMERICANO
    }
    //------------------------------
    public class SimpleCoffeeFactory {
        public SimpleCoffeeFactory(){}
        public Coffee createCoffee (CoffeeType type) {
            Coffee coffee = null;

            switch (type) {
                case AMERICANO:
                    coffee = new Americano();
                    break;
                case ESPRESSO:
                    coffee = new Espresso();
                    break;
            }

            return coffee;
        }
    }
    //----------------------------------

    //----------------------------------


    CheckBox cb1;
    CheckBox cb2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factory_method);

        cb1=(CheckBox)findViewById(R.id.first_obj);
        cb2=(CheckBox)findViewById(R.id.second_obj);
        tv=(TextView)findViewById(R.id.tv);
        //SimpleCoffeeFactory coffeeFactory;

    }

    public void create(View view){

        SimpleCoffeeFactory coffeeFactory=new SimpleCoffeeFactory();
        Coffee coffee=new Coffee();
        if (cb1.isChecked()){
            coffee = coffeeFactory.createCoffee(AMERICANO);
            tv.setText(tv.getText()+"\n"+"your americano is ready");
            cb2.setChecked(false);
        }else {
            if (cb2.isChecked()) {
                coffee = coffeeFactory.createCoffee(ESPRESSO);
                tv.setText(tv.getText()+"\n"+"your espresso is ready");
                cb1.setChecked(false);
            }
        }
        coffee.grindCoffee();
        coffee.makeCoffee();
        coffee.pourIntoCup();
    }

    public void clear(View view){
        tv.setText("");
        cb1.setChecked(true);
        cb2.setChecked(false);
    }

}
