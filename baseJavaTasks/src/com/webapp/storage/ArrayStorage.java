package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage{

    @Override
    public void insertResume(Resume r, int indexOfPosition) {
        storage[size] = r;
        size++;
    }

    @Override
    public void deleteResume(int indexOfPosition) {
        storage[indexOfPosition] = storage[size - 1];
        storage[size - 1] = null;
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
