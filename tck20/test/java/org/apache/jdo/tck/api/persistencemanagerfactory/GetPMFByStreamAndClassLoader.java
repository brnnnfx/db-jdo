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
 
package org.apache.jdo.tck.api.persistencemanagerfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.apache.jdo.tck.util.BatchTestRunner;

/**
 *<B>Title:</B>GetPMFByStreamAndClassLoader of PersistenceManagerFactory  
 *<BR>
 *<B>Keywords:</B> persistencemanagerfactory
 *<BR>
 *<B>Assertion IDs:</B> A8.6-18.
 *<BR>
 *<B>Assertion Description: </B>
 * Uses the parameter(s) passed as arguments to construct a Properties 
 * instance, and then delegates to the static method 
 * getPersistenceManagerFactory in the class named in the property 
 * javax.jdo.PersistenceManagerFactoryClass. 
 * If there are any exceptions while trying to construct the Properties
 * instance or to call the static method, 
 * then either A8.6-4 [JDOFatalUserException] or 
 * A8.6-5 [JDOFatalInternalException is thrown], 
 * depending on whether the exception is due to the user 
 * or the implementation. 
 * The nested exception indicates the cause of the exception.
 * 
 * @author Michael Watzek
 */

public class GetPMFByStreamAndClassLoader extends AbstractGetPMF {
    
    /** */
    private static final String ASSERTION_FAILED = 
        "Assertion A8.6-18 (GetPMFByStreamAndClassLoader) failed: ";
    
    /**
     * The <code>main</code> is called when the class
     * is directly executed from the command line.
     * @param args The arguments passed to the program.
     */
    public static void main(String[] args) {
        BatchTestRunner.run(GetPMFByStreamAndClassLoader.class);
    }

    /** */
    public void testInvalidGetPMF() {
        checkGetPMFWithInvalidProperties(ASSERTION_FAILED);
    }

    /** */
    public void testValidGetPMF() {
        checkGetPMFWithValidProperties();
    }

    /**
     * @see AbstractGetPMF#getPMF(String)
     */
    protected PersistenceManagerFactory getPMF(String name) {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(name);
            return JDOHelper.getPersistenceManagerFactory(stream, 
                    Thread.currentThread().getContextClassLoader());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("", e);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
