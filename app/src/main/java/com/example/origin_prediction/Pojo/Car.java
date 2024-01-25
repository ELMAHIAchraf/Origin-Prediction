package com.example.origin_prediction.Pojo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {
    private double mgp;
    private double displacement;
    private double horsePower;
    private double weight;
    private double acceleration;
    private String origin;
    private double result;


    public Car(double mgp, double displacement, double horsePower, double weight, double acceleration) {
        this.mgp = mgp;
        this.displacement = displacement;
        this.horsePower = horsePower;
        this.weight = weight;
        this.acceleration = acceleration;
    }

    public Car(double mgp, double displacement, double horsePower, double weight, double acceleration, String origin) {
        this.mgp = mgp;
        this.displacement = displacement;
        this.horsePower = horsePower;
        this.weight = weight;
        this.acceleration = acceleration;
        this.origin = origin;
    }

    public Car(double mgp, double displacement, double horsePower, double weight, double acceleration, String origin, double result) {
        this.mgp = mgp;
        this.displacement = displacement;
        this.horsePower = horsePower;
        this.weight = weight;
        this.acceleration = acceleration;
        this.origin = origin;
        this.result = result;
    }

    public static List<Car> getCars(){
        List<Car> cars = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\elmah\\AndroidStudioProjects\\OriginPrediction\\app\\src\\main\\res\\raw\\data.csv"));
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

    public double getMgp() {
        return mgp;
    }

    public void setMgp(double mgp) {
        this.mgp = mgp;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public double getResult() {
        return result;
    }

    public void setHorsePower(double horsepoer) {
        this.horsePower = horsepoer;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setResult(double result) {
        this.result = result;
    }
}