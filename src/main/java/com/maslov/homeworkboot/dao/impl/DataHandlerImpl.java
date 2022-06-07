package com.maslov.homeworkboot.dao.impl;

import com.maslov.homeworkboot.config.QuizConfiguration;
import com.maslov.homeworkboot.dao.DataHandle;
import com.maslov.homeworkboot.service.ResourceAsStream;
import com.maslov.homeworkboot.service.impl.ResourceAsStreamImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class DataHandlerImpl implements DataHandle {

    private final QuizConfiguration configuration;
    private Locale locale;
    private static final String DELIMITER = ",";
    private static final String EN_LANGUAGE = "en";

    public List<String[]> getResourceAsStream() {
        String csvPathEn = configuration.getCsvPathEn();
        String csvPathRu = configuration.getCsvPathRu();
        defineLocale();
        String csvPath = locale.getLanguage().equals("en") ? csvPathEn : csvPathRu;
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
        String language = configuration.getLanguage();
         if (language.equals(EN_LANGUAGE)) {
            locale = Locale.ENGLISH;
        } else if (language.isEmpty()) {
            locale = LocaleContextHolder.getLocale();
        }
    }
}
