package cn.gavin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.gavin.domain.Board;
import cn.gavin.service.ForumService;

/**
 * 
 * @author Gavin
 * @2017年5月31日
 *
 *  版块管理：删除主题，删除回复，指定精华帖+++++发表主题，回复
 */


public class BoardManageController extends BaseController{
	@Autowired
	private ForumService forumService;
	
	//列出论坛模块下 的主题帖子
//	@RequestMapping(value = "/board/listBoardTopics-{boardId}",method = RequestMethod.GET)
//	public  ModelAndView listBoardTopic(@PathVariable Integer boardId,@RequestParam(value ="pageNo",required=false )Integer pageNo){
//		ModelAndView view = new ModelAndView();
//		Board board=forumService.getBoardById(boardId);
//		
//	}

}
