package com.how2java.tmall.interceptor;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.OrderItemService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author aaron
 * @date 2019-08-28 19:53
 * @description 登录过滤器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private OrderItemService orderItem;

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String [] noNeedAuthPage = new String[]{
                "home",
                "checkLogin",
                "register",
                "loginAjax",
                "login",
                "product",
                "category",
                "search"

        };
        String url = request.getRequestURI();
        url = StringUtils.remove(url, contextPath);
        System.out.println(url);
        if (url.startsWith("/fore")){
            String method = StringUtils.substringAfterLast(url,"/fore");
            if(!Arrays.asList(noNeedAuthPage).contains(method)){
                User user = (User) session.getAttribute("user");
                if(null==user){
                    response.sendRedirect("loginPage");
                return  false;
            }
            }
        }
        return true;
    }

    /**
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作
     * 可在modelAndView中加入数据,如当前时间
     */
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           ModelAndView modelAndView) throws Exception{
        LocalDateTime localDateTime = LocalDateTime.now();
        modelAndView.addObject(localDateTime);

    }


    /**
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
     *  当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     */
     @Override
      public void afterCompletion(HttpServletRequest request,HttpServletResponse response,
                                  Object handler,Exception e)throws Exception{

      }


}
