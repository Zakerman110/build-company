package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.ICrewDAO;
import com.solvd.buildcompany.entity.Crew;
import org.springframework.stereotype.Repository;

@Repository
public class CrewDAO extends BaseDAO<Crew> implements ICrewDAO {

    public CrewDAO() {
        super(Crew.class);
    }
}
