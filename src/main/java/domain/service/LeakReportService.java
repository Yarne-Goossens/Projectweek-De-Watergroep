package domain.service;

import domain.model.LeakReport;
import domain.model.LeakStatus;

import java.util.ArrayList;
import java.util.List;

public interface LeakReportService {

    void addLeakReport(LeakReport leak);

    LeakReport findLeakId(int id);

    ArrayList<LeakReport> getAllLeakReports();
    void updateLeak(LeakReport leak);

    LeakReport getLeakFromId(int id);

    List<LeakReport> getAllLeaksWithServiceAssignmentId(int id);

    void updateLeakStatus(int id, LeakStatus status);
}