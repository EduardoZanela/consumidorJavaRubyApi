package com.br.sistemasdistribuidos.utils;

import java.util.List;
import java.util.Scanner;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.br.sistemasdistribuidos.App;
import com.br.sistemasdistribuidos.model.Task;
import com.br.sistemasdistribuidos.model.TaskList;

public class Util {
	
	public static void waitForOption() {
		System.out.println("\nPress enter to continue");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
	}

	public static void buildMenu() {
		System.out.println("1 - Mostar Tarefas");
		System.out.println("  - Opções da Lista Tarefa");
		System.out.println("\t21 - Inserir uma lista");
		System.out.println("\t22 - Deletar lista");
		System.out.println("  - Opções da Tarefa");
		System.out.println("\t31 - Inserir tarefa");
		System.out.println("\t32 - Deletar tarefa");
		System.out.println("0 - Sair");
		System.out.print("\nDigite a sua opção: ");
	}
	
	public static void showListTask() {
		List<TaskList> taskListRequest = App.client.target(App.LIST_URL).request(MediaType.APPLICATION_JSON).get(new GenericType<List<TaskList>>(){});
		System.out.println("\n\n################## Sua Lista de Tarefas #######################\n\n");
		for(TaskList taskList: taskListRequest) {
			System.out.println(taskList.getId()+" - "+taskList.getName());
			for(Task task : taskList.getTasks()) {
				System.out.println("\t " + task.getId() + " - " + task.getName());
			}
			System.out.println("\n");
		}
		waitForOption();
	}
}
