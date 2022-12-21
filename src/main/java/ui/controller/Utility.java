package ui.controller;

import domain.model.Employee;
import domain.model.EmployeeType;

import javax.servlet.http.HttpServletRequest;

public class Utility {

    public static void checkRole(HttpServletRequest request, EmployeeType[] employeeTypes) {
        // read user from session
        // if users role is different from given employeeTypes
        //      throw NotAuthorizedException
        boolean found = false;
        Employee user = (Employee) request.getSession().getAttribute("user");
        if (user != null)
            for (EmployeeType employeeType : employeeTypes) {
                if (user.getType().toString().equalsIgnoreCase(employeeType.getStringValue())) {
                    found = true;
                    break;
                }
            }
        if (!found)
            throw new NotAuthorizedException();

    }
    public static boolean hasRole(HttpServletRequest request, EmployeeType[] employeeTypes) {
        boolean found = false;
        Employee user = (Employee) request.getSession().getAttribute("user");
        for(EmployeeType employeeType:employeeTypes){
            if (user != null) {
                found =  user.getType().toString().equalsIgnoreCase(employeeType.getStringValue());
                if (found){
                    break;
                }
            }
        }
        return found;
    }

}
