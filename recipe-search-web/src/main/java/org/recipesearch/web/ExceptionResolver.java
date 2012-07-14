package org.recipesearch.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Ovverride ExceptionResolver to define custom web application Exception.
 * Should be mapped in parancoe-servlet.xml
 * @author Lucio Benfante <lucio.benfante@gmail.com>
 */
public class ExceptionResolver extends org.parancoe.web.ExceptionResolver {

    private static final Logger logger =
            Logger.getLogger(ExceptionResolver.class);
    private CommonsMultipartResolver multipartResolver;

    public CommonsMultipartResolver getMultipartResolver() {
        return multipartResolver;
    }

    public void setMultipartResolver(CommonsMultipartResolver multipartResolver) {
        this.multipartResolver = multipartResolver;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest req,
            HttpServletResponse res, Object object, Exception e) {
        try {
            if (!interceptedWithMinimalLogging(e)) {
                logger.error("Unexpected exception", e);
            }
            logger.info("Exception requesting URL: " + req.getRequestURL().
                    toString());
            logger.info("  request from " + req.getRemoteHost() + "(" + req.
                    getRemoteAddr() + ")");
            return super.resolveException(req, res, object, e);
        } catch (Exception ex) {
            logger.error("Error resolving exception", ex);
        }
        return new ModelAndView("redirect:/home/internalServerError.html");
    }

    private boolean interceptedWithMinimalLogging(Exception e) {
        boolean intercepted = false;
        // Discarding too generic exception, with unuseful stacktrace...so minimal log output.
        // Maybe some could be moved to the base class.
        if ((e instanceof HttpSessionRequiredException)
                || (e instanceof MultipartException)) {
            if (logger.isDebugEnabled()) {
                logger.debug(e.getLocalizedMessage(), e);
            } else {
                logger.error("[" + e.getClass().getName() + "] " + e.
                        getLocalizedMessage());
            }
            intercepted = true;
        }
        return intercepted;
    }
}
