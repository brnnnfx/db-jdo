/*
 * Copyright 2005 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package org.apache.jdo.jdoql.tree;

/**
 * This node represents a cast expression. It has a result type and a child
 * which corresponds with the expression to cast.
 *
 * @author Michael Watzek
 */
public interface CastExpression extends Expression
{
    /**
     * Returns the string representation of the Java class,
     * to which this node's expression is casted.
     * @return the Java type name
     */
    public String getTypeName();

    /**
     * Returns the node's cast expression.
     * @return the node's cast expression
     */
    public Expression getExpression();
}
