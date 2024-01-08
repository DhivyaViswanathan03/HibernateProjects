package com.divs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;

import com.divs.dto.InsurancePolicyDto;
import com.divs.service.IInsurancePolicyService;
import com.divs.service.InsurancePolicyServiceImpl;


@WebServlet(urlPatterns = "/controller",loadOnStartup = 1)
public class MainController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IInsurancePolicyService service=null;
	
	public void init() {
		service=new InsurancePolicyServiceImpl();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo=0;
		Long pageCount=0L;
		Integer pageSize=0;
		String targetUrl="";
		RequestDispatcher rd=null;
		
		HttpSession session=null;
		session=request.getSession(true);
	
		String value=request.getParameter("s1");
		
		if(value.equalsIgnoreCase("GenerateReport")) {
			pageNo=1;
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
			if(session!=null) {
				session.setAttribute("pageSize", pageSize);
			}
	
		}else {
			if(session!=null) {
				pageSize=(int)session.getAttribute("pageSize");
			}
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}
		
		try {
			pageCount=service.fetchPageCount(pageSize);
			List<InsurancePolicyDto> dto=service.fetchPageData(pageSize, pageNo);
			request.setAttribute("dtolist", dto);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNo", pageNo);
			
			
			targetUrl="./report.jsp";
		} catch (HibernateException e) {
			e.printStackTrace();
			targetUrl="./error.jsp";
		}catch(Exception e) {
			e.printStackTrace();
			targetUrl="./error.jsp";
		}
		rd=request.getRequestDispatcher(targetUrl);
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
