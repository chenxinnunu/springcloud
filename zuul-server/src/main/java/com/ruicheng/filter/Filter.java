package com.ruicheng.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * zuul的过滤器
 *
 * @author chenxin@chensanjin.xin
 * @date 2019/1/19 16:56
 */
@Component
public class Filter extends ZuulFilter {
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
        return null;
    }
}
