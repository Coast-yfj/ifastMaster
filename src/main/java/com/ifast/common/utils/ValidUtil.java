package com.ifast.common.utils;

import com.ifast.sys.filter.XssFilter;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidUtil {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(XssFilter.class);

    public static Map<String, String> getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<String, String>();
        List<FieldError> list = result.getFieldErrors();
        for (FieldError error : list) {
            logger.info("------------------error.getField():" + error.getField());
            logger.info("------------------error.getDefaultMessage():" + error.getDefaultMessage());
            map.put(error.getField(), error.getDefaultMessage());
        }
        return map;
    }
}
