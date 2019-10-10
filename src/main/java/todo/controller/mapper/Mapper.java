package todo.controller.mapper;

import todo.entity.ToDoEntity;
import todo.model.Category;
import todo.model.ToDoModel;
import todo.service.IdGenerationService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

public class Mapper {

    public static final String No = "N";

    public static ToDoModel map (HttpServletRequest req){
        return ToDoModel.builder()
                .name(req.getParameter("title"))
                .category(Category.valueOf(req.getParameter("category")))
                .deadline(LocalDateTime.parse(req.getParameter("deadline")))
                .description(req.getParameter("desc"))
                .build();
    }

    public static ToDoEntity mapToEntity(String login, ToDoModel toDoModel){
        return ToDoEntity.builder()
                .id(IdGenerationService.generateId())
                .name(toDoModel.getName())
                .category(toDoModel.getCategory().toString())
                .userLogin(login)
                .creationDate(LocalDateTime.now())
                .deadline(toDoModel.getDeadline())
                .description(toDoModel.getDescription())
                .done(No)
                .build();
    }
}
