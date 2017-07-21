package cn.gavin.web;

import org.aspectj.weaver.tools.cache.GeneratedCachedClassHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.gavin.constants.Constants;
import cn.gavin.dao.Page;
import cn.gavin.domain.Board;
import cn.gavin.service.ForumService;

/**
 * 
 * @author Gavin
 * @2017年5月31日
 *
 *  版块管理：删除主题，删除回复，指定精华帖
 *  普通登录：发表主题，回复
 */

@Controller
public class BoardManageController extends BaseController{
	@Autowired
	private ForumService forumService;
	private static final Logger logger =LoggerFactory.getLogger(BoardManageController.class);
	
	/**
	 * 列出论坛模块下的主题帖子
	 * 
	 * @param boardId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/board/listBoardTopics-{boardId}", method = RequestMethod.GET)
	public ModelAndView listBoardTopics(@PathVariable Integer boardId,@RequestParam(value = "pageNo", required = false, defaultValue="1") Integer pageNo) {
		logger.info(boardId.toString());
		ModelAndView view =new ModelAndView();
		Board board = forumService.getBoardById(boardId);
		pageNo = pageNo==null?1:pageNo;
		Page pagedTopic = forumService.getPagedTopics(board, pageNo,
				Constants.PAGE_SIZE);
		view.addObject("board", board);
		view.addObject("pagedTopic", pagedTopic);
		view.setViewName("/listBoardTopics");
		return view;
	}

}
