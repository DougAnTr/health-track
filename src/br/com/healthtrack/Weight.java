package br.com.healthtrack;

import br.com.healthtrack.interfaces.Data;
import br.com.healthtrack.models.WeightModel;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Weight
 * @author Grupo_C
 * @version 1.0
 */
public class Weight implements Data<Weight> {
    /**
     * Model de peso
     */
    private WeightModel weightModel;

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
     * @param model instância de WeightModel
     */
    public Weight(User user, WeightModel model) {
        this.weightModel = model;
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

    /**
     * Registra um novo peso
     * @param weight valor do peso
     * @param userId identificador do usuário
     * @return Weight
     */
    public Weight register(double weight, int userId) {
        Weight weight1 = null;
        User user1 = null;

        int id = new Random().nextInt();
        user1 = this.user.getUser(userId);

        if(user1 != null) {
            weight1 = new Weight(id, weight, userId);
            this.weightModel.add(weight1);
        }

        return weight1;
    }

    /**
     * Edita um peso específico
     * @param id identificador do peso
     * @param weight peso em quilogramas
     * @return boolean
     */
    public boolean edit(int id, double weight) {
        Weight weight1 = this.weightModel.getById(id);

        weight1.setWeight(weight);

        return true;
    }

    /**
     * Retorna uma lista de pesos
     * @return weights
     */
    public List<Weight> list() {
        return this.weightModel.list();
    }

    /**
     * Retorna um peso
     * @param id identificador do peso
     * @return Weight
     */
    public Weight get(int id) {
        return this.weightModel.getById(id);
    }

    /**
     * Deleta um peso
     * @param id identificador do peso
     * @return boolean
     */
    public boolean delete(int id) {
        this.weightModel.delete(id);

        return true;
    }

    /**
     * Retorna o último peso registrado
     * @return Weight
     */
    public Weight getLastRegister() {
        return this.weightModel.lastItem();
    }
}
