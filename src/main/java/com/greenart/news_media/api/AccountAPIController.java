package com.greenart.news_media.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.FlashMap;

import com.greenart.news_media.data.AccountInfoVO;
import com.greenart.news_media.mapper.AccountMapper;
import com.greenart.news_media.utils.AESAlgorithm;

import ch.qos.logback.core.status.Status;

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

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> getAccountInfo(@RequestBody AccountInfoVO data, HttpSession session) throws Exception {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        HttpStatus stat = null;
        if(data.getAi_id() == null || data.getAi_id() == "" || data.getAi_pwd() == null || data.getAi_pwd() == "") {
            m.put("status", false);
            m.put("msg", "아이디 비밀번호를 입력해주세요");
            stat = HttpStatus.BAD_REQUEST;
        }
        else if(data.getAi_pwd().length() < 6) {
            m.put("status", false);
            m.put("msg", "6자리 이상의 비밀번호를 입력해주세요");
            stat = HttpStatus.BAD_REQUEST;
        }
        else {
            try {
                data.setAi_pwd(AESAlgorithm.Encrypt(data.getAi_pwd()));
            }
            catch(Exception e) {
                m.put("status", false);
                m.put("msg", "암호화 실패");
                stat =HttpStatus.INTERNAL_SERVER_ERROR;
            }
            if(acc_mapper.selectLogin(data) == true) {
                m.put("status", true);
                m.put("msg", "로그인 성공");
                stat = HttpStatus.ACCEPTED;
                AccountInfoVO user = acc_mapper.selectAccountLogin(data);
                m.put("sessionInfo", user);
                session.setAttribute("sessionInfo", user);
            }else {
                m.put("status", false);
                m.put("msg", "아이디 비밀번호를 확인해주세요");
                stat = HttpStatus.FORBIDDEN;
            }
        }
        return new ResponseEntity<Map<String, Object>>(m, stat);
    }

    @PostMapping("/search")
    public ResponseEntity<Map<String, Object>> getSearchAccount(@RequestBody AccountInfoVO data, HttpSession session) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        HttpStatus stat = null;

        if(data.getAi_id() == null || data.getAi_id() == "") {
            if(data.getAi_name() == null || data.getAi_name() == "") {
                m.put("status", false);
                m.put("msg", "아이디를 입력해주세요");
                stat = HttpStatus.BAD_REQUEST;
            }else if(data.getAi_phone() == null || data.getAi_phone() == ""){
                m.put("status", false);
                m.put("msg", "전화번호를 입력해주세요");
                stat = HttpStatus.BAD_REQUEST;
            }else{
                if(acc_mapper.selectSearchCheckId(data)) {
                    acc_mapper.selectSearchId(data);
                    System.out.println(acc_mapper.selectSearchId(data).getAi_id());
                    m.put("status", true);
                    m.put("msg", "조회ID : "+acc_mapper.selectSearchId(data).getAi_id());
                    stat = HttpStatus.ACCEPTED;
                    m.put("url", "/user/search");
                }else {
                    m.put("status", false);
                    m.put("msg", "이름과 전화번호를 확인해주세요");
                    stat = HttpStatus.FORBIDDEN;
                }
            } 
        }
        else {
            if(data.getAi_id() == null || data.getAi_id() == "") {
                m.put("status", false);
                m.put("msg", "아이디를 입력해주세요");
                stat = HttpStatus.BAD_REQUEST;
            } else if(data.getAi_name() == null || data.getAi_name() == ""){
                m.put("status", false);
                m.put("msg", "이름을 입력해주세요");
                stat = HttpStatus.BAD_REQUEST;
            } else if(data.getAi_phone() == null || data.getAi_phone() == ""){
                m.put("status", false);
                m.put("msg", "전화번호를 입력해주세요.");
                stat = HttpStatus.BAD_REQUEST;
            } else {
                if(acc_mapper.selectSearchPwd(data.getAi_id(), data.getAi_name(), data.getAi_phone())) {
                    m.put("status", true);
                    m.put("msg", "조회되었습니다.");
                    acc_mapper.selectSearchSeq(data);
                    m.put("url", "/user/pwd_change?seq="+acc_mapper.selectSearchSeq(data).getAi_seq());
                    System.out.println(acc_mapper.selectSearchSeq(data));
                    stat = HttpStatus.OK;
                }else {
                    m.put("status", false);
                    m.put("msg", "입력하신 정보를 확인해주세요");                    
                    stat = HttpStatus.FORBIDDEN;
                }
            }
        }


        return new ResponseEntity<Map<String, Object>>(m, stat);
    }

    @PatchMapping("/update/pwd")
    public ResponseEntity<Map<String,Object>> updateUserPwd(@RequestParam Integer seq, @RequestParam String pwd ) throws Exception {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        HttpStatus stat = null;
        if(pwd.length() < 6) {
            m.put("status", false);
            m.put("msg", "비밀번호는 6자리를 넘겨야 합니다.");
            stat = HttpStatus.BAD_REQUEST;
        } else {
            pwd = AESAlgorithm.Encrypt(pwd);
            acc_mapper.updateUserPwd(seq, pwd);
            m.put("status", true);
            m.put("msg", "변경되었습니다.");
            stat = HttpStatus.OK;
        }
        
        return new ResponseEntity<Map<String, Object>>(m, stat);
    }
    @GetMapping("/logout")
    public String getAccountLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @PatchMapping("/update/info")
    public ResponseEntity<Map<String,Object>> updateUserInfo(@RequestBody AccountInfoVO data) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        HttpStatus stat = null;

        if(data.getAi_pwd().length() < 6) {
            m.put("status", false);
            m.put("msg", "비밀번호는 6자리를 넘겨야합니다.");
            stat = HttpStatus.BAD_REQUEST;
        }else if(data.getAi_name().length() < 1 || data.getAi_name() == null || data.getAi_name() == "") {
            m.put("status", false);
            m.put("msg", "이름을 입력해주세요");
            stat = HttpStatus.BAD_REQUEST;
        }else if(data.getAi_phone().length() < 11 || data.getAi_phone() == null || data.getAi_name() == "") {
            m.put("status", false);
            m.put("msg", "휴대전화 번호는 11자리를 넘겨야합니다.");
            stat = HttpStatus.BAD_REQUEST;
        }else if(acc_mapper.isDuplicatePhone(data.getAi_phone())) {
            m.put("status", false);
            m.put("msg", "이미 등록된 전화번호입니다.");
            stat = HttpStatus.BAD_REQUEST;
        } else {
            try{
                data.setAi_pwd(AESAlgorithm.Encrypt(data.getAi_pwd()));
            }
            catch(Exception e) {
                m.put("status", false);
                m.put("msg", "비밀번호 암호화 실패");
                stat = HttpStatus.BAD_REQUEST;
            }
            acc_mapper.updateUserInfo(data);
            m.put("status", true);
            m.put("msg", "수정되었습니다.");
            stat = HttpStatus.OK;
        }
        return new ResponseEntity<Map<String,Object>>(m, stat);
    }
}
