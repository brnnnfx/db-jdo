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

package org.apache.jdo.pc;

import org.apache.jdo.test.util.Factory;


/**
* Provides a means to create objects that are inserted into a database, and
* for verifying that they've been retrieved OK.
*
* @author Dave Bristor
*/
public class InterfacesFactory implements Factory {
    /**
    * Returns the class instance of the pc class of this factory.
    */
    public Class getPCClass()
    {
        return PCInterfaces.class;
    }
    
    public Object create(int index) {
        PCInterfaces rc = new PCInterfaces();
        rc.init();
        return rc;
    }

    // Not needed by this implementation.
    public void setVerify(int x) { }

    // Not needed by this implementation.
    public boolean verify(int i, Object pc) {
        return true;
    }
}
