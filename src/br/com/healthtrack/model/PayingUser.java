package br.com.healthtrack.model;

/**
 * PayingUser
 * @author Grupo_C
 * @version 1.0
 */
public class PayingUser  extends User {
    /**
     * Tipo de assinatura
     */
    private String type;

    /**
     * Valor da assinatura
     */
    private Double value;

    public PayingUser(int id, String name, String email, String password, String type, Double value) {
        super(id, name, email, password);

        this.type = type;
        this.value = value;
    }
}
