/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectTRA.ProjectTRA.configuration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author kira exia
 */
@Component
public class LoginAccessDeniedHandler implements AccessDeniedHandler{
    
    private static final Logger logger = LoggerFactory.getLogger(LoginAccessDeniedHandler.class);

    public void handle(HttpServletRequest hsr, HttpServletResponse hsr1, AccessDeniedException ade) 
            throws IOException, ServletException {
        Authentication auth 
                = SecurityContextHolder.getContext().getAuthentication();
        
        if (auth!= null) {
            logger.info("User '" + auth.getName() 
                    + "' attempted to access the protected URL:" 
                    + hsr.getRequestURI());
        }
        
        hsr1.sendRedirect(hsr.getContextPath() + "/404");
    }
    
}
