
package com.balamurugan.cocubesmessagenotification.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("NID")
    @Expose
    private Long nID;
    @SerializedName("ID")
    @Expose
    private Long iD;
    @SerializedName("F")
    @Expose
    private String f;
    @SerializedName("T")
    @Expose
    private String t;
    @SerializedName("In")
    @Expose
    private Boolean in;
    @SerializedName("HA")
    @Expose
    private Boolean hA;
    @SerializedName("S")
    @Expose
    private String s;
    @SerializedName("D")
    @Expose
    private String d;
    @SerializedName("N")
    @Expose
    private Boolean n;
    @SerializedName("Del")
    @Expose
    private Boolean del;
    @SerializedName("JId")
    @Expose
    private Long jId;
    @SerializedName("RGUID")
    @Expose
    private String rGUID;
    @SerializedName("gpl")
    @Expose
    private String gpl;
    @SerializedName("ir")
    @Expose
    private Boolean ir;
    @SerializedName("irp")
    @Expose
    private Boolean irp;
    @SerializedName("sc")
    @Expose
    private Long sc;
    @SerializedName("clc")
    @Expose
    private Long clc;
    @SerializedName("cmc")
    @Expose
    private Long cmc;

    public Long getNID() {
        return nID;
    }

    public void setNID(Long nID) {
        this.nID = nID;
    }

    public Long getID() {
        return iD;
    }

    public void setID(Long iD) {
        this.iD = iD;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public Boolean getIn() {
        return in;
    }

    public void setIn(Boolean in) {
        this.in = in;
    }

    public Boolean getHA() {
        return hA;
    }

    public void setHA(Boolean hA) {
        this.hA = hA;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public Boolean getN() {
        return n;
    }

    public void setN(Boolean n) {
        this.n = n;
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    public Long getJId() {
        return jId;
    }

    public void setJId(Long jId) {
        this.jId = jId;
    }

    public String getRGUID() {
        return rGUID;
    }

    public void setRGUID(String rGUID) {
        this.rGUID = rGUID;
    }

    public String getGpl() {
        return gpl;
    }

    public void setGpl(String gpl) {
        this.gpl = gpl;
    }

    public Boolean getIr() {
        return ir;
    }

    public void setIr(Boolean ir) {
        this.ir = ir;
    }

    public Boolean getIrp() {
        return irp;
    }

    public void setIrp(Boolean irp) {
        this.irp = irp;
    }

    public Long getSc() {
        return sc;
    }

    public void setSc(Long sc) {
        this.sc = sc;
    }

    public Long getClc() {
        return clc;
    }

    public void setClc(Long clc) {
        this.clc = clc;
    }

    public Long getCmc() {
        return cmc;
    }

    public void setCmc(Long cmc) {
        this.cmc = cmc;
    }

}
