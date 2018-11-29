/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wenmeng;

import java.io.File;
import org.apache.log4j.Category;

/**
 *
 * @author Administrator

import java.io.File;
import org.apache.log4j.*;

/**
 * <p>Title: 企业短讯推�?�网�?</p>
 * <p>Description: 遵循EMPI规范，支持多企业接入的网�?</p>
 * <p>Copyright: Copyright (c) 2003 www.webimation.com.cn</p>
 * <p>Company: webimation inc.</p>
 * @author lhyang
 * @version 1.1
 */

public class Logger {

	/**
	 * 日志log4j配置文件的路�?
	 */
	public final static String LOGGERFILEPATH =  "";

	public static Logger log = null;
	public static Object logLock = new Object();

	//系统的主日志
	public static org.apache.log4j.Category sysLogger  = null;

	//支付网关接入的消息日�?
	public static org.apache.log4j.Category inLogger = null;

	//支付网关接向的消息日�?
	public static org.apache.log4j.Category outLogger = null;

	/**
	 * 该构造方法用来给整个系统产生�?个日志对象，该对象由系统日志对象和消息日志对�?
	 * 组成�?
	 *
	 * @return
	 */
	private Logger() {

		try {
			sysLogger = Category.getInstance("sys.msg");
			inLogger = Category.getInstance("in.msg");
			outLogger = Category.getInstance("out.msg");
		}
		catch (Exception e) {
			//donothing
		}
	}

	/**
	 *
	 * @return
	 */
	public static Category getSysLogger() {
		if (log == null) {
			synchronized (logLock) {
				if (log == null) {
					log = new Logger();
				}
			}
		}
		return sysLogger;
	}

	/**
	 *
	 * @return
	 */
	public static Category getInLogger() {
		if (log == null) {
			synchronized (logLock) {
				if (log == null) {
					log = new Logger();
				}
			}
		}
		return inLogger;
	}

	/**
	 *
	 * @return
	 */
	public static Category getOutLogger() {
		if (log == null) {
			synchronized (logLock) {
				if (log == null) {
					log = new Logger();
				}
			}
		}
		return outLogger;
	}


}
