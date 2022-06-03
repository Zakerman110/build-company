package com.solvd.buildcompany.mapper;

import com.solvd.buildcompany.entity.Office;

import java.util.List;

public interface OfficeMapper {

    Office getOfficeById(Integer id);

    List getOffice();
}
