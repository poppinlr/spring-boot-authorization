package spring.boot.security.demo.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j
public class DemoController {

    @Autowired
    private ClientDetailsService clientDetailsService;

    @GetMapping("/youdong")
    public String ip() {
        return this.log();
    }

    @GetMapping("/public")
    public String getPublic() {
        return this.log();
    }

    @GetMapping("/user")
    public String getUser() {
        return this.log();
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return this.log();
    }

    @GetMapping("/client")
    public String getClient() {
        return this.log();
    }

    private String log() {
        clientDetailsService.loadClientByClientId("tonr");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("isAuthenticated:--------------------------");
        log.info(authentication.isAuthenticated());
        log.info("getCredentials:--------------------------");
        log.info(authentication.getCredentials());
        log.info("getDetails:--------------------------");
        log.info(authentication.getDetails());
        log.info("getPrincipal:--------------------------");
        log.info(authentication.getPrincipal());
        log.info("getAuthorities:--------------------------");
        log.info(authentication.getAuthorities());
        log.info("getName:--------------------------");
        log.info(authentication.getName());
        return authentication.getName();
    }
}

