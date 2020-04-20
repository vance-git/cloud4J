package org.vance.cart.model.zentao;

public class ZentaoProjectBasic {

    // 项目ID （全局唯一，用于定位项目）
    private String projectId;
    // 项目名称
    private String projectName;

    public ZentaoProjectBasic(String projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
