package com.example.business;

import java.util.ArrayList;
import java.util.List;

import com.example.data.api.TodoService;

public class TodoBusinessImpl {
	
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodosRelatedToSpring(String user) {
		List<String> filteredTods = new ArrayList<String>();
		List<String> todos = todoService.retrieveTodos(user);
		for(String todo: todos) {
			if(todo.contains("Spring")) {
				filteredTods.add(todo);
			}
		}
		return filteredTods;
	}
	
	public void deleteTodosNotRelatedToSpring(String user) {
		List<String> todos = todoService.retrieveTodos(user);
		for(String todo: todos) {
			if(!todo.contains("Spring")) {
				todoService.deleteTodo(todo);
			}
		}
	}
}