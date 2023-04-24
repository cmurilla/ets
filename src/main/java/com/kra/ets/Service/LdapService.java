package com.kra.ets.Service;


import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@EnableJpaRepositories(basePackages = {"com.example.Mla"})
public class LdapService {
    @Autowired
    private LdapTemplate ldapTemplate;
    @Autowired
    LdapContextSource contextSource;

    @Value("${spring.ldap.domain}")
    String rootdomain;
    @Value("${spring.ldap.orgunit}")
    String organizationalUnit;

    @Value("${spring.ldap.urls}")
    String Url;

    @Value("${spring.ldap.username}")
    String username;

    @Value("${spring.ldap.password}")
    String password;

    Logger LOG = LogManager.getLogger(LdapService.class);
    public List<com.kra.ets.Service.ContactWrapper> search(String username) {
        ldapTemplate.setIgnorePartialResultException(true);
        String base = "DC=" + rootdomain + ",DC=" + organizationalUnit;//DC=KRA,DC=GOV
        List<com.kra.ets.Service.ContactWrapper> userlist = new ArrayList<>();
        try {
            //ldapTemplate.authenticate(base,"(&(objectCategory=person)(sAMAccountName=" + username + "))",password);
            userlist = ldapTemplate.search(
                    base,
                    "(&(objectCategory=person)(sAMAccountName=" + username + ")(|(mobile=*)(ipPhone=*)(telephoneNumber=*)(mail=*)))",
                    (AttributesMapper<com.kra.ets.Service.ContactWrapper>) attrs -> {
                        com.kra.ets.Service.ContactWrapper contactWrapper = new com.kra.ets.Service.ContactWrapper();
                        if (attrs.get("mail") != null) {
//                        contactWrapper.setEmail((String)attrs.get("mail").get());
                            contactWrapper.setEmail(Optional.of((String) attrs.get("mail").get()));
                        }
                        if (attrs.get("mobile") != null) {
//                        contactWrapper.setMobile((String)attrs.get("mobile").get());
                            LOG.info(attrs.get("mobile").get());
                            contactWrapper.setPhonenumber(Optional.of((String) attrs.get("mobile").get()));
                        }
                        if (attrs.get("telephoneNumber") != null && contactWrapper.getPhonenumber() == null) {
                            LOG.info(attrs.get("telephoneNumber").get());

//                        contactWrapper.setPhonenumber((String)attrs.get("telephoneNumber").get());
                            contactWrapper.setPhonenumber(Optional.of((String) attrs.get("telephoneNumber").get()));
                        }
                        return contactWrapper;
                    });
        } catch (Exception es) {
            // log.error(es.getMessage(), es);
        }

        return userlist;
    }

    public boolean authenticate(String username, String password) {
        ldapTemplate.setIgnorePartialResultException(true);
        String base = "DC=" + rootdomain + ",DC=" + organizationalUnit;//DC=KRA,DC=GOV
        Boolean repo = ldapTemplate.authenticate(base,"(&(objectCategory=person)(sAMAccountName=" + username + "))",password);

        log.info(repo.toString());
        return repo;
    }


}
