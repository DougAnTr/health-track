package br.com.healthtrack.models;

import br.com.healthtrack.Activity;
import br.com.healthtrack.interfaces.Model;

import java.util.ArrayList;
import java.util.List;

public class ActivityModel implements Model<Activity> {
    /**
     * Lista de pesos
     */
    private final List<Activity> activities = new ArrayList<Activity>();

    /**
     * Adiciona um novo peso na lista
     * @param activity atividade a ser adicionada
     */
    public void add(Activity activity) {
        this.activities.add(activity);
    }

    /**
     * Busca um peso pelo identificador
     * @param id identificador da atividade
     * @return User | null
     */
    public Activity getById(int id) {
        Activity foundActivity = null;

        for(Activity activity : this.activities) {
            if(activity.getId() == id) {
                foundActivity = activity;
                break;
            }
        }

        return foundActivity;
    }

    /**
     * Retorna a lista de pesos
     * @return activities
     */
    public List<Activity> list() {
        return this.activities;
    }

    /**
     * Exclui um peso
     * @param id identificador da atividade
     */
    public void delete(int id) {
        Activity activity = this.getById(id);

        this.activities.remove(activity);
    }

    /**
     * Retorna o último peso registrado
     * @return Activity
     */
    public Activity lastItem() {
        int lastIndex = this.activities.size() - 1;

        return this.activities.get(lastIndex);
    }

    /**
     * Retorna a quantidade de atividades adicionadas
     * @return int
     */
    public int getSize(){
        return this.activities.size();
    }
}
