package io.gdiazs.tasklist.services;

import java.util.List;

import io.gdiazs.tasklist.exceptions.TaskException;
import io.gdiazs.tasklist.models.TaskModel;

/**
 * TaskService Interface 
 */
public interface TaskService {

    List<TaskModel> findAllTasks() throws TaskException;

    void insertTask(TaskModel taskModel) throws TaskException;

    TaskModel findOneTaskModel(String idTask) throws TaskException;

    void deleteTask(String idTask) throws TaskException;




}