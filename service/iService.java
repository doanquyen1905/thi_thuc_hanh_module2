package thi_thuc_hanh_module2.service;

import thi_thuc_hanh_module2.model.Person;

import java.util.List;

public interface iService<S extends Person> {
    public interface IService<T extends Person> {

        boolean add(T t);

        List<T> getAll();

        T findByCode(int code);

        void removeStudent(T student);

        boolean update(T t);

        List<T> searchByName(String name);
    }

}
