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

import java.util.HashSet;

/**
* A sample insurance class. Used with other classes which names 
* end with "1".
* 
* @author Marina Vatkina
*/
public class PCInsurance1 {
    public long insid;
    
    public String carrier;
    
    public PCEmployee1 employee;
    
    public String toString() {
        String ename = "none";
        try{ 
            ename = employee.getLastname();
        } catch (Exception e) {
//System.out.println("I: " + e);
        }
        return "Ins: " + carrier + ", id=" + insid +
            ", emp " + ename;
    }

    public PCInsurance1() {
    }

    public PCInsurance1(long _id, String _carrier, PCEmployee1 _emp) {
        insid = _id;
        carrier = _carrier;
        employee = _emp;
    }
    
    public long getInsid() {
        return insid;
    }
    
    public void setInsid(long insid) {
        this. insid = insid;
    }
    
    public String getCarrier() {
        return carrier;
    }
    
    public void setCarrier(String carrier) {
        this. carrier = carrier;
    }
    
    public PCEmployee1 getEmployee() {
        return employee;
    }
    
    public void setEmployee(PCEmployee1 employee) {
        this. employee = employee;
    }
    
    public static class Oid {
        public long insid;
        
        public Oid() {
        }
        
        public boolean equals(java.lang.Object obj) {
            if( obj==null ||
            !this.getClass().equals(obj.getClass()) ) return( false );
            Oid o=(Oid) obj;
            if( this.insid!=o.insid ) return( false );
            return( true );
        }
        
        public int hashCode() {
            int hashCode=0;
            hashCode += insid;
            return( hashCode );
        }
        
        
}
}

