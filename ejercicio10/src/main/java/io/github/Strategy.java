package io.github;

import java.util.List;

public interface Strategy {
    public JobDescription next(List<JobDescription> jobs);
}
