package com.bestiary.bestiary.service;

import java.util.Collection;

import com.bestiary.bestiary.entity.Beast;

public interface QueryBeastService {
    
    public Collection<Beast> exec();
    public QueryBeastService anyName(String name); 
    public QueryBeastService allName(String name);
    public QueryBeastService type(String... type);
    public QueryBeastService location(String... location);
    public QueryBeastService level(int level);
    public QueryBeastService strength (String... strength);
    public QueryBeastService weakness (String... weakness);
}
