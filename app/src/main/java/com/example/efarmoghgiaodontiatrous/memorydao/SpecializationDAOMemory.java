package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.SpecializationDAO;
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
        ArrayList<Specialization> result = new ArrayList<>();
        result.addAll(entities);
        return result;
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
}