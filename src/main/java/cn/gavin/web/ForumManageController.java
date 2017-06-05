package cn.gavin.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.gavin.domain.Board;
import cn.gavin.service.ForumService;
import cn.gavin.service.UserService;

/**
 * 
 * @author Gavin
 * @2017年5月31日
 */
@Controller
public class ForumManageController extends BaseController{
	@Autowired
	private ForumService forumService;
	@Autowired
	private UserService userService;
	
	//列出所有的论坛模块
//	@RequestMapping (value = "/index",method = RequestMethod.GET)
//	public String listAllBoards(){
//		List<Board> boards = forumService.getAllBoards();
//	}
	
	//添加一个主题帖页面
	@RequestMapping(value= "/forum/addBoardPage",method= RequestMethod.POST)
	public  String addBoardPage(){
		return "/addBoard";
	}
	//添加一个主题帖
	@RequestMapping(value = "/forum/addBoard",method =RequestMethod.POST  )
	public  String addBoard(Board board){
		forumService.addBoard(board);
		return "/addBoardSuccess";
	}
	//指定论坛管理员的页面
//	@RequestMapping(value = "/forum/setBoardManagerPage",method =RequestMethod.GET )
//	public ModelAndView setBoardManagerPage(){
//		ModelAndView view = new ModelAndView();
//		List<Board> boards = forumService.getAllUsers();
//		
//	}
}
