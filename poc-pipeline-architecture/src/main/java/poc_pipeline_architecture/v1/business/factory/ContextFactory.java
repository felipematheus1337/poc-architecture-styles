package poc_pipeline_architecture.v1.business.factory;

import org.springframework.stereotype.Component;
import poc_pipeline_architecture.v1.business.pipelines.context.Context;
import poc_pipeline_architecture.v1.business.pipelines.context.CreateJobContext;
import poc_pipeline_architecture.v1.presentation.dtos.JobRequest;

@Component
public class ContextFactory {


    public Context getContext(Context ctx) {
        return getContext("", ctx);
    }

    public Context getContext(String clazz, Context ctx) {
        if(ctx !=  null) {
            String className = stractClassName(clazz, ctx);
            if (className == "CreateJobContext") {
                JobRequest request = ((CreateJobContext) ctx).request;
                CreateJobContext jobContext = new CreateJobContext(request);
                return jobContext;
            }
            return null;
        }
        throw new IllegalArgumentException("Not a context;");

    }

    private String stractClassName(String clazz, Context ctx) {
        String className;
        if(clazz != null && !clazz.isEmpty()) {
            className = clazz;
        } else {
            className = ctx.getClass().getName();
        }
        return className;
    }
}
