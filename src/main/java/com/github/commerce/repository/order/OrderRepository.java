package com.github.commerce.repository.order;

import com.github.commerce.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(
            "SELECT o FROM Order o " +
                    "WHERE o.users.id = :userId " +
                    //"SELECT c FROM Cart c " +
                    "AND o.id > :cursorId " +
                    "ORDER BY o.id ASC "
    )
    Page<Order> findAllByUsersIdAndCursorId(Long userId, Long cursorId, PageRequest of);

    Optional<Order> findByIdAndUsersId(Long orderId, Long userId);
}