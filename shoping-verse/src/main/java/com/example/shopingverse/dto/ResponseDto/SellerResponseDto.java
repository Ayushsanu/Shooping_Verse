package com.example.shopingverse.dto.ResponseDto;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SellerResponseDto {
    String name;

    String emailId;
}
