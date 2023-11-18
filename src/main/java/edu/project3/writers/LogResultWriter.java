package edu.project3.writers;

import edu.project3.counters.AverageResponseSizeMetricCounter;
import edu.project3.counters.HttpMethodMetricCounter;
import edu.project3.counters.PopularUserClientsMetricCounter;
import edu.project3.counters.RequestMetricCounter;
import edu.project3.counters.ResourcesMetricCounter;
import edu.project3.counters.ResponseCodeMetricCounter;
import edu.project3.logs.LogInfo;
import java.io.IOException;
import java.nio.file.Path;

public abstract class LogResultWriter {
    protected final AverageResponseSizeMetricCounter averageResponseSizeMetricCounter;
    protected final RequestMetricCounter requestMetricCounter;
    protected final ResourcesMetricCounter resourcesMetricCounter;
    protected final ResponseCodeMetricCounter responseCodeMetricCounter;
    protected final PopularUserClientsMetricCounter popularUserClientsMetricCounter;
    protected final HttpMethodMetricCounter httpMethodMetricCounter;

    public LogResultWriter() {
        averageResponseSizeMetricCounter = new AverageResponseSizeMetricCounter();
        requestMetricCounter = new RequestMetricCounter();
        resourcesMetricCounter = new ResourcesMetricCounter();
        responseCodeMetricCounter = new ResponseCodeMetricCounter();
        popularUserClientsMetricCounter = new PopularUserClientsMetricCounter();
        httpMethodMetricCounter = new HttpMethodMetricCounter();
    }

    public abstract void writeResultsToFile(LogInfo[] logs, Path path) throws IOException;
}
