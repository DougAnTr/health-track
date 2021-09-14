package br.com.healthtrack.models;

import br.com.healthtrack.User;
import br.com.healthtrack.interfaces.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Simula interações com o banco
 * @author Grupo_C
 * @version 1.0
 */
public class UserModel implements Model<User> {
    /**
     * Lista de usuários
     */
    private final List<User> users = new ArrayList<User>();

    /**
     * Adiciona um novo usuário na lista
     * @param user usuário a ser registrado
     */
    public void add(User user) {
        this.users.add(user);
    }

    /**
     * Busca um usuário pelo identificador
     * @param id identificador do usuário
     * @return User | null
     */
    public User getById(int id) {
        User foundUser = null;

        for(User user : this.users) {
            if(user.getId() == id) {
                foundUser = user;
                break;
            }
        }

        return foundUser;
    }

    /**
     * Retorna a lista de usuários
     * @return users
     */
    public List<User> list() {
        return this.users;
    }

    /**
     *
     * @param id identificador do usuário
     */
    public void delete(int id) {
        User user = this.getById(id);

        this.users.remove(user);
    }

    /**
     *
     * @return int
     */
    public User lastItem() {
        int lastIndex = this.users.size() - 1;

        return this.users.get(lastIndex);
    }
}
