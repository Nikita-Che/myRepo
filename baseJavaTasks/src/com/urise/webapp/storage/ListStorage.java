package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    protected final List<Resume> storage = new ArrayList<>();

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
        resumes = storage.toArray(resumes);
        return resumes;
    }

    @Override
    protected Resume doGet(String uuid) {
        return storage.get(getIndex(uuid));
    }

    @Override
    protected void doUpdate(Resume resume) {
        storage.set(getIndex(resume.getUuid()), resume);
    }

    @Override
    protected void doSave(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void doDelete(String uuid) {
        storage.remove(getIndex(uuid));
    }

    protected int getIndex(String uuid) {
        //переделать в цикл indexOf здесь не прокатит, так как он ищет именно эквивалентный объект,
        // а при апдейте он будет тем же по uuid, но не будет эквивалентным, поэтому здесь только циклом искать
        Resume resume = new Resume(uuid);
        return storage.indexOf(resume);
    }

    @Override
    protected boolean getSearchKey(String uuid) {
        if (getIndex(uuid) < 0) {
            return false;
        }
        return true;
    }
}
