package com.example.warehouse.utility;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
    int status;
    String errorMessage;
}
