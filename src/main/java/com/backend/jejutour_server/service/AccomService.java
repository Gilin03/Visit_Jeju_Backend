package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.AccomEntity;

import java.util.List;

public interface AccomService {

    public List<AccomEntity> getAllAccomList();

    public List<AccomEntity> getitemsRegion2CdValueAccomList(String itemsRegion2CdValue);

}