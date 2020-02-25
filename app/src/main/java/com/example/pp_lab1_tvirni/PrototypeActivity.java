package com.example.pp_lab1_tvirni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrototypeActivity extends AppCompatActivity {

    public abstract class Shape {
        public int x;
        public int y;
        public String color;

        public Shape() {
        }

        public Shape(Shape target) {
            if (target != null) {
                this.x = target.x;
                this.y = target.y;
                this.color = target.color;
            }
        }

        public abstract Shape clone();

    }
    //--------------------------------------

    public class Circle extends Shape {

        public int radius;

        public Circle() {
        }

        public Circle(Circle target) {
            super(target);
            if (target != null) {
                this.radius = target.radius;
            }
        }

        @Override
        public Shape clone() {

            return new Circle(this);
        }

    }
    //-------------------------------------------

    public class Rectangle extends Shape {

        public int width;
        public int height;

        public Rectangle() {
        }

        public Rectangle(Rectangle target) {
            super(target);
            if (target != null) {
                this.width = target.width;
                this.height = target.height;
            }
        }

        @Override
        public Shape clone() {
            return new Rectangle(this);
        }

    }

    //---------------------------------------
    Circle circle = new Circle();
    Circle anotherCircle;
    Rectangle rectangle = new Rectangle();
    Rectangle anotherRectangle;

    TextView tv;
    Button b_circle;
    Button b_rectangle;
    Button b_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prototype);

        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";

        rectangle.width = 10;
        rectangle.height = 20;
        circle.color = "blue";

        tv=(TextView) findViewById(R.id.tv);
        b_circle=(Button) findViewById(R.id.clone_circle);
        b_rectangle=(Button)findViewById(R.id.clone_rectangle);
        b_clear=(Button)findViewById(R.id.clear);
    }


    public void clone_circle(View view){
        anotherCircle = (Circle) circle.clone();
        tv.setText(tv.getText()+"\n"+"Created a new circle clone.");
        b_clear.setClickable(true);
        b_circle.setClickable(false);
    }

    public void clone_rectangle(View view){
        anotherRectangle = (Rectangle) rectangle.clone();
        tv.setText(tv.getText()+"\n"+"Created a new rectangle clone.");
        b_clear.setClickable(true);
        b_rectangle.setClickable(false);
    }

    public void clear(View view){
        anotherCircle = null;
        anotherRectangle = null;
        tv.setText("");
        b_circle.setClickable(true);
        b_rectangle.setClickable(true);
    }

}
