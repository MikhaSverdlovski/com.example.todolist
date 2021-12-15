package com.example.todolist.repos;

import com.example.todolist.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message,Long> {

    List<Message> findByTag (String tag);
    List<Message> findByText (String text);
}
