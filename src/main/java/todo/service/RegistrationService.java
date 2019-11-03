package todo.service;

import todo.dao.UserDao;
import todo.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class RegistrationService {

    private UserDao userDao = new UserDao();

    public boolean register (HttpServletRequest request){  //TODO: throws UserExistException

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String repeatedPassword = request.getParameter("repeatedPassword");
        String email = request.getParameter("email");

        if (isBlank(login)) {
            return false;
        }

        UserEntity userByLogin = userDao.getUserByLogin(login);
        if (userByLogin != null) {
            return false;
        }

        if (isBlank(password)) {
            return false;
        }

        if (isBlank(repeatedPassword)) {
            return false;
        }

        if(!password.equals(repeatedPassword)){
            return false;
        }

        if (isBlank(email)) {
            return false;
        }

        UserDao.addUser(UserEntity.builder()
                .password(password)
                .login(login)
                .email(email)
                .build());

        return true;
    }
}
