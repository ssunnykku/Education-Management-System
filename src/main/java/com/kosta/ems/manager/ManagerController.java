package com.kosta.ems.manager;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/managers")
@RequiredArgsConstructor
@Slf4j
public class ManagerController {
    private final ManagerService managerService;

    //Controller처럼 작동함
    @PostMapping("/login")
    public Map login(@RequestBody Map<String, String> loginRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String> map = managerService.login(loginRequest.get("employeeNumber"), loginRequest.get("password"));
        if (Objects.isNull(map)) {
            return Map.of("result", false);
        }
        HttpSession session = request.getSession();
        session.setAttribute("managerId", map.get("managerId"));
        session.setAttribute("academyLocation", map.get("academyLocation"));
        log.info("managerId: " + map.get("managerId").toString());
        log.info("managerId: " + map.get("academyLocation").toString());

        return Map.of("result", true);
    }
}

