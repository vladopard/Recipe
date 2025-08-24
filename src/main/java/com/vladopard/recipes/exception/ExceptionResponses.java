package com.vladopard.recipes.exception;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExceptionResponses {

    private int status;
    private String message;
    private long timeStamp;

}
