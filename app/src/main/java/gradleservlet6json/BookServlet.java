package gradleservlet6json;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
// import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

// import jakarta.servlet.ServletException;
// import jakarta.servlet.annotation.WebServlet;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;
    // Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Gson gson = new Gson();


    public void init() {
        String jdbcURL = "jdbc:mysql://localhost:3306/lavanya?serverTimezone=UTC";
        String jdbcUsername = "root";
        String jdbcPassword = "";

        bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = new ArrayList<Book>();
        try {
            bookList = bookDAO.listAllBooks();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        String json = gson.toJson(bookList);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestData = req.getReader().lines().collect(Collectors.joining());
        Book newBook = new Gson().fromJson(requestData, Book.class);
        System.out.println("requestData Length->" + requestData.length());
        System.out.println("requestData->" + requestData);
        System.out.println(newBook.getId() + " " + newBook.getAuthor());

        try {
            bookDAO.insertBook(newBook);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestData = req.getReader().lines().collect(Collectors.joining());
        Book updateBook = new Gson().fromJson(requestData, Book.class);
        System.out.println("requestData Length->" + requestData.length());
        System.out.println("requestData->" + requestData);
        System.out.println(updateBook.getId() + " " + updateBook.getAuthor());

        try {
            bookDAO.updateBook(updateBook);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestData = req.getReader().lines().collect(Collectors.joining());
        Book deleteBook = new Gson().fromJson(requestData, Book.class);
        System.out.println("requestData Length->" + requestData.length());
        System.out.println("requestData->" + requestData);
        System.out.println(deleteBook.getId() + " " + deleteBook.getAuthor());

        try {
            bookDAO.deleteBook(deleteBook);
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}