package com.example.warehouse.utility;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorStructure {
    private int status;
   private String errorMessage;
}
