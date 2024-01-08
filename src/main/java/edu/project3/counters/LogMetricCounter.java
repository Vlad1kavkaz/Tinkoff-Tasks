package edu.project3.counters;

import edu.project3.logs.LogInfo;

public interface LogMetricCounter<T> {
    T countMetric(LogInfo[] logs);
}
