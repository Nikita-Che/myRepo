package com.webapp.storage;

import com.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        int key = getSearchKey(r.getUuid());
        if (key != -1) {
            System.out.println("Такое резюме " + r.getUuid() + " Уже существует");
        } else if (size == storage.length) {
            System.out.println("Массив резюме переполнен");
        } else {
            storage[size] = r;
            size++;
        }
    }

    public void update(Resume r) {
        int key = getSearchKey(r.getUuid());
        if (key == -1) {
            System.out.println("Такое резюме " + r.getUuid() + " НЕ существует");
        } else {
            storage[key] = r;
        }
    }

    public Resume get(String uuid) {
        int key = getSearchKey(uuid);
        if (key == -1) {
            System.out.println("Такое резюме " + uuid + " НЕ существует");
            return null;
        }
        return storage[key];
    }

    public void delete(String uuid) {
        int key = getSearchKey(uuid);
        if (key == -1) {
            System.out.println("Такое резюме " + uuid + " НЕ существует");
        } else {
            storage[key] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
