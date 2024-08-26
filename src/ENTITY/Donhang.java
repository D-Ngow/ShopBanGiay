
package ENTITY;

import java.sql.Date;

public class Donhang {
    public String mhd;
    public Date ngayxuat;
    public int mnv;
    public int mak;

    public Donhang() {
    }

    public Donhang(String mhd, Date ngayxuat, int mnv, int mak) {
        this.mhd = mhd;
        this.ngayxuat = ngayxuat;
        this.mnv = mnv;
        this.mak = mak;
    }

    public String getMhd() {
        return mhd;
    }

    public Date getNgayxuat() {
        return ngayxuat;
    }

    public int getMnv() {
        return mnv;
    }

    public int getMak() {
        return mak;
    }

    public void setMhd(String mhd) {
        this.mhd = mhd;
    }

    public void setNgayxuat(Date ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public void setMnv(int mnv) {
        this.mnv = mnv;
    }

    public void setMak(int mak) {
        this.mak = mak;
    }

    
    
}
