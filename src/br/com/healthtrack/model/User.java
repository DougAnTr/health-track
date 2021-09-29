package br.com.healthtrack.model;

import java.util.Random;

/**
 * User
 * @author Grupo_C
 * @version 1.0.1
 */
public class User {
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
}
