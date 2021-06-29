/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.p.l.p0001;

/**
 *
 * @author ASUS
 */
public class Grade implements Comparable{
    Student std;
    Subject sub;
    double lab, test, FE;

    public Grade() {
    }

    public Grade(Student std, Subject sub, double lab, double test, double FE) {
        this.std = std;
        this.sub = sub;
        this.lab = lab;
        this.test = test;
        this.FE = FE;
    }

    

    
    
    public double average(){
        return 0.3*lab + 0.3*test + 0.4*FE;
    }

    public Student getStd() {
        return std;
    }

    public void setStd(Student std) {
        this.std = std;
    }

    public Subject getSub() {
        return sub;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }

    public double getLab() {
        return lab;
    }

    public void setLab(double lab) {
        this.lab = lab;
    }

    public double getTest() {
        return test;
    }

    public void setTest(double test) {
        this.test = test;
    }

    public double getFE() {
        return FE;
    }

    public void setFE(double FE) {
        this.FE = FE;
    }

//    public int compareToStudent(Object std) {
//        return this.getStd().getStdId().compareTo(((Student)std).getStdId());
//    }
//    
//    public int compareToSubject(Object sub) {
//        return this.getSub().getSubID().compareTo(((Subject)sub).getSubID());
//    }

    @Override
    public int compareTo(Object o) {
        return (this.getSub().getSubID().compareTo(((Subject)sub).getSubName()));
    }
    
}
