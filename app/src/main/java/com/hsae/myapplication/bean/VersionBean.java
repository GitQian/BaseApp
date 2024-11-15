package com.hsae.myapplication.bean;

/**
 * Description:
 *
 * @author: QianSheng
 * @date: 2024/11/14
 */
public class VersionBean {


    private String softVersion;
    private String hwVersion;

    public VersionBean() {
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    public String getHwVersion() {
        return hwVersion;
    }

    public void setHwVersion(String hwVersion) {
        this.hwVersion = hwVersion;
    }

}
