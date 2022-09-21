package com.example.demo.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    @Autowired
    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<Category> getAllCategory()
    {
        return this.catRepository.findAll();
    }

    public void insertCategory(Category category)
    {
        this.catRepository.save(category);
    }
}
