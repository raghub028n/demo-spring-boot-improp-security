package com.raghu.sample.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.util.ObjectUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

@Slf4j
public class CorsFilter implements Filter {

    static final Pattern HOST_ALLOWED_PATTERN = Pattern.compile("(.*\\.website.com)|.*localhost", Pattern.CASE_INSENSITIVE);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //NOOP
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("Inside Cors Filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String origin = request.getHeader(HttpHeaders.ORIGIN);

        if (!ObjectUtils.isEmpty(origin)) {
            String hostName = new URL(origin).getHost();
            if (HOST_ALLOWED_PATTERN.matcher(hostName).matches()) {
                response.setHeader("ACCESS-CONTROL-ALLOW-ORIGIN", origin);
                response.setHeader("ACCESS-CONTROL-REQUEST-METHOD", "*");
                response.setHeader("ACCESS-CONTROL-ALLOW-HEADERS", "ACCESS-CONTROL-ALLOW-HEADERS, Origin, Accept, X-Requested-With, Content-Type");
                response.setHeader("Vary", "Origin");
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //NOOP
    }
}
