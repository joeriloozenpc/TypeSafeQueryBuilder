/*
 * Copyright Gert Wijns gert.wijns@gmail.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.shad.tsqb.query;

import be.shad.tsqb.values.TypeSafeValue;

/**
 * Represents the selection of a value using a subquery. 
 * The valueType is the generic type T.
 * Subqueries may be nested as deep as needed.
 */
public interface TypeSafeSubQuery<T> extends TypeSafeValue<T>, TypeSafeQuery {
    
    /**
     * Set the value to select.
     * <p>
     * Converts the value to a TypeSafeValue and delegates to {@link #select(TypeSafeValue)}.
     */
    void select(T value);
    
    /**
     * Set the value to select.
     * <p>
     * This method should be called before converting to hql, unless using the exists function.
     */
    void select(TypeSafeValue<T> value);
    
}
