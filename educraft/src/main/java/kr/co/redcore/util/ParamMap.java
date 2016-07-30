package kr.co.redcore.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import kr.co.redcore.util.string.*;

public class ParamMap extends HashMap {
	private static final Logger logger = LoggerFactory.getLogger(ParamMap.class);

	public static final String CHARSET_DEFAULT = "UTF-8";
	public static final String CONNECTSTRING_DEFAULT = "&";
	public static final String CONNECTSTRING_ENCODING = "&amp;";

	protected boolean isEncodeConnectString = false;
	protected String urlEncodeCharset = CHARSET_DEFAULT;

	public ParamMap() {
		this(false);
	}

	public ParamMap(boolean isEncodeConnectString) {
		this.isEncodeConnectString = isEncodeConnectString;
		this.urlEncodeCharset = CHARSET_DEFAULT;
	}

	public ParamMap(boolean isEncodeConnectString, String urlEncodeCharset) {
		this.isEncodeConnectString = isEncodeConnectString;
		this.urlEncodeCharset = urlEncodeCharset;
	}

	public void setRequestParam(HttpServletRequest request) throws Exception {
		Map paramMap = new HashMap();	
		
		Set<String> keys = request.getParameterMap().keySet();		
		for (String key : keys) {
			logger.debug(key + " > " + request.getParameter(key));			
			if (request.getParameter(key) != null) {
				paramMap.put(key, ConvertUtil.convert(request.getParameter(key), ""));				
			} else {
				paramMap.put(key, "");
			}
		}
		
		super.putAll(paramMap);
	}

	public String getConnectString() {
		if (isEncodeConnectString) {
			return CONNECTSTRING_ENCODING;
		} else {
			return CONNECTSTRING_DEFAULT;
		}
	}

	public String getQueryString() {
		return getQueryString(getConnectString());
	}

	public String getQueryStringBase64() {
		return Base64.encodeBase64String(getQueryString(getConnectString()).getBytes());
	}
	
	public String getQueryStringDecodeBase64() {
		return new String(Base64.decodeBase64(getQueryString(getConnectString()).getBytes()));
	}
	public String getQueryString(String connectString) {
		StringBuffer tmpBuff = new StringBuffer();

		if (super.size() > 0) {
			Set keySet = super.keySet();
			Iterator it = keySet.iterator();
			boolean isFirst = true;
			while (it.hasNext()) {
				String key = (String) it.next();
				
				//log.debug(key + " < " + super.get(key));		
				
				Object obj = super.get(key);
				if (obj instanceof String[]) {
					String[] values = (String[]) obj;
					for (int i = 0; i < values.length; i++) {
						if ((values[i] != null) && !values[i].equals("")) {
							if (isFirst) {
								isFirst = false;
							} else {
								tmpBuff.append(connectString);
							}

							tmpBuff.append(key).append('=');

							try {
								tmpBuff.append(URLEncoder.encode(ConvertUtil.convert(values[i], ""), urlEncodeCharset));
							} catch (UnsupportedEncodingException ex) {
								logger.error(ex.getMessage(), ex);
								tmpBuff.append(values[i]);
							}
						}
					}
				} else if (obj instanceof String) {
					String value = (String) obj;
					if ((value != null) && !value.equals("")) {
						if (isFirst) {
							isFirst = false;
						} else {
							tmpBuff.append(connectString);
						}

						tmpBuff.append(key).append('=');
						
						try {
							tmpBuff.append(URLEncoder.encode(ConvertUtil.convert(value, ""), urlEncodeCharset));
						} catch (UnsupportedEncodingException ex) {
							logger.error(ex.getMessage(), ex);
							tmpBuff.append(value);
						}
					}
				} else if (obj instanceof Long) {
					long value = (Long) obj;
					if (isFirst) {
						isFirst = false;
					} else {
						tmpBuff.append(connectString);
					}

					tmpBuff.append(key).append('=');

					try {
						tmpBuff.append(URLEncoder.encode(Long.toString(value), urlEncodeCharset));
					} catch (UnsupportedEncodingException ex) {
						logger.error(ex.getMessage(), ex);
						tmpBuff.append(value);
					}
				} else if (obj instanceof Integer) {
					int value = (Integer) obj;
					if (isFirst) {
						isFirst = false;
					} else {
						tmpBuff.append(connectString);
					}

					tmpBuff.append(key).append('=');

					try {
						tmpBuff.append(URLEncoder.encode(Integer.toString(value), urlEncodeCharset));
					} catch (UnsupportedEncodingException ex) {
						logger.error(ex.getMessage(), ex);
						tmpBuff.append(value);
					}
				}
				
				//log.debug("tmpBuff < " + tmpBuff.toString());		
			}
		}

		//log.debug("final >>>>>>>>> tmpBuff < " + tmpBuff.toString());	
		
		return tmpBuff.toString();
	}

	public String getQueryStrigHiddenForm() {
		StringBuffer tmpBuff = new StringBuffer();

		if (super.size() > 0) {
			Set keySet = super.keySet();
			Iterator it = keySet.iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				Object obj = super.get(key);
				if (obj instanceof String[]) {
					String[] values = (String[]) obj;
					for (int i = 0; i < values.length; i++) {
						tmpBuff.append("<input type=\"hidden\" name=\"" + key + "\" value=\"" + ConvertUtil.convert(values[i], "") + "\">\n");
					}
				} else if (obj instanceof String) {
					String value = (String) obj;
					tmpBuff.append("<input type=\"hidden\" name=\"" + key + "\" value=\"" + ConvertUtil.convert(value, "") + "\">\n");
				}
			}
		}

		return tmpBuff.toString();
	}

	public ParamMap addParam(String paramName, Object paramValue) {
		super.put(paramName, paramValue);
		return this;
	}
	
	public ParamMap remParam(String paramName) {
		super.remove(paramName);
		return this;
	}
	
	public boolean isEncodeConnectString() {
		return isEncodeConnectString;
	}

	public void setEncodeConnectString(boolean isEncodeConnectString) {
		this.isEncodeConnectString = isEncodeConnectString;
	}

	public String getUrlEncodeCharset() {
		return urlEncodeCharset;
	}

	public void setUrlEncodeCharset(String urlEncodeCharset) {
		this.urlEncodeCharset = urlEncodeCharset;
	}
}