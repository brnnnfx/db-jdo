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

package org.apache.jdo.impl.model.jdo.caching;

import org.apache.jdo.impl.model.jdo.JDOCollectionImplDynamic;
import org.apache.jdo.model.java.JavaType;

/**
 * An instance of this class represents the JDO relationship metadata 
 * of a collection relationship field. This caching implementation
 * caches any calulated value to avoid re-calculating it if it is
 * requested again. 
 *
 * @author Michael Bouschen
 * @since 1.1
 * @version 1.1
 */
public class JDOCollectionImplCaching extends JDOCollectionImplDynamic {
    
    /**
     * Determines whether the values of the elements should be stored if 
     * possible as part of the instance instead of as their own instances 
     * in the datastore.
     * @return <code>true</code> if the elements should be stored as part of 
     * the instance; <code>false</code> otherwise
     */
    public boolean isEmbeddedElement() {
        if (embeddedElement == null) {
            embeddedElement = 
                super.isEmbeddedElement() ? Boolean.TRUE : Boolean.FALSE;
        }
        return (embeddedElement == null) ? false : 
            embeddedElement.booleanValue();
    }
    
    /** 
     * Get the type representation of the collection elements. 
     * @return the element type
     */
    public JavaType getElementType()
    {
        if (elementType == null) {
            elementType = super.getElementType();
        }
        return elementType;
    }

}
