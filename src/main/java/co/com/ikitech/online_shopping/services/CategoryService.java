package co.com.ikitech.online_shopping.services;

import co.com.ikitech.online_shopping.model.Category;
import co.com.ikitech.online_shopping.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // Obtener todas las categorías
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Obtener categoría por ID
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Crear una nueva categoría
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Actualizar una categoría existente
    public Optional<Category> updateCategory(Long id, Category category) {
        return categoryRepository.findById(id)
                .map(existingCategory -> {
                    existingCategory.setName(category.getName());
                    return categoryRepository.save(existingCategory);
                });
    }

    // Eliminar una categoría
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
