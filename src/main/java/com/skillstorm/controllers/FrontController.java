package com.skillstorm.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

  private TimeSheetController timeSheetController = new TimeSheetController();
  private UserController userController = new UserController();

  protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String uri = req.getRequestURI();
    System.out.println("URI = " + uri);

    switch (uri) {
    case "/clockwork/api/user":

      if (req.getMethod().equals("POST")) {
        System.out.println("user POST method in front controller called: ");
        userController.postUser(req, resp);
        return;
      } else if (req.getMethod().equals("GET")) {
        System.out.println("user GET method in front controller called: ");
        userController.getUser(req, resp);

      }
      break;
    case "/clockwork/api/timesheets":

      if (req.getMethod().equals("GET")) {
        System.out.println("timesheets/ Get method in front controller called: ");

        timeSheetController.getTimesheets(req, resp);
      }
     
      else if (req.getMethod().equals("POST")) {
        System.out.println("timesheets/ POST method in front controller called: ");
        timeSheetController.postTimeSheets(req, resp);

      }
     
      else if (req.getMethod().equals("PUT")) {

        System.out.println("timesheets/ PUT method in front controller called: ");
        timeSheetController.putTimesheets(req, resp);

      } else if (req.getMethod().equals("DELETE")) {
        System.out.println("timesheet/ DELETE method in front controller called: ");
        timeSheetController.deleteTimesheet(req, resp);
      }

      break;

    default:
      break;
    }

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub

    doDispatch(req, resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doDispatch(req, resp);
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doDispatch(req, resp);
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doDispatch(req, resp);
  }

}
