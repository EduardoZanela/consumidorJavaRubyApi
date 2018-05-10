package com.br.sistemasdistribuidos.resource;

import java.util.ArrayList;
import java.util.Scanner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.br.sistemasdistribuidos.App;
import com.br.sistemasdistribuidos.model.Task;
import com.br.sistemasdistribuidos.model.TaskList;
import com.br.sistemasdistribuidos.utils.Util;

public class ListTaskResource {
	
	public static void deleteListTaskForm() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o id da Lista: ");
		int id = scan.nextInt();
		App.client.target(App.LIST_URL).path(String.valueOf(id))
				.request(MediaType.APPLICATION_JSON).delete();
		Util.showListTask();
	}

	public static void insertListTaskForm() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Digite o nome da Lista: ");
		String name = scan.nextLine();
		TaskList taskList = new TaskList();
		taskList.setName(name);
		taskList.setTasks(new ArrayList<Task>());
		Response post = App.client.target(App.LIST_URL).request(MediaType.APPLICATION_JSON).post(Entity.entity(taskList, MediaType.APPLICATION_JSON));
		TaskList readEntity = post.readEntity(TaskList.class);
		Util.showListTask();
	}
}
