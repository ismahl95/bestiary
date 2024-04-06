package com.bestiary.bestiary.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.bestiary.bestiary.entity.Beast;

@Repository
public class BeastDaoImpMemory implements BeastDao {

    public List<Beast> bestias = new ArrayList<>();

    @Override
    public Beast findByName(String name) {
        Optional<Beast> result = bestias
            .stream()
            .filter(b -> b.getNombre() == name)
            .findFirst();
        return result.orElse(null);
    }

    @Override
    public Collection<Beast> findAll() {
        return bestias;
    }

    @Override
    public void insert(Beast beast) {
        bestias.add(beast);
    }

    /* @Override
    public void update(Beast beast) {
        String nombre = beast.getNombre();
        if(nombre.equals(beast.getNombre()))
        {
            bestias.set(nombre, beast);
        }
    } */

    @Override
    public void delete(Beast beast) {
        String nombre = beast.getNombre();
        if(nombre.equals(beast.getNombre()))
        {
            bestias.remove(nombre);
        }
    }
    
    
}
