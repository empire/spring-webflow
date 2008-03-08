/*
 * Copyright 2004-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.faces.ui;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.springframework.faces.ui.resource.ResourceHelper;

public class ExtJsRenderer extends SpringFacesRenderer {

	private static final String EXT_CSS = "/ext/resources/css/ext-all.css";

	private static final String EXT_SCRIPT = "/ext/ext.js";

	private static final String SPRING_EXT_SCRIPT = "/spring/Spring-Ext.js";

	private ResourceHelper resourceHelper = new ResourceHelper();

	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {

		super.encodeBegin(context, component);

		ExtJsComponent extJsComponent = (ExtJsComponent) component;

		if (extJsComponent.getIncludeExtStyles().equals(Boolean.TRUE)) {
			resourceHelper.renderStyleLink(context, EXT_CSS);
		}

		if (extJsComponent.getIncludeExtScript().equals(Boolean.TRUE)) {
			resourceHelper.renderScriptLink(context, EXT_SCRIPT);
		}

		resourceHelper.renderScriptLink(context, SPRING_EXT_SCRIPT);
	}
}
