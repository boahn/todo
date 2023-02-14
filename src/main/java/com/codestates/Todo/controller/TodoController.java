package com.codestates.Todo.controller;

import com.codestates.Todo.dto.TodoPatchDto;
import com.codestates.Todo.dto.TodoPostDto;
import com.codestates.Todo.dto.TodoResponseDto;
import com.codestates.Todo.entity.Todo;
import com.codestates.Todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> create(@RequestBody TodoPostDto todoPostDto) {
        System.out.println("Created");

        if (ObjectUtils.isEmpty(todoPostDto.getTitle()))
            return ResponseEntity.badRequest().build();

        if (ObjectUtils.isEmpty(todoPostDto.getTodo_order()))
            todoPostDto.setTodo_order(0L);

        if (ObjectUtils.isEmpty(todoPostDto.getCompleted()))
            todoPostDto.setCompleted(false);

        Todo result = this.todoService.createTodo(todoPostDto);
        return ResponseEntity.ok(new TodoResponseDto(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponseDto> readOne(@PathVariable Long id) {
        System.out.println("Read One");
        Todo result = this.todoService.readTodo(id);

        return ResponseEntity.ok(new TodoResponseDto(result));
    }

    @GetMapping
    public String hello() {
        return "To-do Application !";
    }

    public ResponseEntity<List<TodoResponseDto>> readAll() {
        System.out.println("Read All");
        List<Todo> list = this.todoService.readAllTodo();

        List<TodoResponseDto> responseDtos = list.stream().map(TodoResponseDto::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDtos);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id,
                                       @RequestBody TodoPatchDto todoPatchDto) {
        System.out.println("Updated");
        Todo result = this.todoService.updateTodo(id, todoPatchDto);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        System.out.println("Deleted One");
        this.todoService.deleteTodo(id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        System.out.println("Deleted All");
        this.todoService.deleteAllTodo();

        return ResponseEntity.ok().build();
    }
}
