package com.arshad.monolith.InventoryManagementSystem.mapper;

import com.arshad.monolith.InventoryManagementSystem.beans.Product;
import com.arshad.monolith.InventoryManagementSystem.beans.ProductResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductResponseModel mapToUserResponseModel(final Product product);

    List<ProductResponseModel> mapToUserResponseModelList(final List<Product> productList);
}
