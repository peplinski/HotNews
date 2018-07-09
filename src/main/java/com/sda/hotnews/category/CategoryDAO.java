package com.sda.hotnews.category;

import java.util.*;

public class CategoryDAO {

    private static final Map<Integer, Category> categories = new HashMap<>();



    public Optional<Category> getById(int id) {
        return Optional.ofNullable(categories.get(id));
    }

    public Set<Category> getAll() {
        return new HashSet<>(categories.values());
    }

    public int add(String name) {
        Category category = new Category(name);
        categories.put(category.getId(), category);
        return category.getId();
    }

    public int edit(int id, String newName) {
        Category category = categories.get(id);
        if (category == null) {
            return -1;
        }

        category.setName(newName);
        return id;
    }

    public int remove(int id) {
        Category category = categories.get(id);
        if (category == null) {
            return -1;
        }

        categories.remove(id);
        return id;
    }
}
