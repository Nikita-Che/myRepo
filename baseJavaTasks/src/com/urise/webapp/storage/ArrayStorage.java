package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void insertResume(Resume r, int indexOfPosition) {
        storage[size] = r;
    }

    @Override
    public void deleteResume(int indexOfPosition) {
        storage[indexOfPosition] = storage[size - 1];
        storage[size - 1] = null;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean getSearchKey(String uuid) {
        if(getIndex(uuid)<0){
            return false;
        }
        return true;
    }
}