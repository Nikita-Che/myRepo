package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
// TODO: 03.11.2022 refactor getAll
public interface Storage {

    void clear();

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll();
    //return list sorted by Name
    //List<Resume> gelAllSorted(); по имени фамиилии

    int size();
}