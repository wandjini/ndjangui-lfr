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

import cmr.fandenatech.ndjangui.model.SanctionType;
import cmr.fandenatech.ndjangui.service.SanctionTypeLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the SanctionType service. Represents a row in the &quot;ndjangui_SanctionType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SanctionTypeImpl}.
 * </p>
 *
 * @author guyw
 * @see SanctionTypeImpl
 * @see cmr.fandenatech.ndjangui.model.SanctionType
 * @generated
 */
public abstract class SanctionTypeBaseImpl extends SanctionTypeModelImpl
	implements SanctionType {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sanction type model instance should use the {@link SanctionType} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SanctionTypeLocalServiceUtil.addSanctionType(this);
		}
		else {
			SanctionTypeLocalServiceUtil.updateSanctionType(this);
		}
	}
}