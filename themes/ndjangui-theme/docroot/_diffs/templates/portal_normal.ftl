<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	
	
	<script src="${javascript_folder}/jquery.min.js"></script>
	
	<script src="${javascript_folder}/underscore-min.js"></script>
	${theme.include(top_head_include)}
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.14/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.14/angular-resource.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.14/angular-sanitize.js"></script>

	<script src="${javascript_folder}/ui-bootstrap-tpls-0.11.0.min.js"></script>
	
	<script src="http://m-e-conroy.github.io/angular-dialog-service/javascripts/dialogs.min.js" type="text/javascript"></script>
	
	
	
</head>

<body class="${css_class}">

<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}



<div class="responsive-navigation-container">
	<div class="responsive-menu-button"></div>
	<div class="responsive-navigation">
		
		<div style="text-align:center;  margin-top: 10px;">
			<img style="  width: 120px;" src="${themeDisplay.getPathThemeImages() + "/logo.png"}" />
		</div>
	
		<#if has_navigation || is_signed_in>
			<#include "${full_templates_path}/navigation.ftl" />
		</#if>
	</div>
	<div class="responsive-small-navigation">
		
		<div style="text-align:center;  margin-top: 10px;">
			<img style="  width: 90%;" src="${themeDisplay.getPathThemeImages() + "/logo.png"}" />
		</div>
	
		<#if has_navigation || is_signed_in>
			<#include "${full_templates_path}/small_navigation.ftl" />
		</#if>
	</div>
</div>
<div class="container-fluid" id="wrapper">
	
	<#if is_signed_in>
		<@liferay.dockbar />
	</#if>
	<div id="content">
		

		<#if selectable>
			${theme.include(content_include)}
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			${theme.wrapPortlet("portlet.ftl", content_include)}
		</#if>
	</div>

	<footer id="footer" role="contentinfo">
		<p class="powered-by">
			<@liferay.language key="powered-by" /> <a href="http://www.fandenatech.com" rel="external">FandenaTech</a>
		</p>
	</footer>
</div>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>