package com.software.test.generatingexam.filter;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Order(1)
//重点
@WebFilter(filterName = "sessionFilter", urlPatterns = "/*")
public class SessionFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(SessionFilter.class);

    //标示符：表示当前用户未登录(可根据自己项目需要改为json样式)
    String NO_LOGIN = "没有 session";

    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/user"};


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("过滤器：SessionFilter >>>> 初始化");
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("过滤器：SessionFilter >>>> 执行过滤操作");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();

        System.out.println("filter url:" + uri);
        // 是否需要过滤
        boolean needFilter = isNeedFilter(uri);

        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if(session != null && session.getAttribute("userId") != null) {
                filterChain.doFilter(request, response);
            } else {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("result", false);
                jsonObject.put("message", NO_LOGIN);
                response.getWriter().write(jsonObject.toJSONString());
            }
        }
    }

    /**
     *
     * @Description: 是否需要过滤
     * @param uri
     */
    private boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public void destroy() {
        logger.info("过滤器：SessionFilter >>>> 销毁");
    }
}
