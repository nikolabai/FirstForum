package cn.gavin.domain;
/**
 * 
 * @author Gavin
 * 
 */
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.core.style.ToStringStyler;
//实现序列化接口，以便JVM可以序列化PO实例
public class BaseDomain implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//统一的toString()方法 ，commons.lang3包
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

}
