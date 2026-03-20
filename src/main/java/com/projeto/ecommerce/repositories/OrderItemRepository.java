package com.projeto.ecommerce.repositories;

import com.projeto.ecommerce.entities.OrderItemEntity;
import com.projeto.ecommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemPK> {

}
