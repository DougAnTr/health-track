package br.com.healthtrack;

import br.com.healthtrack.models.PayingUserModel;
import br.com.healthtrack.models.UserModel;

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

    public PayingUser(PayingUserModel model) {
        super(model);
    }

    public PayingUser(int id, String name, String email, String password, String type, Double value) {
        super(id, name, email, password);

        this.type = type;
        this.value = value;
    }

    /**
     * Cancelar assinatura
     * @return boolean
     */
    public boolean cancel(Integer id){
        this.userModel.delete(id);
        return true;
    }
}
