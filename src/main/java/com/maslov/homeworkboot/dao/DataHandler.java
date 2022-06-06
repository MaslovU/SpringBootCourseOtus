package com.maslov.homeworkboot.dao;

import com.maslov.homeworkboot.service.ResourceAsStream;
import com.maslov.homeworkboot.service.impl.ResourceAsStreamImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class DataHandler {

    private static String csvPath;
    private Locale locale;
    private String language;
    private static final String DELIMITER = ",";

    public DataHandler(@Value("${csv.path.en}") String csvPathEn,
                       @Value("${csv.path.ru}") String csvPathRu,
                       @Value("${language}") String language) {
        this.language = language;
        defineLocale();
        csvPath = locale.getLanguage().equals("en") ? csvPathEn : csvPathRu;
    }

    public List<String[]> getResourceAsStream() {
        List<String[]> list = new ArrayList();
        ResourceAsStream resourceAsStream = new ResourceAsStreamImpl();

        Scanner scanner = resourceAsStream.getResourceAsStream(csvPath);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(DELIMITER);
            list.add(line);
        }
        return list;
    }

    private void defineLocale() {
         if (language.equals("en")) {
            locale = Locale.ENGLISH;
        } else if (language.isEmpty()) {
            locale = LocaleContextHolder.getLocale();
        }
    }
}
