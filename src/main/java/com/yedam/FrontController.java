package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddFormControl;
import com.yedam.control.AddFullDataControl;
import com.yedam.control.AddMemberControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AjaxControl;
import com.yedam.control.ApiControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartDataControl;
import com.yedam.control.Control;
import com.yedam.control.DataControl;
import com.yedam.control.DataTableControl;
import com.yedam.control.FullControl;
import com.yedam.control.FullDataControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.MapControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.RemoveFullDataControl;
import com.yedam.control.RemoveMemberControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.GetReplyCntControl;
import com.yedam.control.RemoveReplyControl;

//@WebServlet("*.do")
public class FrontController extends HttpServlet {

	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<>();

	}

	@Override
	public void init() throws ServletException {
		map.put("/main.do", new MainControl());
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		map.put("/addForm.do", new AddFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/modifyForm.do", new ModifyControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		map.put("/removeBoard.do", new RemoveBoardControl());
		map.put("/loginForm.do", new LoginControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());

		map.put("/replyList.do", new ReplyListControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/getReplyCnt.do", new GetReplyCntControl());

		map.put("/memberList.do", new MemberListControl());
		map.put("/removeMember.do", new RemoveMemberControl());
		map.put("/addMember.do", new AddMemberControl());
		map.put("/testAjax.do", new AjaxControl());
		map.put("/testData.do", new DataControl());
		
		map.put("/chart.do", new ChartControl());
		map.put("/chartData.do", new ChartDataControl());
		map.put("/dataTable.do", new DataTableControl());
		
		map.put("/full.do", new FullControl());	
		map.put("/fullData.do", new FullDataControl());
		map.put("/addFullData.do", new AddFullDataControl());
		map.put("/removeFullData.do", new RemoveFullDataControl());
		
		map.put("/api.do", new ApiControl());
		map.put("/map.do", new MapControl());
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("front controller called");

		String uri = req.getRequestURI();
//		System.out.println(uri);
		String context = req.getContextPath();
//		System.out.println(context);
		String page = uri.substring(context.length());
//		System.out.println(page);

		Control ctl = map.get(page);
		ctl.exec(req, resp);
	}

}
