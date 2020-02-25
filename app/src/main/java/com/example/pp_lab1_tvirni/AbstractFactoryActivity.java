package com.example.pp_lab1_tvirni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class AbstractFactoryActivity extends AppCompatActivity {

    //--------------------------------------
    public interface CarsFactory {
        Sedan createSedan();
        Coupe createCoupe();
    }

    public class ToyotaFactory implements CarsFactory {
        @Override
        public Sedan createSedan() {
            return new  ToyotaSedan();
        }

        @Override
        public Coupe createCoupe() {
            return new ToyotaCoupe();
        }
    }

    public class FordFactory implements CarsFactory {
        @Override
        public Sedan createSedan() {
            return new  FordSedan();
        }

        @Override
        public Coupe createCoupe() {
            return new FordCoupe();
        }
    }
    //--------------------------------------
    public interface Sedan {}

    public interface Coupe {}
    //--------------------------------------
    public class ToyotaCoupe implements Coupe {
        public ToyotaCoupe() {
            nameCar="Create ToyotaCoupe";
            //System.out.println("Create ToyotaCoupe");
        }
    }

    public class ToyotaSedan implements Sedan {
        public ToyotaSedan() {
            nameCar="Create ToyotaSedan";
            //System.out.println("Create ToyotaSedan");
        }
    }

    public class FordCoupe implements Coupe {
        public FordCoupe () {
            nameCar="Create FordCoupe";
            //System.out.println("Create FordCoupe");
        }
    }

    public class FordSedan implements Sedan {
        public FordSedan() {
            nameCar="Create FordSedan";
            //System.out.println("Create FordSedan");
        }
    }
    //--------------------------------------
    String nameCar;
    //--------------------------------------
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    TextView tv;
    //--------------------------------------




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract_factory);
        nameCar="";
        cb1=(CheckBox)findViewById(R.id.first_obj);
        cb2=(CheckBox)findViewById(R.id.second_obj);
        cb3=(CheckBox)findViewById(R.id.first_obj2);
        cb4=(CheckBox)findViewById(R.id.second_obj2);
        tv=(TextView)findViewById(R.id.tv);

    }

    public void create(View view){
        CarsFactory factory;
        if(cb1.isChecked()){
            factory = new ToyotaFactory();
            if(cb3.isChecked()){
                //
                factory.createCoupe();
                cb2.setChecked(false);
                cb4.setChecked(false);
            }else{
                //
                factory.createSedan();
                cb2.setChecked(false);
                cb3.setChecked(false);
                cb4.setChecked(true);
            }
        }else{
            factory = new FordFactory();
            if(cb3.isChecked()){
                //
                factory.createCoupe();
                cb1.setChecked(false);
                cb4.setChecked(false);
            }else{
                //
                factory.createSedan();
                cb1.setChecked(false);
                cb3.setChecked(false);
                cb4.setChecked(true);
            }
        }
        tv.setText(tv.getText()+"\n"+nameCar);
    }

    public void clear(View view){
        tv.setText("");
    }

}
