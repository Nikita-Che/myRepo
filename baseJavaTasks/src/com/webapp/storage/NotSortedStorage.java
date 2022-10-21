package com.webapp.storage;

import com.webapp.model.Resume;

public class NotSortedStorage extends ArrayStorage {
    @Override
    public void insertResume(Resume r, int indexOfPosition) {
        super.insertResume(r, indexOfPosition);
    }

    @Override
    public void deleteResume(int indexOfPosition) {
        super.deleteResume(indexOfPosition);
    }

    @Override
    protected int getIndex(String uuid) {
        return super.getIndex(uuid);
    }
}
