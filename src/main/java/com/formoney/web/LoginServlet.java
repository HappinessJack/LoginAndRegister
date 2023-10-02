package com.formoney.web;

import com.formoney.pojo.User;
import com.formoney.service.LoginService;
import com.formoney.service.RegisterService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*允许跨域
        * Allow cross-origin*/
        resp.setHeader("Access-Control-Allow-Origin","*");
        Enumeration<String> parameterNames = req.getParameterNames();
            /*
            创建user对象,
            create user object
            */
        boolean result = false;
        User user = new User();
        String passwordKey=null;
        String usernameKey=null;
        //防止乱码,设置返回类型和字符集
        //prevent garbage-characters,function: set result type and charset;
        resp.setContentType("text/html;charset=utf-8");
        //获取对应的key(or parameterName)名称
        if (parameterNames.hasMoreElements()){
             usernameKey = parameterNames.nextElement();
        }
if(parameterNames.hasMoreElements()){ passwordKey = parameterNames.nextElement();
}
        /*通过请求的key来判断是登录还是注册
           * judge login or register by key of request*/
        if ("loginUsername".equals(usernameKey)){
            user.setUsername(req.getParameter(usernameKey));
user.setPassword(req.getParameter(passwordKey));
          LoginService service =  new LoginService();
             result = service.login(user);
resp.getWriter().write(result+"");
        }else{
            /*注册
            * register*/
            user.setUsername(req.getParameter(usernameKey));
            user.setPassword(req.getParameter(passwordKey));
            RegisterService registerService = new RegisterService();
           result =   registerService.register(user);
           resp.getWriter().write(result+"");


        }

//        while (parameterNames.hasMoreElements()){
//            String s = parameterNames.nextElement();
//
//
//            //第一个获取到的是用户名的parameterName
//            //第二个获取到的是密码的parameterName.
//            String parameter = req.getParameter(s);
//
//            /*
//            创建user对象,
//            create user object
//            */
//
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
