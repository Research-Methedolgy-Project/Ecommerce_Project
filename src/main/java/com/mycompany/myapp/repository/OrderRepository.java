package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Order entity.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select order from Order order where order.user.login = ?#{principal.username}")
    List<Order> findByUserIsCurrentUser();

    @Query(
        value = "select distinct order from Order order",
        countQuery = "select count(distinct order) from Order order"
    )
    Page<Order> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct order from Order order")
    List<Order> findAllWithEagerRelationships();

    Optional<Order> findOrderById(@Param("id") Long id);
}
