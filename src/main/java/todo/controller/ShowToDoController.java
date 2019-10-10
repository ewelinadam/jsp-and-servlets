package todo.controller;

import todo.model.Category;
import todo.model.ToDoModel;
import todo.service.ToDoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static todo.service.authentication.AuthenticationService.getUserLogin;

@WebServlet("/to-do/home")
public class ShowToDoController extends HttpServlet {

    private ToDoService toDoService = new ToDoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = getUserLogin(req);

        req.setAttribute("categories", Category.values());
        req.setAttribute("toDoList", toDoService.getToDo(login));
        req.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(req,resp);
    }
}
