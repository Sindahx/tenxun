package com.dffx.webservice;

public class WebConstansCode {

	/**
	 * 成功
	 */
	public static final int ERR_CODE_SUCCESS = 0;

	/**
	 * 业务错误
	 */
	public static final int ERR_CODE_BS_ERROR = 1;
	
	/**
	 * 业务错误，未设置支付密码
	 */
	public static final int ERR_CODE_NOT_SET_PASSWORD = 1001;

	/**
	 * 请求参数非法
	 */
	public static final int ERR_CODE_PARA_ERROR = 901;

	/**
	 * 请求参数为空
	 */
	public static final int ERR_CODE_PARA_NULL_ERROR = 902;

	/**
	 * 系统处理错误
	 */
	public static final int ERR_CODE_SYS_ERROR = 9;

	/**
	 * 验证码校验失败
	 */
	public static final int ERR_CODE_MESSAGE_ERROR = 20;

	/**
	 * 验证码发送失败
	 */
	public static final int ERR_CODE_SENDCODE_ERROR = 201;

	/**
	 * 用户名或密码错误
	 */
	public static final int ERR_CODE_USER_ERROR = 102;

	public static int INDEX = 100000;

	/**
	 * 用户名重复错误
	 */
	public static final int ERR_ECHO_USER_ERROR = 103;

	public static final int SOAP_EOF = -1;

	public static final int SOAP_ERR = -1;

	public static final int SOAP_OK = 0;

	public static final int SOAP_CLI_FAULT = 1;

	public static final int SOAP_SVR_FAULT = 2;

	public static final int SOAP_TAG_MISMATCH = 3;

	public static final int SOAP_TYPE = 4;

	public static final int SOAP_SYNTAX_ERROR = 5;

	public static final int SOAP_NO_TAG = 6;

	public static final int SOAP_IOB = 7;

	public static final int SOAP_MUSTUNDERSTAND = 8;

	public static final int SOAP_NAMESPACE = 9;

	public static final int SOAP_USER_ERROR = 10;
	public static final int SOAP_FATAL_ERROR = 11;

	public static final int SOAP_FAULT = 12;

	public static final int SOAP_NO_METHOD = 13;

	public static final int SOAP_GET_METHOD = 14;

	public static final int SOAP_EOM = 15;

	public static final int SOAP_NULL = 16;

	public static final int SOAP_DUPLICATE_ID = 17;

	public static final int SOAP_MISSING_ID = 18;

	public static final int SOAP_HREF = 19;

	public static final int SOAP_UDP_ERROR = 20;

	public static final int SOAP_TCP_ERROR = 21;

	public static final int SOAP_HTTP_ERROR = 22;

	public static final int SOAP_SSL_ERROR = 23;

	public static final int SOAP_ZLIB_ERROR = 24;

	public static final int SOAP_DIME_ERROR = 25;

	public static final int SOAP_DIME_HREF = 26;

	public static final int SOAP_DIME_MISMATCH = 27;

	public static final int SOAP_DIME_END = 28;

	public static final int SOAP_MIME_ERROR = 29;

	public static final int SOAP_MIME_HREF = 30;

	public static final int SOAP_MIME_END = 31;

	public static final int SOAP_VERSIONMISMATCH = 32;

	public static final int SOAP_PLUGIN_ERROR = 33;

	public static final int SOAP_DATAENCODINGUNKNOWN = 34;

	public static final int SOAP_REQUIRED = 35;

	public static final int SOAP_PROHIBITED = 36;

	public static final int SOAP_OCCURS = 37;

	public static final int SOAP_LENGTH = 38;

	public static final int SOAP_FD_EXCEEDED = 39;
	
	public static final int SOAP_GETORDERDETAILS_EXIST=40;
	
	public static final int SOAP_GETORDERDETAILS_TIMEOUT =41;
	
	public static final String SOAP_SUCCESS = "SUCCESS";

	public static final String SOAP_EOF_MESSAGE = "Unexpected end of file, no input, or timeout while receiving data";

	public static final String SOAP_NO_TAG_MESSAGE = "Begin of an element expected, but not found";

	public static final String SOAP_SYNTAX_ERROR_MESSAGE = "An XML syntax error occurred on the input";

	public static final String SOAP_TYPE_MESSAGE = "An XML Schema type mismatch";

	public static final String SOAP_TAG_MISMATCH_MESSAGE = "An XML element didn't correspond to anything expected";

	public static final String SOAP_SVR_FAULT_MESSAGE = "The service returned a server fault (SOAP 1.2 Receiver fault)";

	public static final String SOAP_CLI_FAULT_MESSAGE = "The service returned a client fault (SOAP 1.2 Sender fault)";

	public static final String SOAP_OK_MESSAGE = "No error";

	public static final String SOAP_GET_METHOD_MESSAGE = "HTTP GET operation not handled";

	public static final String SOAP_NO_METHOD_MESSAGE = "The dispatcher did not find a matching operation for the request";

	public static final String SOAP_FAULT_MESSAGE = "An exception raised by the service";

	public static final String SOAP_FATAL_ERROR_MESSAGE = "Internal error";

	public static final String SOAP_NAMESPACE_MESSAGE = " Namespace name mismatch (validation error)";

	public static final String SOAP_MUSTUNDERSTAND_MESSAGE = "An element needs to be ignored that need to be understood";

	public static final String SOAP_IOB_MESSAGE = "Array index out of bounds";

	public static final String SOAP_SSL_ERROR_MESSAGE = "An SSL error occured";

	public static final String SOAP_HTTP_ERROR_MESSAGE = "An HTTP error occured";

	public static final String SOAP_TCP_ERROR_MESSAGE = "A connection error occured";

	public static final String SOAP_UDP_ERROR_MESSAGE = "Message too large to store in UDP packet";

	public static final String SOAP_HREF_MESSAGE = "Reference to object is incompatible with the object refered to";

	public static final String SOAP_MISSING_ID_MESSAGE = "Element ID missing for an HREF on the input";

	public static final String SOAP_DUPLICATE_ID_MESSAGE = "Multiple occurrences of the same element ID on the input";

	public static final String SOAP_NULL_MESSAGE = "An element was null, while it is not supposed to be null";

	public static final String SOAP_EOM_MESSAGE = "Out of memory";

	public static final String SOAP_PROHIBITED_MESSAGE = "Attributed prohibited validation error";

	public static final String SOAP_REQUIRED_MESSAGE = "Attributed required validation error";

	public static final String SOAP_DATAENCODINGUNKNOWN_MESSAGE = "SOAP 1.2 DataEncodingUnknown fault";

	public static final String SOAP_PLUGIN_ERROR_MESSAGE = "Failed to register plugin";

	public static final String SOAP_MIME_ERROR_MESSAGE = "MIME parsing error";

	public static final String SOAP_DIME_END_MESSAGE = "End of DIME error";

	public static final String SOAP_DIME_MISMATCH_MESSAGE = "DIME version/transmission error";

	public static final String SOAP_DIME_HREF_MESSAGE = "DIME attachment has no href from SOAP body";

	public static final String SOAP_DIME_ERROR_MESSAGE = "DIME parsing error";

	public static final String SOAP_ZLIB_ERROR_MESSAGE = "A Zlib error occured";

	public static final String SOAP_VERSIONMISMATCH__MESSAGE = "SOAP version mismatch or no SOAP message";

	public static final String SOAP_OCCURS_MESSAGE = "Element minOccurs/maxOccurs validation error";

	public static final String SOAP_LENGTH_MESSAGE = "Element length validation error";

}
