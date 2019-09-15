/**
 * 
 */
$(function() {
	// solving the active menu problem

	switch (menu) {
	case 'Home':
		$("#home").addclass('active');
		break;
	case 'About Us':
		$("#about").addclass('active');
		break;
	case 'Contact Us':
		$("#contact").addclass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}

});