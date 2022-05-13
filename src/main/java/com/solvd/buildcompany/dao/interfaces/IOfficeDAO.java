package com.solvd.buildcompany.dao.interfaces;

import com.solvd.buildcompany.entity.Office;

import java.util.List;

public interface IOfficeDAO extends IBaseDAO<Office> {

    List<Office> getOfficesByCity(String city);
}
