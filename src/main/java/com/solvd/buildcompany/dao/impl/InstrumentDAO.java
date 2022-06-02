package com.solvd.buildcompany.dao.impl;

import com.solvd.buildcompany.dao.interfaces.IInstrumentDAO;
import com.solvd.buildcompany.entity.Instrument;
import org.springframework.stereotype.Repository;

@Repository
public class InstrumentDAO extends BaseDAO<Instrument> implements IInstrumentDAO {

    public InstrumentDAO() {
        super(Instrument.class);
    }
}
