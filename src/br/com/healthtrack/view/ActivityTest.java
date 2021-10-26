package br.com.healthtrack.view;

import br.com.healthtrack.dao.ActivityDao;
import br.com.healthtrack.model.Activity;

public class ActivityTest {
    public static void main(String[] args) {
        ActivityDao activityDao = new ActivityDao();

        Activity act1 = new Activity("Corrida", 2, 3);
        Activity act2 = new Activity("Natação", 1, 3);
        Activity act3 = new Activity("Ciclismo", 2, 3);
        Activity act4 = new Activity("Mergulho", 1, 3);
        Activity act5 = new Activity("Corrida", 2, 3);

        activityDao.create(act1);
        activityDao.create(act2);
        activityDao.create(act3);
        activityDao.create(act4);
        activityDao.create(act5);

        for(Activity a: activityDao.getAll()){
            System.out.println(a.toString());
        }
    }
}
