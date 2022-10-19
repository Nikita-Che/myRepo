package com.webapp.storage;

import com.webapp.exception.ExistStorageException;
import com.webapp.exception.NotExistStorageException;
import com.webapp.exception.StorageException;
import com.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;

    private final String UUID_1 = "uuid1";
    private final String UUID_2 = "uuid2";
    private final String UUID_3 = "uuid3";
    private final String UUID_4 = "uuid4";
    private final String UUID_NOT_EXIST = "dummy";
    private final Resume RESUME1 = new Resume(UUID_1);
    private final Resume RESUME2 = new Resume(UUID_2);
    private final Resume RESUME3 = new Resume(UUID_3);
    private final Resume RESUME4 = new Resume(UUID_4);

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    public int assertSize(int expected) {
        if (expected == storage.size()) {
            return expected;
        }
        return -1;
    }

    @Test
    public void size() throws Exception {
        assertEquals(assertSize(3), storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Resume[] expected = new Resume[0];
        assertEquals(assertSize(0), storage.size());
        assertArrayEquals(expected, storage.getAll());
    }

    @Test
    public void getAll() throws Exception {
        Resume[] expected = new Resume[]{RESUME1, RESUME2, RESUME3};
        assertEquals(assertSize(3), storage.size());
        assertArrayEquals(expected, storage.getAll());
    }

    @Test()
    public void update() throws Exception {
        Resume resume = RESUME1;
        storage.update(resume);
        assertSame(resume, RESUME1);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        Resume resume = new Resume(UUID_NOT_EXIST);
        storage.update(resume);
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME4);
        assertEquals(assertSize(4), storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME2);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertEquals(assertSize(2), storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete(UUID_NOT_EXIST);
    }

    @Test(expected = StorageException.class)
    public void saveOverFlow() throws Exception {
        AbstractArrayStorage abstractArrayStorage = new SortedArrayStorage();
        int indexOfLimit = abstractArrayStorage.STORAGE_LIMIT;

        try {
            for (int i = storage.size() + 1; i < indexOfLimit; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            fail("переполнение произошло раньше времени");
        }
        storage.save(new Resume("переполнено"));
        storage.save(new Resume("переполнено1"));
    }

    public Resume assertGet(Resume resume) {
        Resume r = storage.get(resume.getUuid());

        for (int i = 0; i < storage.size(); i++) {
            if (r.equals(resume)) {
                return resume;
            }
        }
        return null;
    }

    @Test
    public void get() throws Exception {
        assertEquals(assertGet(RESUME1), RESUME1);
        assertEquals(assertGet(RESUME2), RESUME2);
        assertEquals(assertGet(RESUME3), RESUME3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get(UUID_NOT_EXIST);
    }
}