/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */
 
package org.apache.jdo.tck.pc.companyAnnotatedPI;

import javax.jdo.annotations.*;

import java.util.Date;
import java.util.Set;
import org.apache.jdo.tck.pc.company.IDentalInsurance;
import org.apache.jdo.tck.pc.company.IDepartment;
import org.apache.jdo.tck.pc.company.IEmployee;
import org.apache.jdo.tck.pc.company.IMedicalInsurance;

/**
 * This interface represents the persistent state of Employee.
 * Javadoc was deliberately omitted because it would distract from
 * the purpose of the interface.
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.SUPERCLASS_TABLE)
public interface PIDSEmployee extends IEmployee, PIDSPerson {

    @Column(name="HIREDATE")
    Date getHiredate();
    @Column(name="WEEKLYHOURS")
    double getWeeklyhours();
    @Persistent(mappedBy="reviewers")
    @Element(boundTypes=org.apache.jdo.tck.pc.companyAnnotatedPI.PIDSProject.class)
    Set getReviewedProjects();
    @Persistent(mappedBy="members")
    @Element(boundTypes=org.apache.jdo.tck.pc.companyAnnotatedPI.PIDSProject.class)
    Set getProjects();
    @Persistent(mappedBy="employee")
    IDentalInsurance getDentalInsurance();
    @Persistent(mappedBy="employee")
    IMedicalInsurance getMedicalInsurance();
    @Column(name="DEPARTMENT")
    IDepartment getDepartment();
    @Column(name="FUNDINGDEPT")
    IDepartment getFundingDept();
    @Column(name="MANAGER")
    IEmployee getManager();
    @Persistent(mappedBy="manager")
    @Element(boundTypes=org.apache.jdo.tck.pc.companyAnnotatedPI.PIDSEmployee.class)
    Set getTeam();
    @Column(name="MENTOR")
    IEmployee getMentor();
    @Persistent(mappedBy="mentor")
    IEmployee getProtege();
    @Column(name="HRADVISOR")
    IEmployee getHradvisor();
    @Persistent
    @Element(boundTypes=org.apache.jdo.tck.pc.companyAnnotatedPI.PIDSEmployee.class)
    Set getHradvisees();
    
    void setHiredate(Date hiredate);
    void setWeeklyhours(double weeklyhours);
    void setReviewedProjects(Set reviewedProjects);
    void setProjects(Set projects);
    void setDentalInsurance(IDentalInsurance dentalInsurance);
    void setMedicalInsurance(IMedicalInsurance medicalInsurance);
    void setDepartment(IDepartment department);
    void setFundingDept(IDepartment department);
    void setManager(IEmployee manager);
    void setTeam(Set team);
    void setMentor(IEmployee mentor);
    void setProtege(IEmployee protege);
    void setHradvisor(IEmployee hradvisor);
    void setHradvisees(Set hradvisees);
    
}
