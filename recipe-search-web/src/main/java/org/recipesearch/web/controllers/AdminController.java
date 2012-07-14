package org.recipesearch.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.parancoe.util.MemoryAppender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/*.html")
public class AdminController {

    private static final Logger logger = Logger.getLogger(AdminController.class);

    @RequestMapping
    public String index(HttpServletRequest req, HttpServletResponse res) {
        return "admin/index";
    }

    @RequestMapping
    public ModelAndView logs(HttpServletRequest req, HttpServletResponse res) {
        if ("true".equals(req.getParameter("clean"))) {
            MemoryAppender.clean();
        }

        if ("error".equals(req.getParameter("test"))) {
            logger.error("sample error message");
        }
        if ("warn".equals(req.getParameter("test"))) {
            logger.warn("sample warn message");
        }

        String log = MemoryAppender.getFullLog();
        log = colourLog(log);

        Map params = new HashMap();
        params.put("log", log);
        return new ModelAndView("admin/logs", params);
    }

    @RequestMapping
    public ModelAndView conf(HttpServletRequest req, HttpServletResponse res) {
        return new ModelAndView("admin/conf", null);
    }

    @RequestMapping
    public ModelAndView spring(HttpServletRequest req, HttpServletResponse res) {
        return new ModelAndView("admin/spring", null);
    }

    private String colourLog(String log) {
        String lines[];
        if (log == null) {
            lines = new String[]{""};
        } else {
            lines = log.split("[\\n\\r]");
        }
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].indexOf("[ERROR]") != -1) {
                lines[i] = "<span class=\"log_error\">" + lines[i] + "</span>";
            }
            if (lines[i].indexOf("[WARN]") != -1) {
                lines[i] = "<span class=\"log_warn\">" + lines[i] + "</span>";
            }
            if (StringUtils.isNotBlank(lines[i])) {
                lines[i] += "<br/>";
            }
        }
        return StringUtils.join(lines);
    }
}
