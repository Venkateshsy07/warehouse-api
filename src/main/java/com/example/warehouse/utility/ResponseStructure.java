package com.example.warehouse.utility;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructure<T>{
    int status;
    String message;
    T data;
}
