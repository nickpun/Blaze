package com.system.blaze.customRespond;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomeErrorRespond {
    private int errorCode;
    private String message;
}
