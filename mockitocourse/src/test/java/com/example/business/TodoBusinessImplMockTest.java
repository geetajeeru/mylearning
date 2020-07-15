package com.example.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.example.data.api.TodoService;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn Springboot");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filetredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(3, filetredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_EmptyList() {
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		List<String> filetredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filetredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMockBDD() {
		//Given
		
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn Springboot");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		List<String> filetredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		//Then
		assertThat(filetredTodos.size(), is(3));
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpringBDD() {
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then
		verify(todoServiceMock).deleteTodo("Learn to Dance");
		verify(todoServiceMock, never()).deleteTodo("Learn Spring");
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpringBDD_ArgumentCapturing() {
		//Declare Argument captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		//Define argument captor on specific method call
		
		//capture the argument
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring", "Learn Spring MVC", "Learn to Dance");
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		
		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then
		//Argument capturing
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
	}
}
