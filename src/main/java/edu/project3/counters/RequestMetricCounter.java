package edu.project3.counters;

import edu.project3.logs.LogInfo;

public class RequestMetricCounter implements LogMetricCounter<String> {
    @Override
    public String countMetric(LogInfo[] logs) {
        return String.valueOf(logs.length);
    }
}
