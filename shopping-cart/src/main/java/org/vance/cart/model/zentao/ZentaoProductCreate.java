package org.vance.cart.model.zentao;

public class ZentaoProductCreate {

    //  产品名称(必填)
    private String name;
    //  产品代号(必填)
    private String code;
    //  产品线ID
    private int line;
    // 	产品负责人账号
    private String PO;
    //  测试负责人账号
    private String QD;
    // 	发布负责人账号
    private String RD;
    // 	产品类型【normal正常|branch多分支|platform多平台】
    private String type;
    //	产品描述
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public String getPO() {
        return PO;
    }

    public void setPO(String PO) {
        this.PO = PO;
    }

    public String getQD() {
        return QD;
    }

    public void setQD(String QD) {
        this.QD = QD;
    }

    public String getRD() {
        return RD;
    }

    public void setRD(String RD) {
        this.RD = RD;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
