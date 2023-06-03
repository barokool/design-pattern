package com.student.factories;

/**
 * @author : Viet Van Lau
 * @project design-pattern
 * @created 03/06/2023 - 4:24 PM
 */
public interface CreateEntity<T,D> {
   T create (D dto);
}
