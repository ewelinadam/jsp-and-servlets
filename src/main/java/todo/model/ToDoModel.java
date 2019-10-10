package todo.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ToDoModel {
    private long id;

//    private String userLogin; nie powinno tu tego być

    private String name;

    private Category category;

    private String description;

    private LocalDateTime creationDate;

    private LocalDateTime deadline;

    private boolean done;
}
