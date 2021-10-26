package br.com.healthtrack.view;

import br.com.healthtrack.dao.FoodDao;
import br.com.healthtrack.model.Food;

public class FoodTest {
    public static void main(String[] args) {
        FoodDao foodDao = new FoodDao();

        Food f1 = new Food("Pão", 200, 3);
        Food f2 = new Food("Banana", 50, 3);
        Food f3 = new Food("Café com açúcar", 100, 3);
        Food f4 = new Food("Vitamina de abacate", 200, 3);
        Food f5 = new Food("Pão", 200, 3);

        foodDao.create(f1);
        foodDao.create(f2);
        foodDao.create(f3);
        foodDao.create(f4);
        foodDao.create(f5);

        for(Food f: foodDao.getAll()){
            System.out.println(f.toString());
        }
    }
}