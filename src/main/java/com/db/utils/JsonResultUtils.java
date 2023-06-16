package com.db.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author swedsn
 * @version 1.0
 * @date 2023-06-01 08:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public  class JsonResultUtils {
    private int code;
    private Object info;
}
