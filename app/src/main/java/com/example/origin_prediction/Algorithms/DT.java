package com.example.origin_prediction.Algorithms;

import com.example.origin_prediction.Pojo.Car;

public class DT {
    public static String predict(Car car){
        String origin;
        if(car.getWeight()<=1812.5){
            if(car.getDisplacement()<=94.5){
                origin="Japanese";
            }else{
                origin="American";
            }
        }else{
            if(car.getHorsePower()<=63.5){
                origin="European";
            }else{
                origin="Japanese";
            }
        }
        return "Your car is "+origin;
    }

}
