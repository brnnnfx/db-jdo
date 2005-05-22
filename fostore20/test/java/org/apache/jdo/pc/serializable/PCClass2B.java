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

package org.apache.jdo.pc.serializable;

import java.io.Serializable;
import java.io.ObjectStreamException;

/**
 * A pc class has no persistence-capable superclass, implements 
 * java.io.Serializable and provides an implementation of method
 * writeReplace. 
 * 
 * The enhancer should add a method jdoPreSerialize
 * protected final void jdoPreSerialize() {
 *     final javax.jdo.spi.StateManager sm = this.jdoStateManager;
 *     if (sm != null) { sm.preSerialize(this); }
 * }
 * and should add a call of method jdoPreSerialize() to the existing
 * method writeReplace. It needs to be the first statement of writeReplace.
 *
 * @author Michael Bouschen
 */
public class PCClass2B
    implements Serializable
{
    private           int s01;
    private transient int t02;

    public PCClass2B()
    {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    public PCClass2B(int s01, int t02) 
    {
        this.s01 = s01;
        this.t02 = t02;
    }

    public int getS01() { return s01; }
    public void setS01(int value) { this.s01 = value; }

    public int getT02() { return t02; }
    public void setT02(int value) { this.t02 = value; }

    public boolean equals(Object obj) {
        if (obj==null || !(obj instanceof PCClass2B)) return false;
        PCClass2B o = (PCClass2B)obj;
        if (this.s01 != o.s01) return false;
        if (this.t02 != o.t02) return false;
        return true;
    }

    public String toString() 
    {
        StringBuffer repr = new StringBuffer();
        addFieldRepr(repr);
        return "PCClass2B(" + repr.toString() + ")";
    }
        
    protected void addFieldRepr(StringBuffer repr)
    {
        repr.append("s01="); repr.append(s01);
        repr.append(", t02="); repr.append(t02);
    }
    // --- implement writeReplace ---
    
    private Object writeReplace() 
        throws ObjectStreamException
    {
        return this;
    }
}
