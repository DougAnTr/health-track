package br.com.healthtrack.model;

import java.util.Date;

public class Food {
    /**
     * Identificação do alimento
     */
    private int id;

    /**
     * Descrição do alimento
     */
    private String description;

    /**
     * Quantidade de calorias
     */
    private int calories;

    /**
     * Data de registro
     */
    private Date date;

    /**
     * id do usuário
     */
    private int userId;

    public Food(String description, int calories, int userId) {
        this.description = description;
        this.calories = calories;
        this.date = new Date();
        this.userId = userId;
    }

    public Food(int id, String description, int calories, Date date, int userId) {
        this.id = id;
        this.description = description;
        this.calories = calories;
        this.date = date;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }
}
