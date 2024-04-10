package com.bestiary.bestiary;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;


import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import jakarta.annotation.PostConstruct;

@Component
public class BestiaryHelp {
    
    private String help;

    @PostConstruct
    public void init()
    {
        try {
            help = Files
            .lines(Paths.get(ResourceUtils.getFile("classpath:help.txt").toURI()))
            .collect(Collectors.joining("/n"));
        } catch (Exception e) {
            System.err.println("Error loading help text");
			System.exit(-1);
        }
    }
    public String getHelp()
        {
            return help;
        }
}
