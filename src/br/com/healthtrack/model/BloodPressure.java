package br.com.healthtrack.model;

import java.util.Date;

public class BloodPressure {
    /**
     * Identificação da medição da pressão
     */
    private int id;

    /**
     * Pressão Sistólica
     */
    private int systolic;

    /**
     * Pressão Diastólica
     */
    private int diastolic;

    /**
     * Classificação
     */
    private String classification;

    /**
     * Data da medição
     */
    private Date date;

    /**
     * Id do usuário que registrou
     */
    private int userId;

    public BloodPressure(int systolic, int diastolic, String classification, int userId) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.classification = classification;
        this.date = new Date();
        this.userId = userId;
    }

    public BloodPressure(int id, int systolic, int diastolic, String classification, Date date, int userId) {
        this.id = id;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.classification = classification;
        this.date = date;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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
        return "BloodPressure{" +
                "id=" + id +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                ", classification='" + classification + '\'' +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }
}
