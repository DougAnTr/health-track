package br.com.healthtrack.interfaces;

import java.util.List;

public interface Data<E> {
    public List<E> list();

    public E get(int id);

    public boolean delete(int id);

    public E getLastRegister();
}
