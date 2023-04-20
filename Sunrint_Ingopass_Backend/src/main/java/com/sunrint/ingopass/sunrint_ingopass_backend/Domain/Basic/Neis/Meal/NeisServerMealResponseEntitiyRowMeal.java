package com.sunrint.ingopass.sunrint_ingopass_backend.Domain.Basic.Neis.Meal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;



@Entity
public class NeisServerMealResponseEntitiyRowMeal {
    private String ATPT_OFCDC_SC_CODE;
    private String ATPT_OFCDC_SC_NM;
    private String CAL_INFO;
    private String DDISH_NM;
    private String MLSV_FGR;
    private String MLSV_FROM_YMD;
    private String MLSV_TO_YMD;
    private String MLSV_YMD;
    private String MMEAL_SC_CODE;
    private String MMEAL_SC_NM;
    private String NTR_INFO;
    private String ORPLC_INFO;
    private String SCHUL_NM ;
    private String SD_SCHUL_CODE;
    @Id
    private Long id;

    @Builder
    public NeisServerMealResponseEntitiyRowMeal(String ATPT_OFCDC_SC_CODE, String ATPT_OFCDC_SC_NM, String CAL_INFO, String DDISH_NM, String MLSV_FGR, String MLSV_FROM_YMD, String MLSV_TO_YMD, String MLSV_YMD, String MMEAL_SC_CODE, String MMEAL_SC_NM, String NTR_INFO, String ORPLC_INFO, String SCHUL_NM, String SD_SCHUL_CODE) {
        this.ATPT_OFCDC_SC_CODE = ATPT_OFCDC_SC_CODE;
        this.ATPT_OFCDC_SC_NM = ATPT_OFCDC_SC_NM;
        this.CAL_INFO = CAL_INFO;
        this.DDISH_NM = DDISH_NM;
        this.MLSV_FGR = MLSV_FGR;
        this.MLSV_FROM_YMD = MLSV_FROM_YMD;
        this.MLSV_TO_YMD = MLSV_TO_YMD;
        this.MLSV_YMD = MLSV_YMD;
        this.MMEAL_SC_CODE = MMEAL_SC_CODE;
        this.MMEAL_SC_NM = MMEAL_SC_NM;
        this.NTR_INFO = NTR_INFO;
        this.ORPLC_INFO = ORPLC_INFO;
        this.SCHUL_NM = SCHUL_NM;
        this.SD_SCHUL_CODE = SD_SCHUL_CODE;
    }

    public NeisServerMealResponseEntitiyRowMeal() {
    }

    public String getATPT_OFCDC_SC_CODE() {
        return ATPT_OFCDC_SC_CODE;
    }

    public void setATPT_OFCDC_SC_CODE(String ATPT_OFCDC_SC_CODE) {
        this.ATPT_OFCDC_SC_CODE = ATPT_OFCDC_SC_CODE;
    }

    public String getATPT_OFCDC_SC_NM() {
        return ATPT_OFCDC_SC_NM;
    }

    public void setATPT_OFCDC_SC_NM(String ATPT_OFCDC_SC_NM) {
        this.ATPT_OFCDC_SC_NM = ATPT_OFCDC_SC_NM;
    }

    public String getCAL_INFO() {
        return CAL_INFO;
    }

    public void setCAL_INFO(String CAL_INFO) {
        this.CAL_INFO = CAL_INFO;
    }

    public String getDDISH_NM() {
        return DDISH_NM;
    }

    public void setDDISH_NM(String DDISH_NM) {
        this.DDISH_NM = DDISH_NM;
    }

    public String getMLSV_FGR() {
        return MLSV_FGR;
    }

    public void setMLSV_FGR(String MLSV_FGR) {
        this.MLSV_FGR = MLSV_FGR;
    }

    public String getMLSV_FROM_YMD() {
        return MLSV_FROM_YMD;
    }

    public void setMLSV_FROM_YMD(String MLSV_FROM_YMD) {
        this.MLSV_FROM_YMD = MLSV_FROM_YMD;
    }

    public String getMLSV_TO_YMD() {
        return MLSV_TO_YMD;
    }

    public void setMLSV_TO_YMD(String MLSV_TO_YMD) {
        this.MLSV_TO_YMD = MLSV_TO_YMD;
    }

    public String getMLSV_YMD() {
        return MLSV_YMD;
    }

    public void setMLSV_YMD(String MLSV_YMD) {
        this.MLSV_YMD = MLSV_YMD;
    }

    public String getMMEAL_SC_CODE() {
        return MMEAL_SC_CODE;
    }

    public void setMMEAL_SC_CODE(String MMEAL_SC_CODE) {
        this.MMEAL_SC_CODE = MMEAL_SC_CODE;
    }

    public String getMMEAL_SC_NM() {
        return MMEAL_SC_NM;
    }

    public void setMMEAL_SC_NM(String MMEAL_SC_NM) {
        this.MMEAL_SC_NM = MMEAL_SC_NM;
    }

    public String getNTR_INFO() {
        return NTR_INFO;
    }

    public void setNTR_INFO(String NTR_INFO) {
        this.NTR_INFO = NTR_INFO;
    }

    public String getORPLC_INFO() {
        return ORPLC_INFO;
    }

    public void setORPLC_INFO(String ORPLC_INFO) {
        this.ORPLC_INFO = ORPLC_INFO;
    }

    public String getSCHUL_NM() {
        return SCHUL_NM;
    }

    public void setSCHUL_NM(String SCHUL_NM) {
        this.SCHUL_NM = SCHUL_NM;
    }

    public String getSD_SCHUL_CODE() {
        return SD_SCHUL_CODE;
    }

    public void setSD_SCHUL_CODE(String SD_SCHUL_CODE) {
        this.SD_SCHUL_CODE = SD_SCHUL_CODE;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
