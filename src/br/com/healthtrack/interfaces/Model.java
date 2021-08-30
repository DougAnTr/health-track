package br.com.healthtrack.interfaces;

import java.util.List;

public interface Model<E> {
    public void add(E e);

    public E getById(int id);

    public List<E> list();

    public void delete(int id);

    public E lastItem();
}
