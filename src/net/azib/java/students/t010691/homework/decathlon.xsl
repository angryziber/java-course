<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<head>
				<title>Decathlon competition results</title>
			</head>
			<body>
				<h1>Decathlon competition results</h1>
				<table border="1">
					<tr>
						<th>Place</th>
						<th>Score</th>
						<th>Name</th>
						<th>Date of birth</th>
						<th>Country</th>
						<th>100 m sprint</th>
						<th>Long jump</th>
						<th>Shot put</th>
						<th>High jump</th>
						<th>400 m sprint</th>
						<th>110 m hurdles</th>
						<th>Discus throw</th>
						<th>Pole vault</th>
						<th>Javelin throw</th>
						<th>1500 m race</th>
					</tr>
					<xsl:for-each select="competition/competitor">
						<tr>
							<td><xsl:value-of select="place"/></td>
							<td><xsl:value-of select="score"/></td>
							<td><xsl:value-of select="name"/></td>
							<td><xsl:value-of select="birth_date"/></td>
							<td><xsl:value-of select="country_code"/></td>
							<td><xsl:value-of select="results/one_hundred_meters_sprint"/></td>
							<td><xsl:value-of select="results/long_jump"/></td>
							<td><xsl:value-of select="results/shot_put"/></td>
							<td><xsl:value-of select="results/high_jump"/></td>
							<td><xsl:value-of select="results/four_hundred_meters_sprint"/></td>
							<td><xsl:value-of select="results/one_hundred_and_ten_meters_hurdles"/></td>
							<td><xsl:value-of select="results/discus_throw"/></td>
							<td><xsl:value-of select="results/pole_vault"/></td>
							<td><xsl:value-of select="results/javelin_throw"/></td>
							<td><xsl:value-of select="results/one_thousand_and_five_hundred_meters_race"/></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>