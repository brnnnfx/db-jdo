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

package org.apache.jdo.tck.api.persistencemanager;

import javax.jdo.PersistenceManagerFactory;

import org.apache.jdo.tck.util.BatchTestRunner;

/**
 *<B>Title:</B> Is Closed Is True After Close
 *<BR>
 *<B>Keywords:</B>
 *<BR>
 *<B>Assertion IDs:</B> A12.5-5
 *<BR>
 *<B>Assertion Description: </B>
The PersistenceManager.isClosed method returns true only after the
closemethod completes successfully, meaning the PersistenceManager has been closed. (same as A35-01).
*/

public class IsClosedIsTrueAfterClose extends PersistenceManagerTest {
    
    /** */
    private static final String ASSERTION_FAILED = 
        "Assertion A12.5-5 (IsClosedIsTrueAfterClose) failed: ";
    
    /**
     * The <code>main</code> is called when the class
     * is directly executed from the command line.
     * @param args The arguments passed to the program.
     */
    public static void main(String[] args) {
        BatchTestRunner.run(IsClosedIsTrueAfterClose.class);
    }

    /** */
    public void test() {
        PersistenceManagerFactory pmf = getPMF();
        pm = pmf.getPersistenceManager();
        pm.close();
        
        if (!pm.isClosed()) {
            fail(ASSERTION_FAILED,
                 "pm.isClosed returns false after pm.close");
        }
    }
}