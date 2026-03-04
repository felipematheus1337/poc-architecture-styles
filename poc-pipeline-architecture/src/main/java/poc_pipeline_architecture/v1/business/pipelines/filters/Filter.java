package poc_pipeline_architecture.v1.business.pipelines.filters;

public interface Filter<T> {
    void apply(T tContext);
}
