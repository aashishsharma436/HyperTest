package com.HpyerTest.Application.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private Long db_post;
    private String http_outbound;

    public ApiResponse(String s) {
    }
}
