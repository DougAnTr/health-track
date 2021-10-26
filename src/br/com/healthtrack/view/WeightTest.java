package br.com.healthtrack.view;

import br.com.healthtrack.dao.FoodDao;
import br.com.healthtrack.dao.WeightDao;
import br.com.healthtrack.model.Food;
import br.com.healthtrack.model.Weight;

public class WeightTest {
    public static void main(String[] args) {
        WeightDao weightDao = new WeightDao();

        Weight w1 = new Weight(64.5, 3);
        Weight w2 = new Weight(66, 3);
        Weight w3 = new Weight(67.8, 3);
        Weight w4 = new Weight(70, 3);
        Weight w5 = new Weight(69.2, 3);

        weightDao.create(w1);
        weightDao.create(w2);
        weightDao.create(w3);
        weightDao.create(w4);
        weightDao.create(w5);

        for(Weight weight: weightDao.getAll()){
            System.out.println(weight.toString());
        }
    }
}
