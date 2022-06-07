package com.maslov.homeworkboot.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "quiz")
@Getter
public class QuizConfiguration {
    @Value("${csv.path.en}")
    String csvPathEn;
    @Value("${csv.path.ru}")
    String csvPathRu;
    @Value("${language}")
    String language;
}
