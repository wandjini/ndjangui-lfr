package cmr.fandenatech.ndjangui.util;

import java.text.DateFormat;
import java.util.Locale;

import com.liferay.portal.kernel.util.DateFormatFactoryUtil;

public class FormatUtil {
	
	public final static DateFormat getFormatDateTimeFormat(Locale locale){
		
		return DateFormatFactoryUtil.getDate(locale);
	}

}
