package org.java.web;

import org.java.dao.AjaxDao;
import org.java.entity.Find;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/ajax")
public class AjaxServlet extends HttpServlet {
    private AjaxDao dao=new AjaxDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //转换编码
        request.setCharacterEncoding("utf-8");
     //设置响应格式，防止产生乱码
        response.setContentType("text/html;charset=utf-8");
        //产生一个输出流，用于将数据输出到回调函数中
        PrintWriter out=response.getWriter();
        //获得name的值
        String name = request.getParameter("name");
        //获得集合的值
        List<Find> list = dao.getList(name);

        for (Find k:list) {
            out.write("<div>"+k.getName()+"</div>");
        }

    out.flush();
        out.close();

    }

}
