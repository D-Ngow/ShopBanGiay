/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.sql.Date;


/**
 *
 * @author LENOVO
 */
public class calam {
    public int mnv;
    public Date calam;

    public calam() {
    }

    public calam(int mnv, Date calam) {
        this.mnv = mnv;
        this.calam = calam;
    }

    public int getMnv() {
        return mnv;
    }

    public Date getCalam() {
        return calam;
    }

    public void setMnv(int mnv) {
        this.mnv = mnv;
    }

    public void setCalam(Date calam) {
        this.calam = calam;
    }
    
}
