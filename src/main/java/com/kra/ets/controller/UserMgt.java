package com.kra.ets.controller;

import com.kra.ets.Service.LdapService;
import com.kra.ets.model.PostBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;




    @RestController
    @RequestMapping("/userMgt")
    public class UserMgt {

        @Autowired
        LdapService contact;

        @PostMapping(value = "/login", produces = "application/json")
        public Object find(@RequestBody PostBody request, @RequestHeader("Authorization") Optional<String> token) {
            Object response =null;
            byte[] decodedBytes = Base64.getDecoder().decode(request.getPassword());
            String password = new String(decodedBytes);
            Boolean result = contact.authenticate(request.getStaffNo(), password);
            //Boolean result = true;
            if(result.equals(true)){
                Map<String, Object> body = new HashMap<>();
                body.put("staffNo", request.getStaffNo());
                body.put("status", 1);
                body.put("token", getToken());
                response = body;
            }else {
                Map<String, Object> body = new HashMap<>();
                body.put("staffNo", null);
                body.put("status", 0);
                body.put("massage", "Wrong username/password");
                response = body;
            }

            return response;
        }

        private Object getToken(){
            Random rand = new Random();
            int bit = rand.nextInt(10000);

            return "df7853c2b827cc097f83f7e916768da8".concat(String.valueOf(bit));
        }

    }


