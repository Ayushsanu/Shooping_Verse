package com.example.shopingverse.service;

import com.example.shopingverse.dto.RequestDto.ItemRequestDto;
import com.example.shopingverse.dto.ResponseDto.CartResponseDto;
import com.example.shopingverse.model.Cart;
import com.example.shopingverse.model.Customer;
import com.example.shopingverse.model.Item;
import com.example.shopingverse.model.Product;
import com.example.shopingverse.repository.*;
import com.example.shopingverse.transformer.CartTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CardRepository cardRepository;

    @Autowired
    CartRepository cartRepository;
    public CartResponseDto addItemToCart(ItemRequestDto itemRequestDto,Item item) {
        Customer customer = customerRepository.findByEmailId(itemRequestDto.getCustomerEmail());
        Product product = productRepository.findById(itemRequestDto.getProductId()).get();

        Cart cart = customer.getCart();
        cart.setCartTotal(cart.getCartTotal() + product.getPrice()*itemRequestDto.getRequiredQuantity());

        item.setCart(cart);
        item.setProduct(product);
        Item savedItem = itemRepository.save(item);  // to avoid duplicacy

        cart.getItems().add(savedItem);
        product.getItems().add(savedItem);
        Cart savedCart = cartRepository.save(cart);
        productRepository.save(product);

        //prepare cartResponse Dto
        return CartTransformer.CartToCartReponseDto(savedCart);
    }
}
