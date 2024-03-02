package ru.hogwarts.schooltasktwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FacultyListsIsEmptyException extends NotFoundException{
    public FacultyListsIsEmptyException(String message){
        super(message);
    }
}
