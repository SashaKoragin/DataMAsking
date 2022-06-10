package com.example.DataMasking.Repository;

import lombok.SneakyThrows;
import org.jooq.codegen.GenerationTool;
import org.jooq.codegen.Generator;
import org.jooq.meta.Database;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Target;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

public class Context implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${jooq.generator.database.name}")
    private String databaseName;

    @Value("${jooq.generator.database.with-includes}")
    private String databaseWithIncludes;

    @Value("${jooq.generator.database.with-input-schema}")
    private String databaseWithInputSchema;

    @Value("${jooq.generator.target.package-name}")
    private String targetPackageName;

    @Value("${jooq.generator.target.directory}")
    private String targetDirectory;

    @SneakyThrows
    @Override
    ///Вот сдесь вторая ошибка не собирается хотя как по инструции https://www.jooq.org/doc/latest/manual/code-generation/codegen-gradle/
    ///и сдесь https://habr.com/ru/post/488522/
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new GenerationTool().run( new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver(driver)
                        .withUrl(url)
                        .withUser(username)
                        .withPassword(password))
                .withGenerator(new Generator()
                        .withDatabase(new Database().withName(databaseName)
                                .withIncludes(databaseWithIncludes)
                                .withExcludes("")
                                .withInputSchema(databaseWithInputSchema))
                        .withTarget(new Target()
                                .withPackageName(targetPackageName)
                                .withDirectory(targetDirectory))));
    }


}