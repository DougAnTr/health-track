package br.com.healthtrack.models;

import br.com.healthtrack.Weight;
import br.com.healthtrack.interfaces.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Simula interações com o banco
 * @author Grupo_C
 * @version 1.0
 */
public class WeightModel implements Model<Weight> {
    /**
     * Lista de pesos
     */
    private final List<Weight> weights = new ArrayList<Weight>();

    /**
     * Adiciona um novo peso na lista
     * @param weight peso a ser adicionado
     */
    public void add(Weight weight) {
        this.weights.add(weight);
    }

    /**
     * Busca um peso pelo identificador
     * @param id identificador do peso
     * @return User | null
     */
    public Weight getById(int id) {
        Weight foundWeight = null;

        for(Weight weight : this.weights) {
            if(weight.getId() == id) {
                foundWeight = weight;
                break;
            }
        }

        return foundWeight;
    }

    /**
     * Retorna a lista de pesos
     * @return weights
     */
    public List<Weight> list() {
        return this.weights;
    }

    /**
     * Exclui um peso
     * @param id identificador do peso
     */
    public void delete(int id) {
        Weight weight = this.getById(id);

        this.weights.remove(weight);
    }

    /**
     * Retorna o último peso registrado
     * @return Weight
     */
    public Weight lastItem() {
        int lastIndex = this.weights.size() - 1;

        return this.weights.get(lastIndex);
    }

    /**
     *
     * @return int
     */
    public int getSize(){
        return this.weights.size();
    }
}
