$(function(){
	$('ul.nav.navbar-nav li a').each(function(i,el){
		console.log(i,el);
		console.log(location.href)
		if(location.href == el.href){
			$(el.parentElement).addClass('active');
		}
	});
});