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
package be.shad.tsqb.values;

import be.shad.tsqb.query.TypeSafeQuery;
import be.shad.tsqb.query.copy.CopyContext;
import be.shad.tsqb.query.copy.Copyable;

/**
 * Represents a coalesce function. A coalesce is a fallback where the first
 * value in the list which is not null is selected.
 */
public class CoalesceTypeSafeValue<T> extends FunctionTypeSafeValue<T> {

    /**
     * Copy constructor
     */
    protected CoalesceTypeSafeValue(CopyContext context, CoalesceTypeSafeValue<T> original) {
        super(context, original);
    }

    public CoalesceTypeSafeValue(TypeSafeQuery query, TypeSafeValue<T> value) {
        super(query, "coalesce", value);
    }

    public CoalesceTypeSafeValue<T> or(T value) {
        add(value);
        return this;
    }

    public CoalesceTypeSafeValue<T> or(TypeSafeValue<T> value) {
        add(value);
        return this;
    }

    @Override
    public Copyable copy(CopyContext context) {
        return new CoalesceTypeSafeValue<>(context, this);
    }
}
