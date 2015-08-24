/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cmr.fandenatech.ndjangui.model.impl;

import cmr.fandenatech.ndjangui.model.Member_Fund;
import cmr.fandenatech.ndjangui.service.Member_FundLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the Member_Fund service. Represents a row in the &quot;ndjangui_Member_Fund&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Member_FundImpl}.
 * </p>
 *
 * @author guyw
 * @see Member_FundImpl
 * @see cmr.fandenatech.ndjangui.model.Member_Fund
 * @generated
 */
public abstract class Member_FundBaseImpl extends Member_FundModelImpl
	implements Member_Fund {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a member_ fund model instance should use the {@link Member_Fund} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			Member_FundLocalServiceUtil.addMember_Fund(this);
		}
		else {
			Member_FundLocalServiceUtil.updateMember_Fund(this);
		}
	}
}