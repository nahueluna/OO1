package io.github;

import java.util.List;

public class FIFO implements Strategy {

    @Override
    public JobDescription next(List<JobDescription> jobs) {
        JobDescription nextJob = null;
        if (jobs != null) {
           nextJob = jobs.get(0);
        }

        return nextJob;
    }
}
