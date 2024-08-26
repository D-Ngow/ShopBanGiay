/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

/**
 *
 * @author LENOVO
 */
public class tkmk {
    public String tk;
    public String mk;
    public boolean vaitro;

    public tkmk() {
    }

    public tkmk(String tk, String mk, boolean vaitro) {
        this.tk = tk;
        this.mk = mk;
        this.vaitro = vaitro;
    }

    public String getTk() {
        return tk;
    }

    public String getMk() {
        return mk;
    }

    public boolean isVaitro() {
        return vaitro;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public void setVaitro(boolean vaitro) {
        this.vaitro = vaitro;
    }
    
}
