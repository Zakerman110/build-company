package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IInstrumentUsageDAO;
import com.solvd.buildcompany.entity.InstrumentUsage;
import org.springframework.stereotype.Repository;

@Repository
public class InstrumentUsageDAO extends BaseDAO<InstrumentUsage> implements IInstrumentUsageDAO {

    public InstrumentUsageDAO() {
        super(InstrumentUsage.class);
    }
}
