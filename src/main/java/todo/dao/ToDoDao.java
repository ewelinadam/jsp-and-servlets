package todo.dao;

import todo.controller.mapper.Mapper;
import todo.entity.ToDoEntity;
import todo.model.ToDoModel;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static todo.service.IdGenerationService.generateId;

public class ToDoDao {
    private static List<ToDoEntity> list = LoadMockData();

    public List<ToDoEntity> getEntities(String userLogin) { //wyszukiwanie po id użytkownika
        return list.stream().filter(toDo -> toDo.getUserLogin().equals(userLogin)).collect(Collectors.toList());
    }

    public ToDoEntity getToDoEntity(long id) {
        return list.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
    }

    public boolean updateStatus(long id, String status) {
        ToDoEntity toDoEntity = getToDoEntity(id);
        if (toDoEntity != null) {
            toDoEntity.setDone(status);
            return true;
        }
        return false;
    }

    public boolean add(ToDoEntity toDoEntity){
        return list.add(toDoEntity);
    }

    private static List<ToDoEntity> LoadMockData() {
        List<ToDoEntity> toDoList = new ArrayList<>();

        ToDoEntity toDoFirst = ToDoEntity.builder()
                .id(generateId())
                .userLogin("janek")
                .name("Nakarmić kota")
                .category("FAMILY")
                .description("Dietetyczna karma")
                .creationDate(LocalDateTime.of(2019, 10, 5, 15, 9))
                .deadline(LocalDateTime.of(2019, 10, 5, 18, 00))
                .done("N")
                .build();

        ToDoEntity toDoSecond = ToDoEntity.builder()
                .id(generateId())
                .userLogin("janek")
                .name("Nakarmić psa")
                .category("FAMILY")
                .description("Karma dla seniorów + witaminy")
                .creationDate(LocalDateTime.of(2019, 10, 5, 15, 00))
                .deadline(LocalDateTime.of(2019, 10, 5, 18, 00))
                .done("N")
                .build();
        toDoList.add(toDoFirst);
        toDoList.add(toDoSecond);
        return toDoList;
    }
}
