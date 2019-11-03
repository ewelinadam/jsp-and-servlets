package todo.service.authentication;

import todo.dao.UserDao;
import todo.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationService {
    private UserDao userDao = new UserDao();

    public boolean authentication (HttpServletRequest request){
        String login = request.getParameter("login");
        UserEntity user = userDao.getUserByLogin(login);
        if(user != null && user.getPassword().equals(request.getParameter("password"))){
            request.getSession().setAttribute("login", login);
            return true;
        } else {
            return false;
        }
    }

    public boolean isAuthenticated (HttpServletRequest request) {
        String login = (String) request.getSession().getAttribute("login");
        return login !=null && !login.isEmpty();
    }

    public void logout(HttpServletRequest request){
        request.getSession().setAttribute("login", null);
    }

    public static String getUserLogin(HttpServletRequest request){
        return (String) request.getSession().getAttribute("login");
    }
}
