package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    //Методы getResume, saveResume, updateResume, deleteResume
    // назови лучше doGet, doSave, doUpdate, doDelete

    @Override
    public Resume get(String uuid) {
        //Приняли uuid
        //Нашли по uuid какой-то ключ для резюме с таким uuid
        //Интерпретировали ключ - узнали, существует ли оно по этому ключу
        //Если НЕ существует - бросили исключение, и тем самым прервали выполнение метода
        //Запросили резюме по данному ключу
        // (опять же, наследники пусть сами разбираются откуда
        // и как его взять - нам пофиг на этом уровне)

        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(uuid);
    }

    protected abstract Resume getResume(String uuid);

    @Override
    public void update(Resume resume) {
        //Приняли uuid и резюме
        //Нашли какой-то ключ
        //Интерпретировали ключ
        //Если НЕ существует - бросили исключение
        //Запросили у наследника обновление: отдали ему ключ и резюме

        int index = getIndex(resume.getUuid());

        if (index >= 0) {
            updateResume(resume);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    protected abstract void updateResume(Resume resume);

    @Override
    public void save(Resume r) {
        //Приняли какой-то объект резюме
        //Нашли какой-то ключ для этого резюме (у нас это в массивах был индекс)
        //Проверили по этому ключу, а не существует ли уже такое резюме? (интерпретировали значение ключа)
        //Если уже существует - бросили исключение, и тем самым прервали выполнение метода
        //Сохранили резюме куда бы то ни было (наследники пусть с этим сами разбираются - куда и как)

        int index = getIndex(r.getUuid());

        if (index > 0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            saveResume(r);
        }
    }

    protected abstract void saveResume(Resume resume);

    @Override
    public void delete(String uuid) {
        //Приняли uuid
        //Нашли какой-то ключ
        //Интерпретировали ключ
        //Если НЕ существует - бросили исключение
        //Запросили у наследника удаление резюме по такому-то ключу

        int index = getIndex(uuid);

        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(uuid);
        }
    }

    protected abstract void deleteResume(String uuid);

    protected abstract int getIndex(String uuid);
    //getSearchKey переименовать Object на вход
    //Никакой логики работы с индексами на этом уровне быть не должно.
    // На этом уровне мы работаем с Object searchKey,
    // а наследники уже сами разбираются какой у них тип ключа.


    //Логику выброса исключений можно вынести в два метода:
    // getExistingSeachKey/getNotExistingSearchKey,
    // и там же вызвать getSearchKey, его же и интерпретировать, и выбросить исключение, если надо
}
