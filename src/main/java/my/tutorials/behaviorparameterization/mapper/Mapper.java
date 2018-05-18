package my.tutorials.behaviorparameterization.mapper;

public interface Mapper {

    <T> T map(T entity);
}
