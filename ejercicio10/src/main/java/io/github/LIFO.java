package io.github;

import java.util.List;

public class LIFO implements Strategy {

    @Override
    public JobDescription next(List<JobDescription> jobs) {
        JobDescription nextJob = null;

        if (jobs != null) {
            nextJob = jobs.get(jobs.size() - 1);
        }

        return nextJob;
    }
}
