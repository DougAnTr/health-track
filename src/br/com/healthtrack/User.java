package br.com.healthtrack;

import br.com.healthtrack.models.PayingUserModel;
import br.com.healthtrack.models.UserModel;

import java.util.Random;

/**
 * User
 * @author Grupo_C
 * @version 1.0.1
 */
public class User {
    /**
     * Model de usuário
     */
    protected UserModel userModel;

    /**
     * Model de usuário pagante
     */
    private PayingUserModel payingUserModel;

    /**
     * Identificador do usuário
     */
    private int id;

    /**
     * Nome do usuário
     */
    private String name;

    /**
     * E-mail do usuário
     */
    private String email;

    /**
     * Senha do usuário
     */
    private String password;

    public User(UserModel model, PayingUserModel payingUserModel) {
        this.userModel = model;
        this.payingUserModel = payingUserModel;
    }

    public User(UserModel model) {
        this.userModel = model;
    }

    /**
     * Cria um novo usuário
     * @param id identificador do usuário
     * @param name nome do usuário
     * @param email email do usuário
     * @param password senha do usuário
     */
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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
     * @param id identificador do usuário
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name nome do usuário
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email e-mail do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password senha do usuário
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Registra um novo usuário na plataforma
     * @param name nome do usuário
     * @param email e-mail do usuário
     * @param password senha do usuário
     * @return User
     */
    public User register(String name, String email, String password) {
        int id = new Random().nextInt();
        User newUser = new User(id, name, email, password);

        this.userModel.add(newUser);
        return newUser;
    }

    /**
     * Busca um usuário pelo identificador
     * @param id identificador do usuário
     * @return User
     */
    public User getUser(int id) {
        return this.userModel.getById(id);
    }

    /**
     * Assinar um plano
     * @param type tipo do plano
     * @return boolean
     */
    public boolean signUp(User user, String type){
        PayingUser newUser = new PayingUser(user.getId(), user.getName(), user.getEmail(), user.getPassword(), type, 10.5);
        this.payingUserModel.add(newUser);
        return true;
    }
}
