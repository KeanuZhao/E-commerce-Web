
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>INTRO</title>
<script src="js/jquery-1.4.4.min.js"></script>
<script src="js/slides.min.jquery.js"></script>

<script>
$(function(){
	$('#products').slides({
		preload: true,
		preloadImage: 'img/loading.gif',
		effect: 'slide, fade',
		crossfade: true,
		slideSpeed: 200,
		fadeSpeed: 500,
		generateNextPrev: true,
		generatePagination: false
	});
});
</script>
<link rel="stylesheet" href="css/global.css">
</head>
<body>
	

			<div id="products">
				<div class="slides_container">
					<a href="#" target="_blank"><img src="img/ab.jpg" width="366" alt="1144953 3 2x"></a>
					<a href="#" target="_blank"><img src="img/bc.jpg" width="366" alt="1144953 1 2x"></a>
					<a href="#" target="_blank"><img src="img/cd.jpg" width="366" alt="1144953 2 2x"></a>
					<a href="#" target="_blank"><img src="img/de.jpg" width="366" alt="1144953 4 2x"></a>
					</div>
				<ul class="pagination">
					<li><a href="#"><img src="img/ab.jpg" width="55" alt="1144953 3 2x"></a></li>
					<li><a href="#"><img src="img/bc.jpg" width="55" alt="1144953 1 2x"></a></li>
					<li><a href="#"><img src="img/cd.jpg" width="55" alt="1144953 2 2x"></a></li>
					<li><a href="#"><img src="img/de.jpg" width="55" alt="1144953 4 2x"></a></li>
				</ul>
                
			</div>


</body>
</html>
