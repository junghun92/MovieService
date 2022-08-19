
//주간 박스오피스
function movieList(){
	$.ajax({
		type: 'GET',
		url: '/api/movie',
		dataType: 'json',
		contentType: 'application/json; charset=utf-8'
	}).done(function(data){
		var weeklyBoxOfficeList = data.boxOfficeResult.weeklyBoxOfficeList;
		var html = '';
		
		$(".showRange").html(data.boxOfficeResult.showRange);
		//영화 정보(포스터)
		var movieImage = movieImageList();
		
		//영화 리스트
		$.each(weeklyBoxOfficeList, function(index, item){
			html += '<div class="col mb-5">';
			html += '   <div class="card h-100">';
			html += '       <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; left: 0.5rem">'+ item.rank +'</div>';
			html += '       <img class="card-img-top" src="'+ movieImage[index] +'" alt="..." />';
			html += '       <div class="card-body p-4">';
			html += '           <div class="text-center">';
			html += '               <h5 class="fw-bolder">'+ item.movieNm +'</h5>';
			html += '               <div class="d-flex justify-content-center small text-warning mb-2">';
			html +=	'					<span class="star-rating st_off"><span class="star-rating score st_on" style=""></span></span>';
			html += '               </div>';
			html += '               <span class="fw-bolder">개봉일</span> '+ item.openDt +'</br>';
			html += '               <span class="fw-bolder">관객수</span> '+ addComma(item.audiAcc) +'명';
			html += '           </div>';
			html += '       </div>';
			html += '       <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">';
			html += '           <div class="text-center">';
			html += '				<a class="btn btn-outline-dark mt-auto" href="#">상세정보</a>';
			html += '				<a class="btn btn-outline-dark mt-auto" href="#">예매하기</a>';
			html += '			</div>';
			html += '       </div>';
			html += '   </div>';
			html += '</div>';
		});
		
		$(".movieList").html(html);
	}).fail(function(error){
		alert(JSON.stringify(error));
	});
}

function movieImageList(){
	var movieImageList = '';

	$.ajax({
		type: 'POST',
		url: '/api/movie/imageList',
		dataType: 'json',
		async: false,
		contentType: 'application/json; charset=utf-8'
	}).done(function(data){
		movieImageList = data;
	}).fail(function(error){
		alert(JSON.stringify(error));
	});
	return movieImageList;

}