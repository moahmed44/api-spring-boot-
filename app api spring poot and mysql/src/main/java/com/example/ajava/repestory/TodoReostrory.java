package com.example.ajava.repestory;

import com.example.ajava.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoReostrory extends JpaRepository<Todo,Long> {
}
