package domain.service;

import domain.model.LeakReport;

import java.util.ArrayList;

public interface LeakReportService {

    void addLeakReport(LeakReport leak);

    ArrayList<LeakReport> getAllLeakReports();
    void updateLeak(LeakReport leak);

    LeakReport getLeakFromId(int id);
}