package com.example.ajava.controller;


import com.example.ajava.model.Todo;
import com.example.ajava.repestory.TodoReostrory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin("http://localhost:4200")
@RestController
public class TodoController {

    @Autowired
    TodoReostrory todoReostrory;

    @GetMapping("/findall")
    public List<Todo> ferchAl(){
        return this.todoReostrory.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTodo(@RequestBody Todo todo){
        return  new ResponseEntity<>(this.todoReostrory.save(todo),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delet(@PathVariable Long id){
        if(this.todoReostrory.findById(id).isPresent()){
            this.todoReostrory.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>update(@PathVariable Long id , @RequestBody Todo todo){
        if (this.todoReostrory.findById(id).isPresent()){
            todo.setId(id);
           return new ResponseEntity<>(this.todoReostrory.save(todo),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
