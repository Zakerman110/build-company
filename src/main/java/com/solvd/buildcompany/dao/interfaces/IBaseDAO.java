package com.solvd.buildcompany.dao.interfaces;

import java.util.List;

public interface IBaseDAO<T> {

    List<T> getEntities();

    T getEntityById(int id);

    void saveEntity(T entity);

    void updateEntity(T entity);

    void deleteEntity(T entity);
}
