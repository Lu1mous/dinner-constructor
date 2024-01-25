package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menuByTypeDish;
    HashMap<String, ArrayList<String>> dishCombos;
    Random random;
    DinnerConstructor(){
        menuByTypeDish = new HashMap<>();
        random = new Random();
    }

    void addNewDish(String dishType, String dishName){
        if(!checkType(dishType)){
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            menuByTypeDish.put(dishType,dishes);
        }else {
            ArrayList<String> dishes = menuByTypeDish.get(dishType);
            dishes.add(dishName);
        }
    }

    boolean checkType(String currentTypeDish){
        boolean isAlreadyType = false;
        for (String typeDish : menuByTypeDish.keySet()) {
            if(typeDish.equals(currentTypeDish)){
                isAlreadyType = true;
                break;
            }
        }
        return isAlreadyType;
    }

    void generateDishCombo(ArrayList<String> structureDishCombo, int numberOFCombos){
        dishCombos = new HashMap<>();
        for (int i = 0; i < numberOFCombos; i++) {
            ArrayList<String> dishCombo = new ArrayList<>();
            for (String type : structureDishCombo) {
                ArrayList<String> dishesOfCurrentType = menuByTypeDish.get(type);
                int rndIndexDish = random.nextInt(dishesOfCurrentType.size());
                String dish = dishesOfCurrentType.get(rndIndexDish);
                dishCombo.add(dish);
            }
            dishCombos.put("Комбо " + (i + 1), dishCombo);
        }
    }

    void printAllCombos(){
        for (int i = 0; i < dishCombos.size(); i++) {
            String comboName = "Комбо " + (i + 1);
            System.out.println(comboName);
            System.out.println(dishCombos.get(comboName));
        }
    }

}
