package cmr.fandenatech.ndjangui.util;

import com.liferay.portal.kernel.util.Constants;

public enum Command {
	ADD(Constants.ADD), ACTIVATE_MEMBER(ActionKeys.ACTIVATE_MEMBER), 
	DE_ACTIVATE_MEMBER(ActionKeys.DE_ACTIVATE_MEMBER), UPDATE(ActionKeys.UPDATE);
	
	private final String value;
	Command( String value){
		this.value=value;
	};	
	private String getValue(){return this.value;}

}
