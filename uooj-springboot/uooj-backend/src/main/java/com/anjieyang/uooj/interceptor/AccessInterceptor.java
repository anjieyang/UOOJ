package com.anjieyang.uooj.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import com.anjieyang.uooj.annotation.UOOJAccess;
import com.anjieyang.uooj.annotation.UOOJAccessEnum;
import com.anjieyang.uooj.utils.ServiceContextUtils;
import com.anjieyang.uooj.validator.AccessValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Anjie Yang
 * @Date 2022/5/9
 */
@Component
public class AccessInterceptor implements HandlerInterceptor {

    @Autowired
    private AccessValidator accessValidator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = HandlerMethod.class.cast(handler);
            UOOJAccess UOOJAccess = ServiceContextUtils.getAnnotation(handlerMethod.getMethod(), handlerMethod.getBeanType(), UOOJAccess.class);
            if (UOOJAccess == null || UOOJAccess.value().length == 0) {
                return true;
            }
            for (UOOJAccessEnum value : UOOJAccess.value()) {
                accessValidator.validateAccess(value);
            }
            return true;
        }else if (handler instanceof ResourceHttpRequestHandler){
            // 静态资源的请求不处理
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
