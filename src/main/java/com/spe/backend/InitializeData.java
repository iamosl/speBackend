package com.spe.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class InitializeData {
    @Autowired
    private DataSource dataSource;

    @EventListener(ApplicationReadyEvent.class)
    public void loadData(){
//            InputStream inputStream = getClass().getResourceAsStream("/insertSkills.sql");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String contents = reader.lines()
//                    .collect(Collectors.joining(System.lineSeparator()));
            ResourceDatabasePopulator resourceDatabasePopulator =
                    new ResourceDatabasePopulator(false,
                            false, "UTF-8",
                            new ClassPathResource("/insertSkills.sql"));
            resourceDatabasePopulator.execute(dataSource);
    }
}
