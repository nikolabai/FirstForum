package cn.gavin.domain;
/**
 * @author Gavin
 */



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@javax.persistence.Entity
@Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_board")
public class Board extends BaseDomain{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int boardId;
	private String boardName;
	private String boardDesc;
	private int topicNum;
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardDesc() {
		return boardDesc;
	}
	public void setBoardDesc(String boardDesc) {
		this.boardDesc = boardDesc;
	}
	public int getTopicNum() {
		return topicNum;
	}
	public void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}
	

}
