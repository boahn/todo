package com.codestates.Todo.dto;

import com.codestates.Todo.entity.Todo;

public class TodoResponseDto {
    private Long id;

    private String title;

    private Long todo_order;

    private Boolean completed;

    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.todo_order = todo.getTodo_order();
        this.completed = todo.getCompleted();
    }
}
