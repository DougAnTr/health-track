package br.com.healthtrack.model;

import java.util.Date;
import java.util.Random;

/**
 * Weight
 * @author Grupo_C
 * @version 1.0
 */
public class Weight {
    /**
     * Identificador do peso
     */
    private int id;

    /**
     * Peso
     */
    private double weight;

    /**
     * Identificador do usuário que registrou o peso
     */
    private int userId;

    /**
     * Data de registro do peso
     */
    private Date date;

    /**
     * Instância de um usuário
     */
    private User user;

    /**
     *
     * @param user instância de User
     */
    public Weight(User user) {
        this.user = user;
    }

    /**
     * Cria um novo peso
     * @param id identificador do peso
     * @param weight peso em quilogramas
     * @param userId identificador do usuário que registrou o peso
     */
    public Weight(int id, double weight, int userId) {
        this.id = id;
        this.weight = weight;
        this.userId = userId;
        this.date = new Date();
    }

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id identificador do peso
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     *
     * @param weight peso em quilogramas
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     *
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId identificador do usuário que registrou o peso
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date data do registro
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
