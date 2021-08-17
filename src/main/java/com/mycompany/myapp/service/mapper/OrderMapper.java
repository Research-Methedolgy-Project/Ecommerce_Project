package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.OrderDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Order} and its DTO {@link OrderDTO}.
 */
@Mapper(componentModel = "spring", uses = { UserMapper.class, ProductMapper.class })
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {
    @Mapping(target = "user", source = "user", qualifiedByName = "login")
    @Mapping(target = "products", source = "products", qualifiedByName = "idSet")
    OrderDTO toDto(Order s);

    @Mapping(target = "removeProduct", ignore = true)
    Order toEntity(OrderDTO orderDTO);
}
