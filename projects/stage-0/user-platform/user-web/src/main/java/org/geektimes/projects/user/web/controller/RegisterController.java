package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by liaomm on 2021/3/3.
 */
@Path("/")
public class RegisterController implements PageController {

    @Override
    @Path("register")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        User user = new User();
        user.setName("admin");
        user.setPassword("1234");
        user.setEmail("p13766@163.com");
        user.setPhoneNumber("1313131");
        String databaseURL = "jdbc:derby:/Users/liaomm/Documents/myapple/derbydb/user-platform;create=true";
        Connection connection = DriverManager.getConnection(databaseURL);
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        dbConnectionManager.setConnection(connection);
        UserRepository userRepository = new DatabaseUserRepository(dbConnectionManager);
        userRepository.save(user);
        return "ok.jsp";
    }
}
