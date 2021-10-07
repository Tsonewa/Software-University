package com.example.jsonproccessing.utils;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

    <E> boolean isValid (E entity);

   <E> Set<ConstraintViolation<E>> validate (E entity);
}
