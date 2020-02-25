package com.example.pp_lab1_tvirni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class BuilderActivity extends AppCompatActivity {

    //-------------------------------------------------
    public interface Builder {
        void setType(Type type);
        void setSeats(int seats);
        void setEngine(Engine engine);
        void setTransmission(Transmission transmission);
        void setTripComputer(TripComputer tripComputer);
        void setGPSNavigator(GPSNavigator gpsNavigator);
    }
    //-------------------------------------------------
    public class CarBuilder implements Builder {
        private Type type;
        private int seats;
        private Engine engine;
        private Transmission transmission;
        private TripComputer tripComputer;
        private GPSNavigator gpsNavigator;

        @Override
        public void setType(Type type) {
            this.type = type;
        }

        @Override
        public void setSeats(int seats) {
            this.seats = seats;
        }

        @Override
        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        @Override
        public void setTransmission(Transmission transmission) {
            this.transmission = transmission;
        }

        @Override
        public void setTripComputer(TripComputer tripComputer) {
            this.tripComputer = tripComputer;
        }

        @Override
        public void setGPSNavigator(GPSNavigator gpsNavigator) {
            this.gpsNavigator = gpsNavigator;
        }

        public Car getResult() {
            return new Car(type, seats, engine, transmission, tripComputer, gpsNavigator);
        }
    }
    //-------------------------------------------------
    public class CarManualBuilder implements Builder{
        private Type type;
        private int seats;
        private Engine engine;
        private Transmission transmission;
        private TripComputer tripComputer;
        private GPSNavigator gpsNavigator;

        @Override
        public void setType(Type type) {
            this.type = type;
        }

        @Override
        public void setSeats(int seats) {
            this.seats = seats;
        }

        @Override
        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        @Override
        public void setTransmission(Transmission transmission) {
            this.transmission = transmission;
        }

        @Override
        public void setTripComputer(TripComputer tripComputer) {
            this.tripComputer = tripComputer;
        }

        @Override
        public void setGPSNavigator(GPSNavigator gpsNavigator) {
            this.gpsNavigator = gpsNavigator;
        }

        public Manual getResult() {
            return new Manual(type, seats, engine, transmission, tripComputer, gpsNavigator);
        }
    }
    //-------------------------------------------------
    public class Car {
        private final Type type;
        private final int seats;
        private final Engine engine;
        private final Transmission transmission;
        private final TripComputer tripComputer;
        private final GPSNavigator gpsNavigator;
        private double fuel = 0;

        public Car(Type type, int seats, Engine engine, Transmission transmission,
                   TripComputer tripComputer, GPSNavigator gpsNavigator) {
            this.type = type;
            this.seats = seats;
            this.engine = engine;
            this.transmission = transmission;
            this.tripComputer = tripComputer;
            this.tripComputer.setCar(this);
            this.gpsNavigator = gpsNavigator;
        }

        public Type getType() {
            return type;
        }

        public double getFuel() {
            return fuel;
        }

        public void setFuel(double fuel) {
            this.fuel = fuel;
        }

        public int getSeats() {
            return seats;
        }

        public Engine getEngine() {
            return engine;
        }

        public Transmission getTransmission() {
            return transmission;
        }

        public TripComputer getTripComputer() {
            return tripComputer;
        }

        public GPSNavigator getGpsNavigator() {
            return gpsNavigator;
        }
    }
    //-------------------------------------------------
    public class Manual {
        private final Type type;
        private final int seats;
        private final Engine engine;
        private final Transmission transmission;
        private final TripComputer tripComputer;
        private final GPSNavigator gpsNavigator;

        public Manual(Type type, int seats, Engine engine, Transmission transmission,
                      TripComputer tripComputer, GPSNavigator gpsNavigator) {
            this.type = type;
            this.seats = seats;
            this.engine = engine;
            this.transmission = transmission;
            this.tripComputer = tripComputer;
            this.gpsNavigator = gpsNavigator;
        }

        public String print() {
            String info = "";
            info += "Type of car: " + type + "\n";
            info += "Count of seats: " + seats + "\n";
            info += "Engine: volume - " + engine.getVolume() + "; mileage - " + engine.getMileage() + "\n";
            info += "Transmission: " + transmission + "\n";
            if (this.tripComputer != null) {
                info += "Trip Computer: Functional" + "\n";
            } else {
                info += "Trip Computer: N/A" + "\n";
            }
            if (this.gpsNavigator != null) {
                info += "GPS Navigator: Functional" + "\n";
            } else {
                info += "GPS Navigator: N/A" + "\n";
            }
            return info;
        }
    }
    //-------------------------------------------------
    public enum Type {
        CITY_CAR, SPORTS_CAR, SUV
    }
    //-------------------------------------------------
    public class Engine {
        private final double volume;
        private double mileage;
        private boolean started;

        public Engine(double volume, double mileage) {
            this.volume = volume;
            this.mileage = mileage;
        }

        public void on() {
            started = true;
        }

        public void off() {
            started = false;
        }

        public boolean isStarted() {
            return started;
        }

        public void go(double mileage) {
            if (started) {
                this.mileage += mileage;
            } else {
                System.err.println("Cannot go(), you must start engine first!");
            }
        }

        public double getVolume() {
            return volume;
        }

        public double getMileage() {
            return mileage;
        }
    }
    //-------------------------------------------------
    public class GPSNavigator {
        private String route;

        public GPSNavigator() {
            this.route = "221b, Baker Street, London  to Scotland Yard, 8-10 Broadway, London";
        }

        public GPSNavigator(String manualRoute) {
            this.route = manualRoute;
        }

        public String getRoute() {
            return route;
        }
    }
    //-------------------------------------------------
    public enum Transmission {
        SINGLE_SPEED, MANUAL, AUTOMATIC, SEMI_AUTOMATIC
    }
    //-------------------------------------------------
    public class TripComputer {

        private Car car;

        public void setCar(Car car) {
            this.car = car;
        }

        public void showFuelLevel() {
            System.out.println("Fuel level: " + car.getFuel());
        }

        public void showStatus() {
            if (this.car.getEngine().isStarted()) {
                System.out.println("Car is started");
            } else {
                System.out.println("Car isn't started");
            }
        }
    }
    //-------------------------------------------------
    public class Director {

        public void constructSportsCar(Builder builder) {
            builder.setType(Type.SPORTS_CAR);
            builder.setSeats(2);
            builder.setEngine(new Engine(3.0, 0));
            builder.setTransmission(Transmission.SEMI_AUTOMATIC);
            builder.setTripComputer(new TripComputer());
            builder.setGPSNavigator(new GPSNavigator());
        }

        public void constructCityCar(Builder builder) {
            builder.setType(Type.CITY_CAR);
            builder.setSeats(2);
            builder.setEngine(new Engine(1.2, 0));
            builder.setTransmission(Transmission.AUTOMATIC);
            builder.setTripComputer(new TripComputer());
            builder.setGPSNavigator(new GPSNavigator());
        }

        public void constructSUV(Builder builder) {
            builder.setType(Type.SUV);
            builder.setSeats(4);
            builder.setEngine(new Engine(2.5, 0));
            builder.setTransmission(Transmission.MANUAL);
            builder.setGPSNavigator(new GPSNavigator());
        }
    }
    //-------------------------------------------------

    //-------------------------------------------------

    //-------------------------------------------------

    //-------------------------------------------------

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builder);

        tv=(TextView)findViewById(R.id.tv);
    }

    public void create(View view){
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);
        Car car = builder.getResult();
        tv.setText(tv.getText()+"\n"+"Car built:\n"+car.getType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        tv.setText(tv.getText()+"\n"+"Car manual built:\n"+carManual.print());
    }

    public void clear(View view){
        tv.setText("");
    }

}
