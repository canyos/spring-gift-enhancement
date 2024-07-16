package gift.repository;

import gift.dto.product.ShowProductDTO;
import gift.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select new gift.dto.product.ShowProductDTO(p.id, p.name, p.price, p.imageUrl, p.category.name) from Product p ")
    Page<ShowProductDTO> findAllProduct(Pageable pageable);

}
