package com.br.sistemasdistribuidos.resource;

import java.util.Scanner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.br.sistemasdistribuidos.App;
import com.br.sistemasdistribuidos.model.Task;
import com.br.sistemasdistribuidos.utils.Util;

public class TaskResource {
	
	public static void deleteTaskForm() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o id da tarefa: ");
		int id = scan.nextInt();
		App.client.target(App.TASK_URL).path(String.valueOf(id))
				.request(MediaType.APPLICATION_JSON).delete();
		Util.showListTask();		
	}

	public static void insertTaskForm() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o nome da tarefa: ");
		String name = scan.nextLine();
		Task task = new Task();
		task.setName(name);
		System.out.print("Digite o id da lista que deseja inserir a tarefa: ");
		String idList = scan.next();
		task.setList_id(Integer.parseInt(idList));
		Response post = App.client.target(App.TASK_URL).request(MediaType.APPLICATION_JSON).post(Entity.entity(task, MediaType.APPLICATION_JSON));
		Task readEntity = post.readEntity(Task.class);
		Util.showListTask();	
	}
}
