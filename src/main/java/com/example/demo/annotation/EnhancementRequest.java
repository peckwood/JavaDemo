package com.example.demo.annotation;

import java.util.Date;

public @interface EnhancementRequest{
    long id();
    String synopsis();
    String engineer() default "unassigned ";
    String date() default "unknown";


}
