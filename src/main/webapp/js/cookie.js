$(function() {
	var MTPL = '../css/';
	//换肤  
	var myskin = $.cookie('myskin');
//	console.log(myskin);
	if(myskin) {
		switchskin(myskin);
	}
	var skini = $('.yskj_skin a');
//	console.log(skini);
	skini.click(function() {
		switchskin(this.id);
	});

	function switchskin(skin) {
		$('.yskj_skin a').removeClass('on');
		$('#' + skin).addClass('on');
		$('#' + skin).find('input').attr('checked', 'checked');
		$('#skin').attr('href', MTPL + skin + '.css');
		$.cookie('myskin', skin, {
			path: '/',
			expires: 365
		})
	}
	var tmi = $('.yskj_tm a');
	tmi.click(function() {
		switchtm(this.id);
	});
})