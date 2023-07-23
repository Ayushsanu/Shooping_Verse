package com.example.shopingverse.service;

import com.example.shopingverse.Enum.ProductCategory;
import com.example.shopingverse.dto.RequestDto.ProductRequestDto;
import com.example.shopingverse.dto.ResponseDto.ProductResponseDto;
import com.example.shopingverse.exception.SellerNotFoundException;
import com.example.shopingverse.model.Product;
import com.example.shopingverse.model.Seller;
import com.example.shopingverse.repository.ProductRepository;
import com.example.shopingverse.repository.SellerRepository;
import com.example.shopingverse.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    ProductRepository productRepository;
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto){
        Seller seller = sellerRepository.findByEmailId(productRequestDto.getSellerEmail());
        if (seller == null) {
            throw new SellerNotFoundException("Seller doesn't exist");
        }

        // dto -> entity
        Product product = ProductTransformer.productRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);
        seller.getProducts().add(product);

        Seller savedSeller = sellerRepository.save(seller); // save both product and seller
        List<Product> productList = savedSeller.getProducts();
        Product latestProduct = productList.get(productList.size() - 1);

        // prepare response dto
        return ProductTransformer.productToProductResponseDto(latestProduct);

    }

    public List<ProductResponseDto> getProductByCategoriesAndPrice(int price, ProductCategory category) {
        List<Product> products=productRepository.getProductByCategoriesAndPrice(price,category);
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product:products){
            productResponseDtos.add(ProductTransformer.productToProductResponseDto(product));
        }
        return productResponseDtos;

    }
}
