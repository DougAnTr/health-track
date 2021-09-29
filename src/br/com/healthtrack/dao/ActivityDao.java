package br.com.healthtrack.dao;

import br.com.healthtrack.model.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityDao {
    /**
     * Lista de pesos
     */
    private final List<Activity> activities = new ArrayList<Activity>();

    public List<Activity> getAll() {
        Activity a1 = new Activity(1, "Corrida", 30, 1);
        Activity a2 = new Activity(1, "Corrida", 35, 1);
        Activity a3 = new Activity(1, "Corrida", 40, 1);
        Activity a4 = new Activity(1, "Corrida", 60, 1);
        Activity a5 = new Activity(1, "Corrida", 30, 1);

        this.activities.add(a1);
        this.activities.add(a2);
        this.activities.add(a3);
        this.activities.add(a4);
        this.activities.add(a5);

        return this.activities;
    }
}
