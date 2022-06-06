package com.maslov.homeworkboot.service;

import java.io.IOException;

public interface Student {
    int getAnswer() throws IOException;

    void setFirstName() throws IOException;

    String getFirstName();

    void setLastName() throws IOException;

    String getLastName();
}
