package br.com.healthtrack.model;

import br.com.healthtrack.dao.ActivityDao;

import java.util.Date;

/**
 * Activity
 * @author Grupo_C
 * @version 1.0
 */
public class Activity {
    /**
     * Identificador da atividade
     */
    private int id;

    /**
     * Descrição da atividade realizada
     */
    private String description;

    /**
     * Duração da atividade em minutos
     */
    private int time;

    /**
     * Id do usuário que realizou a atividade
     */
    private int userId;

    /**
     * Data da realização da atividade
     */
    private Date date;

    /**
     * Cria uma nova atividade
     * @param description descrição da atividade
     * @param time tempo de duração da atividade em minutos
     * @param userId identificador do usuário que realizou a tividade
     */
    public Activity(String description, int time, int userId) {
        this.description = description;
        this.time = time;
        this.userId = userId;
        this.date = new Date();
    }

    /**
     * Cria uma nova atividade com id
     * @param id identificação da atividade
     * @param description descrição da atividade
     * @param time tempo de duração da atividade em minutos
     * @param userId identificador do usuário que realizou a tividade
     */
    public Activity(Integer id, String description, int time, int userId, Date date) {
        this.id = id;
        this.description = description;
        this.time = time;
        this.userId = userId;
        this.date = date;
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
     * @param id identificador da atividade
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description descrição da atividade
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return time
     */
    public int getTime() {
        return time;
    }

    /**
     *
     * @param time tempo de duração da atividade em minutos
     */
    public void setTime(int time) {
        this.time = time;
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
     * @param userId identificador do usuário que realizou a tividade
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
     * @param date data da realização da atividade
     */
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", userId=" + userId +
                ", date=" + date +
                '}';
    }
}
