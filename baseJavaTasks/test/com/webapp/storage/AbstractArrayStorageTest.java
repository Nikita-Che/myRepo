package com.webapp.storage;

import com.webapp.exception.NotExistStorageException;
import com.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractArrayStorageTest {
    private Storage storage;
    private final String UUID_1 = "uuid1";
    private final String UUID_2 = "uuid2";
    private final String UUID_3 = "uuid3";

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void overFlow() throws Exception {
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");

    }
}