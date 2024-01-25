package com.example.origin_prediction;

import java.util.*;
import java.util.stream.Collectors;

public class Knn {
    public static String calc(List<Car> cars, Car carToPred, int k) {

        int japanese=0,american=0,european=0;

        Map<Car, Double> carsDist = new HashMap();

        for(Car car : cars){
            carsDist.put(
                    car,
                    Math.sqrt(Math.pow(car.getMgp()-carToPred.getMgp(),2)+
                            Math.pow(car.getDisplacement()-carToPred.getDisplacement(),2)+
                            Math.pow(car.getHorsePower()-carToPred.getHorsePower(),2)+
                            Math.pow(car.getWeight()-carToPred.getWeight(),2)+
                            Math.pow(car.getAcceleration()-carToPred.getAcceleration(),2))
            );
        }

        List<Map.Entry<Car, Double>> sortedList = carsDist.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        for(int i=0; i<k; i++){
            if(sortedList.get(i).getKey().getOrigin().equals("japanese")){
                japanese++;
            } else if (sortedList.get(i).getKey().getOrigin().equals("european")) {
                european++;
            }else{
                american++;
            }
        }

        if(japanese>american && japanese>european){
            return "Your car is Japanese";
        } else if (european>american && european>japanese){
            return "Your car is European";
        }else{
            return "Your car is American";
        }
    }

}
