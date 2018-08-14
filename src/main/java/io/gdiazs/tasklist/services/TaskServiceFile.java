package io.gdiazs.tasklist.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import io.gdiazs.tasklist.exceptions.TaskException;
import io.gdiazs.tasklist.models.TaskModel;

/**
 * TaskServiceFile Implementación concreta de lectura de tareas desde archivo
 */
@Service
public class TaskServiceFile implements TaskService {

	private final Logger logger = LoggerFactory.getLogger(TaskServiceFile.class);

	private List<TaskModel> tasks;

	private final String TASK_FILE = "tasks.txt";

	/** Posición del vector */
	private static int ID_INDEX = 0;

	/** Posición del vector */
	private static int TITLE_INDEX = 1;

	/** Posición del vector */
	private static int DESCRIPTION_INDEX = 2;

	public TaskServiceFile() {
		this.init();
	}

	public void init() {

		this.tasks = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new ClassPathResource(TASK_FILE).getInputStream()))) {

			while (reader.ready()) {
				String line = reader.readLine();
				String[] taskProperties = line.split(",");
				TaskModel taskModel = new TaskModel();

				taskModel.setId(taskProperties[ID_INDEX]);
				taskModel.setTitle(taskProperties[TITLE_INDEX]);
				taskModel.setDescription(taskProperties[DESCRIPTION_INDEX]);
				this.tasks.add(taskModel);
			}

		} catch (IOException e) {
			logger.error("No se pudo cargar el archivo", e);
			e.printStackTrace();
		}

	}

	@Override
	public List<TaskModel> findAllTasks() throws TaskException {
		return this.tasks;
	}

	@Override
	public void insertTask(TaskModel taskModel) throws TaskException {
		taskModel.setId(System.currentTimeMillis() + "");
		this.tasks.add(taskModel);
		this.logger.info("Nueva tarea insertada con id: " + taskModel.getId());

	}

	@Override
	public TaskModel findOneTaskModel(String idTask) throws TaskException {
		return this.tasks.stream().filter(task -> task.getId().equals(idTask)).findAny().orElseThrow(() -> {
			return new TaskException("No se encontró el task con el id: " + idTask);
		});

	}

	@Override
	public void deleteTask(String idTask) throws TaskException {
		final Optional<TaskModel> taskModel = this.tasks.stream().filter(task -> task.getId().equals(idTask)).findAny();
		if (taskModel.isPresent()) {
			this.tasks.remove(taskModel.get());
			this.logger.info("Tarea eliminada con id: " + taskModel.get().getId());

		} else {
			throw new TaskException("No se encontró la tarea con id: " + idTask);
		}

	}

}