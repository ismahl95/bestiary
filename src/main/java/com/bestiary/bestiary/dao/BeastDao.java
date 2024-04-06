package com.bestiary.bestiary.dao;

import java.util.Collection;

import com.bestiary.bestiary.entity.Beast;

public interface BeastDao {
    
    public Beast findByName(String name);
    public Collection<Beast> findAll();
    public void insert(Beast beast);
    /* public void update(Beast beast); */
    public void delete(Beast beast);
}
