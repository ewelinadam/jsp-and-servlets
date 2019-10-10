package todo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ToDoEntity {
    private long id;

    private String userLogin;

    private String name;

    private String category;

    private String description;

    private LocalDateTime creationDate;

    private LocalDateTime deadline;

    private String done;
}
