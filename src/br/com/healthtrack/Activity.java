package br.com.healthtrack;

import br.com.healthtrack.interfaces.Data;
import br.com.healthtrack.models.ActivityModel;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Activity
 * @author Douglas Trofino e Gabriela
 * @version 1.1
 */
public class Activity implements Data {

    /**
     * Instância de ActivityModel
     */
    private ActivityModel activityModel;

    /**
     * Instância de User
     */
    private User user;

    /**
     * Identificador da atividade
     */
    private int id;

    /**
     * Descrição da atividade realizada
     */
    private String description;

    /**
     * Duração da atividade em milisegundos
     */
    private long time;

    /**
     * Id do usuário que realizou a atividade
     */
    private int userId;

    /**
     * Data da realização da atividade
     */
    private Date date;
    
    /**
     * Distancia da atividade
     */
    private float distance;
    
    /**
     * Tempo médio
     */
     private float mediaTime;
    

    public Activity(User user, ActivityModel activityModel) {
        this.user = user;
        this.activityModel = activityModel;
    }

    /**
     * Cria uma nova atividade
     * @param id identificador da atividade
     * @param description descrição da atividade
     * @param time tempo de duração da atividade em milisegundos
     * @param userId identificador do usuário que realizou a atividade
     * @param distance distancia percorrida
     * @param mediaTime velocidade média
     */
    public Activity(int id, String description, long time, int userId, float distance, float mediaTime) {
        this.id = id;
        this.description = description;
        this.time = time;
        this.userId = userId;
        this.distance = distance;
        this.mediaTime = mediaTime;
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
    public long getTime() {
        return time;
    }

    /**
     *
     * @param time tempo de duração da atividade em milisegundos
     */
    public void setTime(long time) {
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

   /**
     *
     * @return distance
     */
    public float getDistance()){
        return distance;
    }

    /**
     *
     * @param distance distancia percorrida durante a realização da atividade em metros
     */
    public void setDistance(float distance){
        this.distance=distance;
    }

    /**
     *
     * @return mediaTime - velcidade média percorrida
     */
    public float setMediatime(){
        mediaTime = getTime()/getDistance();

        return mediaTime;
    }

    /**
     * Registra uma nova atividade
     * @param description descrição da atividade
     * @param time duração da atividade em milisegundos
     * @param userId identificador do usuário que realizou a atividade
     * @param distance distancia percorrida
     * @param mediaTime velocidade da atividade
     * @return Activity
     */
    public Activity register(String description, long time, int userId, float distance, float mediaTime) {
        Activity activity1 = null;
        User user1 = null;

        int id = new Random().nextInt();
        user1 = this.user.getUser(userId);

        if(user1 != null) {
            activity1 = new Activity(id, description, time, userId, distance, mediaTime);
            this.activityModel.add(activity1);
        }

        return activity1;
    }

    /**
     * Edita uma atividade específico
     * @param id identificador da atividade a ser editada
     * @param description descrição da atividade
     * @param time duração da atividade em milisegundos
     * @return boolean
     */
    public boolean edit(int id, String description, long time, float distance, float mediaTime) {
        Activity activity1 = this.activityModel.getById(id);

        activity1.setDescription(description);
        activity1.setTime(time);
        activity1.setDistance(distance);
        activity1.setMediaTime(mediaTime);

        return true;
    }

    /**
     * Retorna uma lista de pesos
     * @return activities
     */
    public List<Activity> list() {
        return this.activityModel.list();
    }

    /**
     * Retorna um peso
     * @param id identificador da atividade
     * @return Activity
     */
    public Activity get(int id) {
        return this.activityModel.getById(id);
    }

    /**
     * Deleta um peso
     * @param id identificador da atividade a ser excluída
     * @return boolean
     */
    public boolean delete(int id) {
        this.activityModel.delete(id);

        return true;
    }

    /**
     * Retorna o último peso registrado
     * @return Activity
     */
    public Activity getLastRegister() {
        return this.activityModel.lastItem();
    }
}

public class Run extends Activity {
    /**
     *
     * @param calories gasto calorico
     */
    private int calories;

    /**
     *
     * @return colorias
     */
    public float setCalories(){
        calories=16.0*(getTime()/3600);
        return calories;
    }    
}

public class Swin extends Activity {
    /**
     *
     * @param calories gasto calorico
     */
    private int calories;

    /**
     *
     * @return colorias
     */
    public float setCalories(){
        calories=10.0*(getTime()/3600);
        return calories;
    }    
}

public class Bike extends Activity {
    /**
     *
     * @param calories gasto calorico
     */
    private int calories;

    /**
     *
     * @return colorias
     */
    public float setCalories(){
        calories=12.0*(getTime()/3600);
        return calories;
    }    
}

public class Gym extends Activity {
    /**
     *
     * @param calories gasto calorico
     */
    private int calories;

    /**
     *
     * @return colorias
     */
    public float setCalories(){
        calories=8.6*(getTime()/3600);
        return calories;
    }    
}

