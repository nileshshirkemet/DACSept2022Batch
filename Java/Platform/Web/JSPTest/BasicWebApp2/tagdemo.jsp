<%@taglib prefix="my" uri="http://java.met.edu/basicwebapp" %>
<html>
	<head>
		<title>BasicWebApp</title>
	</head>
	<body>
		<h1>Welcome Gambler</h1>
		<b>Current Time: </b><my:clock format="MMM, dd yyyy hh:mm:ss a"/>
		<p>
			<b>WINNER: </b>
			<my:lotto digitCount="9" digitVar="d">
				<i>${d}</i>
			</my:lotto>
		</p>
	</body>
</html>

