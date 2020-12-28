package com.vance.springbootcucumber.service;

import com.vance.springbootcucumber.entity.BlackListPan;
import com.vance.springbootcucumber.entity.PanInfo;
import com.vance.springbootcucumber.repository.BlackListPanRepository;
import com.vance.springbootcucumber.repository.PanInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@AllArgsConstructor
@Service
public class AuthenticationService {

    private final PanInfoRepository panInfoRepo;
    private final BlackListPanRepository blackListPanRepo;

    public Map doAuthentication(Map aReq) {
        String acctNumber = aReq.get("acctNumber").toString();

        PanInfo panInfo = panInfoRepo.findByCardNumber(acctNumber).orElse(null);
        boolean isExistsInBlackListPan = false;
        if (panInfo == null) {
            // Save panInfo
            panInfo = new PanInfo();
            panInfo.setCardNumber(acctNumber);
            panInfoRepo.save(panInfo);
        } else {
            BlackListPan blackListPan = blackListPanRepo.findByPanInfoId(panInfo.getId()).orElse(null);
            isExistsInBlackListPan = blackListPan != null;
        }

        Map aRes = new LinkedHashMap();
        String transStatus;
        if (isExistsInBlackListPan) {
            transStatus = "N";
        } else {
            transStatus = "Y";
        }
        aRes.put("transStatus", transStatus);
        return aRes;
    }
}
