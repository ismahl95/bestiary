package com.bestiary.bestiary.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestiary.bestiary.dao.BeastDao;
import com.bestiary.bestiary.entity.Beast;

import jakarta.annotation.PostConstruct;

@Service
public class QueryBeastServiceImpl implements QueryBeastService {

  private Predicate<Beast> predicate;

  @Autowired
  BeastDao dao;

  @PostConstruct
  public void init() {
    predicate = null;
  }

  @Override
  public Collection<Beast> exec() {

    return dao.findAll()
        .stream()
        .filter(predicate)
        .collect(Collectors.toList());

  }

  @Override
  public QueryBeastService anyName(String name) {
    Predicate<Beast> bNameContains = (Beast -> Beast.getNombre().toLowerCase().contains(name.toLowerCase()));
    predicate = (predicate == null) ? bNameContains : predicate.and(bNameContains);

    return this;
  }

  @Override
  public QueryBeastService type(String... type) {
    Predicate<Beast> bTypeContains = (beast -> Arrays.stream(type).allMatch(beast.getTipo()::contains));
    predicate = (predicate == null) ? bTypeContains : predicate.and(bTypeContains);

    return this;
  }

  @Override
  public QueryBeastService location(String... location) {
    Predicate<Beast> bLocationContains = (beast -> Arrays.stream(location).allMatch(beast.getUbicación()::contains));
    predicate = (predicate == null) ? bLocationContains : predicate.and(bLocationContains);

    return this;
  }

  @Override
  public QueryBeastService level(int level) {
    Predicate<Beast> bLevelEquals = (beast -> beast.getNivel() == level);
    predicate = (predicate == null) ? bLevelEquals : predicate.and(bLevelEquals);

    return this;
  }

  @Override
  public QueryBeastService strength(String... strength) {
    Predicate<Beast> bStrengthContains = (beast -> Arrays.stream(strength).allMatch(beast.getResistencias()::contains));
    predicate = (predicate == null) ? bStrengthContains : predicate.and(bStrengthContains);

    return this;
  }

  @Override
  public QueryBeastService weakness(String... weakness) {
    Predicate<Beast> bWeaknessContains = (beast -> Arrays.stream(weakness).allMatch(beast.getDebilidades()::contains));
    predicate = (predicate == null) ? bWeaknessContains : predicate.and(bWeaknessContains);

    return this;
  }

}
