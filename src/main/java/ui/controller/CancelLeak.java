package ui.controller;

import domain.model.LeakReport;
import domain.model.LeakStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CancelLeak extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        service.updateLeakStatus(id, LeakStatus.GEANNULEERD);
        response.sendRedirect("Controller?command=OverviewLeaks");
        return "Controller?command=OverviewLeaks";
    }
}
