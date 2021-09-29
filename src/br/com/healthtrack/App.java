package br.com.healthtrack;

import br.com.healthtrack.dao.ActivityDao;
import br.com.healthtrack.model.Activity;

public class App {
    public static void main(String[] args) {
        ActivityDao activityDao = new ActivityDao();

        for (Activity activity : activityDao.getAll()) {
            System.out.println(activity.toString());
        }
    }
}
