package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.domain.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceDAOMemory implements ServiceDAO {
    protected static List<Service> entities = new ArrayList<>();

    @Override
    public void delete(Service entity) {
        entities.remove(entity);
    }

    @Override
    public List<Service> findAll() {
        ArrayList<Service> result = new ArrayList<>();
        result.addAll(entities);
        return result;
    }

    @Override
    public void save(Service entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public Service find(String serviceId) {
        for (Service service : entities) {
            if (service.getServiceID().equals(serviceId)) {
                return service;
            }
        }
        return null;
    }
}