package com.br.sistemasdistribuidos;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.br.sistemasdistribuidos.resource.ListTaskResource;
import com.br.sistemasdistribuidos.resource.TaskResource;
import com.br.sistemasdistribuidos.utils.Util;

/**
 * Hello world!
 *
 */
public class App {
    
	public static final String LIST_URL = "http://localhost:9393/api/lists";
	public static final String TASK_URL = "http://localhost:9393/api/tasks";
	public static Client client = ClientBuilder.newClient();
	
	public static void main( String[] args ){
    		
    		Scanner scan = new Scanner(System.in);
    		int option = 10;
    		
    		while(option != 0) {
    			Util.buildMenu();
    			option = scan.nextInt();
    			optionRender(option);
    		}
    		
    }

	private static void optionRender(int option) {
		switch (option) {
		case 0:
			System.out.println("Terminou");
			System.exit(1);
			break;
		case 1:
			Util.showListTask();
			break;
		case 21:
			ListTaskResource.insertListTaskForm();
			break;
		case 22:
			ListTaskResource.deleteListTaskForm();
			break;
		case 31:
			TaskResource.insertTaskForm();
			break;
		case 32:
			TaskResource.deleteTaskForm();
			break;
		default:
			break;
		}
	}
	
	
}




















