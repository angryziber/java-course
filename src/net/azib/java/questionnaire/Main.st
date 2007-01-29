<html>
	<head>
		<title>$title$</title>
		<style>
		body {
			font-family: Arial, Helvetica, Serif;
		}
		fieldset {
			border: 1px solid #781351;
			width: 25em;
			padding-left: 2em;
			padding-right: 2em;
		}
		legend {
			color: #fff;
			background: #ffa20c;
			border: 1px solid #781351;
			padding: 2px 6px;
		}
		label {
			width: 10em;
			float: left;
			text-align: right;
			margin-right: 0.5em;
			display: block
		}
		input {
			background: #fee3ad;
		}
		input[type="text"], input[type="password"] {
			padding: 2px;
			width: 20em;
			color: #781351;
			border: 1px solid #781351;
		}		
		input[type="submit"] {
			width: 10em;
			color: #000;
			background: #ffa20f;
			border: 2px outset #d7b9c9;
			font-weight: bold;
			font-size: 14px;
		}
		input[type="submit"]:hover {
			background: #ffd24f;
		}
		.error {
			color: red;
			font-size: 14px;
			padding: 3px;
			border: 1px solid red;
			font-weight: bold;
		}
		.note {
			background: #ffffaa;
			font-size: 14px;
			padding: 3px;
			//border: 1px solid brown;
			font-weight: bold;
		}
		.wrong {
			background: #ffaaaa;
			font-weight: bold;
		}
		.correct {
			background: #aaffaa;
			font-weight: bold;
		}
		.question {
			text-align: left;
			mergin-left: 10em;
		}
		.answers {
			text-align: left;
			padding-left: 4em;
		}
		</style>
	</head>
	<body>
		$body$
	</body>
</html>
