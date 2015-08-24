AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal',
	function(A) {
		var navigation = A.one('#navigation');

		if (navigation) {
			navigation.plug(Liferay.NavigationInteraction);
		}

		var siteBreadcrumbs = A.one('#breadcrumbs');

		if (siteBreadcrumbs) {
			siteBreadcrumbs.plug(A.Hudcrumbs);
		}

		var signIn = A.one('li.sign-in a');

		if (signIn && signIn.getData('redirect') !== 'true') {
			signIn.plug(Liferay.SignInModal);
		}
		
		A.one(".responsive-menu-button").on('click',function(e){
			var body = A.one('body');
			
			if(body.hasClass('responsive-menu-open')){
				body.removeClass('responsive-menu-open');
			}
			else{
				body.addClass('responsive-menu-open');
			}
			
		});
	}
);