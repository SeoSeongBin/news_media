package com.greenart.news_media.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.news_media.data.AccountInfoVO;
import com.greenart.news_media.mapper.AccountMapper;
import com.greenart.news_media.utils.AESAlgorithm;

@RestController
@RequestMapping("/api/account")
public class AccountAPIController {
    @Autowired AccountMapper acc_mapper;
    @PutMapping("/add")
    public ResponseEntity<Map<String, Object>> putAccountAdd(@RequestBody AccountInfoVO data, HttpSession session) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        HttpStatus stat = null;
        if(acc_mapper.isDuplicateId(data.getAi_id())) {
            m.put("status", false);
            m.put("msg", "이미 존재하는 아이디 입니다.");
            stat = HttpStatus.BAD_REQUEST;
        } else if(data.getAi_pwd().length() < 6) {
            m.put("status", false);
            m.put("msg", "비밀번호는 6자리 이상 입력해야합니다.");
            stat = HttpStatus.BAD_REQUEST;
        }else if(acc_mapper.isDuplicatePhone(data.getAi_phone())) {
            m.put("status", false);
            m.put("msg", "이미 존재하는 전화번호입니다.");
            stat = HttpStatus.BAD_REQUEST;
        }else {
            try{
                data.setAi_pwd(AESAlgorithm.Encrypt(data.getAi_pwd()));
            }
            catch(Exception e) {
                m.put("status", false);
                m.put("msg", "암호화 오류");
                stat = HttpStatus.BAD_REQUEST;
            }
            acc_mapper.putAccount(data);
            m.put("status", true);
            m.put("msg", "회원가입이 완료되었습니다.");
        }
        System.out.println(new ResponseEntity<Map<String,Object>>(m, HttpStatus.CREATED));
        return new ResponseEntity<Map<String,Object>>(m, HttpStatus.CREATED);
    }
}
