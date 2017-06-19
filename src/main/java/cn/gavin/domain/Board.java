package cn.gavin.domain;
/**
 * @author Gavin
 */



import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/**
 * 论坛版块
 * @author Gavin
 * @2017年6月16日
 */

@javax.persistence.Entity
@Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_board")
public class Board implements Serializable{
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
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardName=" + boardName + ", boardDesc=" + boardDesc + ", topicNum="
				+ topicNum + "]";
	}
	

}
