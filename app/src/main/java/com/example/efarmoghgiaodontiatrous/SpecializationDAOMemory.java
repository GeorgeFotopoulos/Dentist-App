package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Specialization;

import java.util.ArrayList;
import java.util.List;

public class SpecializationDAOMemory implements SpecializationDAO {
    protected static List<Specialization> entities = new ArrayList<>();

    @Override
    public void delete(Specialization entity) {
        entities.remove(entity);
    }

    @Override
    public List<Specialization> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void save(Specialization entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public Specialization find(String specializationId) {
        for (Specialization specialization : entities) {
            if (specialization.getSpecializationID().equals(specializationId)) {
                return specialization;
            }
        }
        return null;
    }

    @Override
    public String nextId() {
        if (entities.size() > 0) {
            return Integer.parseInt(entities.get(entities.size() - 1).getSpecializationID()) + 1 + "";
        } else {
            return 1 + "";
        }
    }
}