package com.example.origin_prediction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Car implements Serializable {
    private int mgp;
    private int displacement;
    private int horsePower;
    private int weight;
    private int acceleration;

    private String origin;

    public Car(int mgp, int displacement, int horsePower, int weight, int acceleration, String origin) {
        this.mgp = mgp;
        this.displacement = displacement;
        this.horsePower = horsePower;
        this.weight = weight;
        this.acceleration = acceleration;
        this.origin = origin;
    }

    public Car(int mgp, int displacement, int horsePower, int weight, int acceleration) {
        this.mgp = mgp;
        this.displacement = displacement;
        this.horsePower = horsePower;
        this.weight = weight;
        this.acceleration = acceleration;
    }

    public static List<Car> getCars(){
        List<Car> cars = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\elmah\\Desktop\\Car\\src\\main\\resources\\data.csv"));
            String row = "";

            while((row=reader.readLine())!=null){
                String [] column = row.split(",");
                cars.add(new Car(Integer.parseInt(column[0]),
                        Integer.parseInt(column[1]),
                        Integer.parseInt(column[2]),
                        Integer.parseInt(column[3]),
                        Integer.parseInt(column[4]),
                        column[5])
                );
            }
            return cars;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getMgp() {
        return mgp;
    }

    public void setMgp(int mgp) {
        this.mgp = mgp;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsepoer) {
        this.horsePower = horsepoer;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int acceleration) {
        this.acceleration = acceleration;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}