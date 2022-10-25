package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[storage.size()];
        resumes = storage.values().toArray(resumes);
        return resumes;
    }

    @Override
    protected Resume doGet(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void doUpdate(Resume resume) {
        storage.computeIfPresent(resume.getUuid(), (key, value) -> value = resume);
    }

    @Override
    protected void doSave(Resume resume) {
        storage.putIfAbsent(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(String uuid) {
        storage.remove(uuid);
    }

    protected int getIndex(String uuid) {
        //поиск по ключу
        //Здесь всё таки нужно использовать searchKey, подумай
        // как это должно выглядеть с учётом правок в
        // AbstractStorage
        return 1;
    }

    @Override
    protected boolean getSearchKey(String uuid) {
        if(getIndex(uuid)!=0){ //переделать логику
                               //после переделки getIndex
            return false;
        }
        return true;
    }
}

