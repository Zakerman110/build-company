package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.ITaskDAO;
import com.solvd.buildcompany.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDAO extends BaseDAO<Task> implements ITaskDAO {

    public TaskDAO() {
        super(Task.class);
    }
}
