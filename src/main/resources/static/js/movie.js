
//영화 리스트
function movieList(display){
	$.ajax({
		type: 'POST',
		url: '/api/movie/list',
		dataType: 'json',
		data: {"display":display}
	}).done(function(data){
		$(".boxOffice").html(movieData(data.boxOfficeList));	//박스오피스
		$(".comming").html(movieData(data.commingList));		//상영 예정작

	}).fail(function(error){
		alert(JSON.stringify(error));
	});
	
}

function movieData(data){
	var html = '';
	
	$.each(data, function(index, item){
		var bg = item.movieAge == '18' ? 'bg-danger' : 'bg-success';
		var movieAge = item.movieAge == '0' ? '전체' : item.movieAge;
		
		html += '<div class="col mb-5">';
		html += '   <div class="card h-100">';
		html += '       <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; left: 0.5rem">'+ ++index +'</div>';
		html += '       <img class="card-img-top" src="'+ item.movieImage +'"/>';
		html += '       <div class="card-body p-4">';
		html += '           <div class="text-center">';
		html += '               <div class="badge text-white '+ bg +'">'+ movieAge +'</div>';
		html += '				<h5 class="fw-bolder">'+ item.movieNm +'</h5>';
		html += '           </div>';
		html += '       </div>';
		html += '       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">';
		html += '           <div class="text-center">';
		html += '				<a class="btn btn-outline-dark mt-auto" href="#">상세정보</a>';
		html += '				<a class="btn btn-outline-dark mt-auto" href="/movie/reserve?movieCode='+ item.movieCode +'">예매하기</a>';
		html += '			</div>';
		html += '       </div>';
		html += '   </div>';
		html += '</div>';
	});
	
	return html;
}

//영화관
function reserveTheater(movieCode){
	var html = '';
	
	$.ajax({
		type: 'POST',
		url: '/api/movie/reserveTheater',
		dataType: 'json',
		data: {"movieCode":movieCode}
	}).done(function(data){
		var theaterCode = $("#theaterCode").val(); //영화관
		$.each(data, function(index, item){
			var addClass = theaterCode == item.theaterCode ? 'active' : '';
			
			html += '<li class="list-group-item btn '+ addClass +'" data-theatercode="'+ item.theaterCode +'">';
			html += 	item.theater
			html += '</li>';
		});
		
		$(".reserveTheater").html(html);
	}).fail(function(error){
		alert(JSON.stringify(error));
	});
}

// 상영날짜
function reserveDate(theaterCode){
	$.ajax({
		type: 'POST',
		url: '/api/movie/reserveDate',
		dataType: 'json',
		data: {"theaterCode":theaterCode}
	}).done(function(data){
		var html = '';
		var playDate = $("#playDate").val(); //상영날짜
		$.each(data, function(index, item){
			var addClass = playDate == item.date ? 'active' : '';
			
			html += '<li class="btn '+ addClass +'" data-date="'+ item.date+'">';
			html += 	item.day;
			html += '</li>';
		});
		
		$(".reserveDate").html(html);
	}).fail(function(error){
		alert(JSON.stringify(error));
	});
}

// 상영영화
function reserveMovie(playDate, movieCode, theaterCode){
	var data = {
		"playDate":playDate,
		"movieCode":movieCode,
		"theaterCode":theaterCode
	}
	$.ajax({
		type: 'POST',
		url: '/api/movie/reserveMovie',
		dataType: 'json',
		data: data
	}).done(function(data){
		var html = '';
		var movieCode = $("#movieCode").val(); //영화관
		
		$.each(data, function(index, item){
			var bg = item.movieAge == '18' ? 'bg-danger' : 'bg-success';
			var movieAge = item.movieAge == '0' ? '전체' : item.movieAge;
			var addClass = movieCode == item.movieCode && item.disabledChk == false ? 'active' : '';
			addClass += item.disabledChk == true ? ' disabled' : '';
				
			html += '<li class="list-group-item btn '+ addClass +'" data-moviecode="'+ item.movieCode +'">';
			html += '<div class="badge text-white '+ bg +'">'+ movieAge +'</div> ';
			html += 	item.movieNm;
			html += '</li>';
		});
		
		$(".reserveMovie").html(html);
	}).fail(function(error){
		alert(JSON.stringify(error));
	});
}

// 상영시간
function reserveScreenPlan(playDate, movieCode, theaterCode){
	var data = {
			"playDate":playDate,
			"movieCode":movieCode,
			"theaterCode":theaterCode
		}

	$.ajax({
		type: 'POST',
		url: '/api/movie/reserveScreenPlan',
		dataType: 'json',
		data: data
	}).done(function(data){
		var html = '';
		
		$.each(data, function(index, item){
			html += '<li class="btn">'+ item.startTime +' ('+ item.seatCnt +'석)</li>';
		});
		
		$(".reserveScreenPlan").html(html);
	}).fail(function(error){
		alert(JSON.stringify(error));
	});
}

