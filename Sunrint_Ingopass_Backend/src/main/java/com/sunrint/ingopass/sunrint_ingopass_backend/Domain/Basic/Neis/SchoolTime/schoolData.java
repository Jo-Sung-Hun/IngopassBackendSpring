package com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis.SchoolTime;

public class schoolData {
    private String ATPT_OFCDC_SC_CODE;
    private String SD_SCHUL_CODE;
    public schoolData(String ATPT_OFCDC_SC_CODE, String SD_SCHUL_CODE) {
        this.ATPT_OFCDC_SC_CODE = ATPT_OFCDC_SC_CODE;
        this.SD_SCHUL_CODE = SD_SCHUL_CODE;
    }
    public schoolData() {
    }
    public String getATPT_OFCDC_SC_CODE() {
        return ATPT_OFCDC_SC_CODE;
    }

    public void setATPT_OFCDC_SC_CODE(String ATPT_OFCDC_SC_CODE) {
        this.ATPT_OFCDC_SC_CODE = ATPT_OFCDC_SC_CODE;
    }

    public String getSD_SCHUL_CODE() {
        return SD_SCHUL_CODE;
    }

    public void setSD_SCHUL_CODE(String SD_SCHUL_CODE) {
        this.SD_SCHUL_CODE = SD_SCHUL_CODE;
    }


}
