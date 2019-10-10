package todo.service;

import todo.controller.mapper.Mapper;
import todo.dao.ToDoDao;
import todo.entity.ToDoEntity;
import todo.mapper.ToDoMapper;
import todo.model.ToDoModel;

import java.util.List;

import static todo.mapper.ToDoMapper.Y;

public class ToDoService {

    private ToDoDao toDoDao = new ToDoDao();

    public List<ToDoModel> getToDo(String userLogin){
        return ToDoMapper.map(toDoDao.getEntities(userLogin));
    }

    public boolean addToDo(String login, ToDoModel toDoModel){
        return toDoDao.add(Mapper.mapToEntity(login, toDoModel));
    }

    public boolean markAsDone(long id){
        return toDoDao.updateStatus(id, Y);
    }
}
