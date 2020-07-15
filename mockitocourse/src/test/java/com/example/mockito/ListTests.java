package com.example.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class ListTests {

	@Test
	public void letsMockListSizeMethod() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void lestMockListGetMethod() {
		List listMock = mock(List.class);
		//Argument matcher
		when(listMock.get(anyInt())).thenReturn("example");
		assertEquals("example", listMock.get(0));
		assertEquals("example", listMock.get(1));
		
	}
	
	@Test(expected = RuntimeException.class)
	public void lestMockListGetMethodThrowsException() {
		List listMock = mock(List.class);
		//Argument matcher
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));
		listMock.get(0);
		
	}
	
	@Test
	public void lestMockListGetMethodBDD() {
		//Given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("example");
		
		//When
		String element = listMock.get(0);
		
		//Then
		assertThat(element, is("example"));
		
	}

}
