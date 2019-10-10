package todo.controller;

import todo.controller.mapper.Mapper;
import todo.model.ToDoModel;
import todo.service.ToDoService;
import todo.service.authentication.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static todo.service.authentication.AuthenticationService.getUserLogin;

@WebServlet("/to-do/addToDo")
public class AddToDoController extends HttpServlet {
ToDoService toDoService = new ToDoService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ToDoModel toDoModel = Mapper.map(req);
        toDoService.addToDo(getUserLogin(req),toDoModel);
        resp.sendRedirect("/to-do/home");
    }
}
