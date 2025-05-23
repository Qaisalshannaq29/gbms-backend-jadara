package com.gpms.backend.services.Category.repoisitory;

import com.gpms.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
