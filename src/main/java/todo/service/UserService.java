package todo.service;

import todo.dao.UserDao;
import todo.mapper.UserMapper;
import todo.model.UserModel;

import java.util.List;

public class UserService {

    UserDao userDao = new UserDao();

    public UserModel getUserByLogin(String login){
        return UserMapper.mapToModel(userDao.getUserByLogin(login));
    }

}
