package com.example.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn Springboot");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
