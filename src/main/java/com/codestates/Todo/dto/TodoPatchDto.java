package com.codestates.Todo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoPatchDto {
    private Long id;

    private String title;

    private Long todo_order;

    private Boolean completed;
}
