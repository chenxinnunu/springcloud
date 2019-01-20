package com.ruicheng.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * zuul的过滤器
 *
 * @author chenxin@chensanjin.xin
 * @date 2019/1/19 16:56
 */
@Component
public class Filter extends ZuulFilter {
    private static final Logger log = LoggerFactory.getLogger(Filter.class);

    //返回过滤器的类型，有pre、route、post、error等几种取值
    @Override
    public String filterType() {
        return "pre";
    }
    //返回一个int值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字
    @Override
    public int filterOrder() {
        return 0;
    }
    //返回一个boolean值来判断该过滤器是否要执行，true执行，false不执行
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //过滤器的具体逻辑
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        String method = request.getMethod();
        log.info("请求的方法：{}，请求的URI：{}", method, uri);
        // 登录请求不需要进行权限控制
        if (uri.contains("/oauth/token")) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            if ("ROLE_ADMIN".equals(authority.getAuthority()) && method.equalsIgnoreCase("POST")) {
                // 令zuul过滤该请求，不对其进行路由
                ctx.setSendZuulResponse(false);
                // 设置返回的错误码
                ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                // 返回body内容
                ctx.setResponseBody("{\"code\":401, \"msg\":\"没有权限访问\"}");
                return null;
            }
        }
        return null;
    }
}
