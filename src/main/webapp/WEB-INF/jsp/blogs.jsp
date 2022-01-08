<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>Blogs</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

	    <script src=
    "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
        </script>
        <script>
          jQuery(document).ready(function($) {
                          $(".clickable-row").click(function() {
                                var a=$(this).data("href")+($(this).index());


                                 window.location = a;
                          });
                      });
        </script>

</head>

<body>

	<div class="container">

	     <form method="post">
        <input name="tagName" type="text"/>
        <input type="submit"/>
        </form>
		<table class="table table-striped">
			<caption>Your Blogs are</caption>
			<thead>

				<tr>
					<th>AuthorName</th>
					<th>Title</th>
					<th>details</th>


				</tr>
			</thead>
			<tbody>
				<c:forEach items="${blogVar}" var="b">

					<tr class='clickable-row' data-href="/showBlog/">
					]
						<td>${b.authorName}</td>
						<td>${b.title}</td>
						<td>${b.details}</td>

					</tr>

				</c:forEach>
			</tbody>

		</table>
		<div> <a class="button" href="/get10more">get10more</a></div>

		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</div>
</body>

</html>










