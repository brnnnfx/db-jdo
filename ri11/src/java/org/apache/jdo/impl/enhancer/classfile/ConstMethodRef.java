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


package org.apache.jdo.impl.enhancer.classfile;

import java.io.*;

/**
 * Class representing a reference to a method of some class in the
 * constant pool of a class file
 */
public class ConstMethodRef extends ConstBasicMemberRef {
    /* The tag value associated with ConstMethodRef */
    public static final int MyTag = CONSTANTMethodRef;

    /* public accessors */

    /**
     * The tag of this constant entry
     */
    public int tag () { return MyTag; }

    /**
     * A printable representation
     */
    public String toString () {
        return "CONSTANTMethodRef(" + indexAsString() + "): " + 
            super.toString();
    }

    /* package local methods */

    ConstMethodRef (ConstClass cname, ConstNameAndType NT) {
        super(cname, NT);
    }

    ConstMethodRef (int cnameIndex, int NT_index) {
        super(cnameIndex, NT_index);
    }

    static ConstMethodRef read (DataInputStream input) throws IOException {
        int cname = input.readUnsignedShort();
        int NT = input.readUnsignedShort();
        return new ConstMethodRef (cname, NT);
    }
}
