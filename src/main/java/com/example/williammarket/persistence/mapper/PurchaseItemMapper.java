package com.example.williammarket.persistence.mapper;

import com.example.williammarket.domain.PurchaseItem;
import com.example.williammarket.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses={ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto",target = "productId"),
            @Mapping(source = "cantidad",target = "quantity"),
            //@Mapping(source = "total",target = "total"),//no es necesario por que see llaman igual
            @Mapping(source = "estado",target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra",ignore = true),
            @Mapping(target = "producto",ignore = true),
            @Mapping(target = "id.idCompra",ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
}
