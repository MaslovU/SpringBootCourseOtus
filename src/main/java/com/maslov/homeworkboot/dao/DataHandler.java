package com.maslov.homeworkboot.dao;

import com.maslov.homeworkboot.service.ResourceAsStream;
import com.maslov.homeworkboot.service.impl.ResourceAsStreamImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class DataHandler {

    private static String csvPath;
    private static final String DELIMITER = ",";

    public DataHandler(@Value("${csv.path}") String csvPath) {
        this.csvPath = csvPath;
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
}
