package ru.hogwarts.schooltasktwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.webjars.NotFoundException;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class FacultyNotFoundException extends NotFoundException {

    public FacultyNotFoundException(String message) {
        super(message);
    }
}
