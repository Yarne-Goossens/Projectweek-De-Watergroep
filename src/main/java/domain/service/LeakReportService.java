package domain.service;

import domain.model.Animal;
import domain.model.LeakReport;

import java.util.ArrayList;

public interface LeakReportService {

    void addLeakReport(LeakReport leak);

    Animal findLeakId(int id);

    ArrayList<LeakReport> getAllLeakReports();

}
