package io.github;

import java.util.List;

public class MostEffort implements Strategy {

    @Override
    public JobDescription next(List<JobDescription> jobs) {
        JobDescription nextJob = null;

        if(jobs != null) {
            nextJob = jobs.stream()
                    .max((j1, j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
                    .orElse(null);
        }

        return nextJob;
    }
}
