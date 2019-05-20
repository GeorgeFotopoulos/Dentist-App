package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;
import com.example.efarmoghgiaodontiatrous.domain.Visit;

import java.util.ArrayList;
import java.util.List;

public class VisitDAOMemory implements VisitDAO {
    protected static List<Visit> entities = new ArrayList<>();

    @Override
    public void delete(Visit entity) {
        entities.remove(entity);
    }

    @Override
    public List<Visit> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void save(Visit entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public Visit find(String AMKA) {
        for (Visit visit : entities) {
            if (visit.getClient().getAMKA().equals(AMKA)) {
                return visit;
            }
        }
        return null;
    }
}