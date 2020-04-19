package org.vance.cart.model.zentao;

/**
 * @Description: TODO
 * @Author: gaofan 12183
 */
public class ZentaoProjectBuild {
    // 项目名称 (必填)
    private String name;
    // 项目代号 (必填)
    private String code;
    // 起始日期【时间格式：2019-11-20】(必填)
    private String begin;
    // 结束日期【时间格式：2019-11-20】(必填)
    private String end;
//    // 可用工作日
//    private int days;
//    // 团队名称
//    private String team;
//    // 项目类型【sprint短期项目|waterfall长期项目|ops运维项目】
//    private String type;
//    // 项目描述
//    private String desc;
//    // 访问控制【open默认设置|private私有项目|custom白名单】
//    private String acl;

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

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

//    public int getDays() {
//        return days;
//    }
//
//    public void setDays(int days) {
//        this.days = days;
//    }
//
//    public String getTeam() {
//        return team;
//    }
//
//    public void setTeam(String team) {
//        this.team = team;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
//    public String getAcl() {
//        return acl;
//    }
//
//    public void setAcl(String acl) {
//        this.acl = acl;
//    }
}
