package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CartDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Cart} and its DTO {@link CartDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProductMapper.class, UserMapper.class })
public interface CartMapper extends EntityMapper<CartDTO, Cart> {
    @Mapping(target = "product", source = "product", qualifiedByName = "id")
    @Mapping(target = "user", source = "user", qualifiedByName = "login")
    CartDTO toDto(Cart s);
}
