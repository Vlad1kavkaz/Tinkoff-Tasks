package edu.project3.counters;

import edu.project3.logs.LogInfo;
import java.util.Arrays;

public class AverageResponseSizeMetricCounter implements LogMetricCounter<Double> {
    @Override
    public Double countMetric(LogInfo[] logs) {
        return Arrays.stream(logs).mapToLong(log -> log.responseInfo.bytesSent).average().orElse(0);
    }
}
