package com.bestiary.bestiary.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestiary.bestiary.dao.BeastDao;
import com.bestiary.bestiary.entity.Beast;

@Service
public class BeastService {
  @Autowired
  BeastDao beastDao;

  @Autowired
  QueryBeastService queryService;

  public Collection<String> findAllBeasts() {

    return beastDao.findAll()
        .stream()
        .map(Beast::getNombre)
        .distinct()
        .sorted()
        .collect(Collectors.toList());

  }

  public Collection<Beast> findByName(String name) {
    return queryService.anyName(name).exec();
  }

  public Collection<Beast> findByType(String... type) {
    return queryService.type(type).exec();
  }

  public Collection<Beast> findByLocation(String... location) {
    return queryService.location(location).exec();
  }

  public Collection<Beast> findByLevel(int level) {
    return queryService.level(level).exec();
  }

  public Collection<Beast> findByStrength(String... strength) {
    return queryService.strength(strength).exec();
  }

  public Collection<Beast> findByWeakness(String... weakness) {
    return queryService.weakness(weakness).exec();
  }

}
