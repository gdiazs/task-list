package io.gdiazs.tasklist.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import io.gdiazs.tasklist.exceptions.TaskException;
import io.gdiazs.tasklist.models.TaskModel;

/**
 * TaskServiceFile
 */
@Service
public class TaskServiceFile implements TaskService{

    private final String TASK_FILE = "tasks.txt";

    public TaskServiceFile(){
        this.init();
    }

    public void init(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource(TASK_FILE).getInputStream()))){

            while(reader.ready()){
                String line = reader.readLine();
                System.out.println(line);
            }

        } catch (IOException e) {
			e.printStackTrace();
		}

    }



	@Override
	public List<TaskModel> findAllTasks() throws TaskException {
		return null;
	}

	@Override
	public List<TaskModel> insertTask(TaskModel taskModel) throws TaskException {
		return null;
	}

	@Override
	public TaskModel findOneTaskModel(String idTask) throws TaskException {
		return null;
	}

	@Override
	public void deleteTask(String idTask) throws TaskException {
		
	}

    
}