package ru.hogwarts.schooltasktwo.api;

import ru.hogwarts.schooltasktwo.exception.BadRequestException;
import ru.hogwarts.schooltasktwo.model.Faculty;

import java.util.List;

public interface IFaculty {

    Faculty createFaculty(Faculty faculty);

    Faculty editFaculty(Faculty faculty);

    Faculty findFaculty(Long id);

    void deleteAllFaculty(long id);

    void deleteAllFaculty(Faculty faculty);

    List<Faculty> showAllFaculty();

    List<Faculty> findByName(String name);

    List<Faculty> findByColor(String color);

}
