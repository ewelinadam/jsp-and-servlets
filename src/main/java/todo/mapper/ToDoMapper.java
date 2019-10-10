package todo.mapper;

import todo.entity.ToDoEntity;
import todo.model.Category;
import todo.model.ToDoModel;

import java.util.List;
import java.util.stream.Collectors;

public class ToDoMapper {

    public static final String Y = "Y";

    public static List<ToDoModel> map(List<ToDoEntity> entities){
        return entities.stream().map(ToDoMapper::map).collect(Collectors.toList());
    }

    public static ToDoModel map (ToDoEntity entity){
        ToDoModel toDoModel = ToDoModel.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(Category.valueOf(entity.getCategory()))
                .description(entity.getDescription())
                .creationDate(entity.getCreationDate())
                .deadline(entity.getDeadline())
                .done(entity.getDone().equals(Y))
                .build();
        return toDoModel;
    }
}
