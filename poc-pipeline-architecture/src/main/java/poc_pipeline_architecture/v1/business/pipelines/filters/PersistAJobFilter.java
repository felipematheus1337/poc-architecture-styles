package poc_pipeline_architecture.v1.business.pipelines.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import poc_pipeline_architecture.v1.business.factory.ContextFactory;
import poc_pipeline_architecture.v1.business.pipelines.context.Context;
import poc_pipeline_architecture.v1.business.pipelines.context.CreateJobContext;
import poc_pipeline_architecture.v1.persistence.entity.Job;
import poc_pipeline_architecture.v1.persistence.repository.JobRepository;

@Component
public class PersistAJobFilter<T> implements Filter<T> {

    private static final Logger log = LoggerFactory.getLogger(PersistAJobFilter.class);
    private final ContextFactory factory;
    private final JobRepository repository;

    public PersistAJobFilter(ContextFactory factory, JobRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    @Override
    @Transactional
    public void apply(T tContext) {

        var contextName = getContextName(tContext);

        if (contextName == "CreateJobContext") {
                CreateJobContext ctx = (CreateJobContext) factory.getContext(contextName, (CreateJobContext) tContext);
                this.persist(ctx.job);
        }

    }

    private void persist(Job job) {
        repository.save(job);
    }

    private String getContextName(T context) {
        if (context != null) {
            return context.getClass().getName();
        }
        return null;
    }

}
