package com.example.shopingverse.dto.ResponseDto;

import com.example.shopingverse.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto {
    String name;

    String emailId;

    String mobNo;


    Gender gender;
}
