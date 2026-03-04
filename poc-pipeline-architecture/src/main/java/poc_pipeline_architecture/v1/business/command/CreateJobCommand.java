package poc_pipeline_architecture.v1.business.command;

import java.util.List;

public record CreateJobCommand(String name, List<Object> steps) {}

