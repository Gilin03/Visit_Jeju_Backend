package com.backend.jejutour_server.service;

import com.backend.jejutour_server.entity.ResEntity;
import com.backend.jejutour_server.repository.ResRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResServiceImpl implements ResService{

    @Autowired
    private ResRepository resRepository;
    @Override
    public List<ResEntity> getAllResList() {
        List<ResEntity> resList = resRepository.findAll();
        for (int i = 1; i < resList.size(); i++) {

            System.out.println("Service res facltNm: " + resList.get(i));
        }
        return resList;
    }

    @Override
    public List<ResEntity> getitemsRegion2CdValueResList(String itemsRegion2CdValue) {
        List<ResEntity> resList = resRepository.findByitemsRegion2CdValue(itemsRegion2CdValue);
        for (int i = 1; i < resList.size(); i++) {
            System.out.println("Service res facltNm: " + resList.get(i));
        }
        return resList;
    }
}
