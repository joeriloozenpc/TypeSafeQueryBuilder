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

import java.util.LinkedList;
import java.util.List;

/**
 * Wraps an hql stringbuilder and params and provides 
 * convenient methods to append to them.
 */
public class HqlQueryValueImpl implements HqlQueryValue {
    private List<Object> params = new LinkedList<>();
    private StringBuilder hql;
    
    public HqlQueryValueImpl() {
        this("");
    }
    
    public HqlQueryValueImpl(String hql, List<Object> params) {
        this.hql = new StringBuilder(hql);
        if( params != null ) {
            this.params.addAll(params);
        }
    }

    public HqlQueryValueImpl(String hql, Object... params) {
        this.hql = new StringBuilder(hql);
        if( params != null ) {
            for(Object param: params) {
                addParam(param);
            }
        }
    }
    
    public String getHql() {
        return hql.toString();
    }
    
    public void setHql(String hql) {
        this.hql = new StringBuilder(hql);
    }
    
    public StringBuilder appendHql(String hql) {
        this.hql.append(hql);
        return this.hql;
    }
    
    public Object[] getParams() {
        return params.toArray();
    }
    
    public void addParam(Object param) {
        params.add(param);
    }

    public void addParams(Object[] params) {
        for(Object param: params) {
            this.params.add(param);
        }
    }
    
}
