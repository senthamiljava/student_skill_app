<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<title>Update Skill</title>
<script src="../jquery-3.2.1.js"></script>
<script>
	$(document).ready(function() {
		console.log("Jquery Loaded");

		$(".scale").change(function() {

			var Cells = document.getElementsByTagName("td");
			var id = Cells[0].innerText;
			alert(id);

			console.log("box value changed");
			var scale = $('.scale').val();
			alert(scale);

			console.log(id);
			console.log(scale);
			$.ajax({
				type : "GET",
				url : "../skill/update",
				data : {
					id : id,
					scale : scale
				},
				success : function() {
					alert('Success');
				},
				error : function() {
					alert('Error');
				}
			});

		});
	});
</script>
</head>
<body>
	<h2>My Skills</h2>

	<table id="mytab1" border="1">
		<thead>
			<tr>
				<th>Sno</th>
				<th>Skill Name</th>
				<th>Scale</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${skill_list}" var="s">
		<tr>
				<td>${s.id}</td>
				<td>${s.skill.name}</td>
				<td><select class="scale">
						<option value="YET TO LEARN">YET TO LEARN</option>
						<option value="BEGINNER">BEGINNER</option>
						<option value="INTERMEDIATE">INTERMEDIATE</option>
						<option value="EXPERT">EXPERT</option>
				</select></td>
				</tr>
				</c:forEach>
		</tbody>
	</table>

</body>
</html>