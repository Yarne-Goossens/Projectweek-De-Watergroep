package domain.service;

import domain.model.LeakReport;
import domain.model.ServiceAssignment;

import java.util.ArrayList;

public interface LeakReportService {

    void addLeakReport(LeakReport leak);

    LeakReport findLeakId(int id);

    ArrayList<LeakReport> getAllLeakReports();
    void updateLeak(LeakReport leak);

    LeakReport getLeakFromId(int id);

    void updateServiceAssignmentOfLeak(ServiceAssignment serviceAssignment);
}