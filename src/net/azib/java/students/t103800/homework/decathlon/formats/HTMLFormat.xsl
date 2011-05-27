<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" encoding="UTF-8"/>

<xsl:template match="/decathlon">
	<html>
		<head>
			<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
			<title>Decathlon results</title>
		</head>
		<body>
			<table border="1">
				<tr>
					<td>Place</td>
					<td>Score</td>
					<td>Name</td>
					<td>Birthdate</td>
					<td>Country code</td>
					<td>100m sprint</td>
					<td>Long jump</td>
					<td>Shotput</td>
					<td>Highjump</td>
					<td>400m sprint</td>
					<td>110m hurdles</td>
					<td>Discus throwing</td>
					<td>Pole vault</td>
					<td>Javelin throwing</td>
					<td>1500m race</td>
				</tr>
				<xsl:apply-templates select="place"/>
			</table>
		</body>
	</html>
</xsl:template>

<xsl:template match="place">
	<xsl:apply-templates select="athlete"/>
</xsl:template>

<xsl:template match="athlete">
	<tr>
		<td><xsl:value-of select="parent::place/attribute::range" /></td>
		<td><xsl:value-of select="parent::place/attribute::score" /></td>
		<td><xsl:value-of select="name"/></td>
		<td><xsl:value-of select="birthdate"/></td>
		<td><xsl:value-of select="countrycode"/></td>
		<td><xsl:value-of select="sprint100m"/></td>
		<td><xsl:value-of select="longjump"/></td>
		<td><xsl:value-of select="shotput"/></td>
		<td><xsl:value-of select="highjump"/></td>
		<td><xsl:value-of select="sprint400m"/></td>
		<td><xsl:value-of select="hurdles110m"/></td>
		<td><xsl:value-of select="discusthrow"/></td>
		<td><xsl:value-of select="polevault"/></td>
		<td><xsl:value-of select="javelinthrow"/></td>
		<td><xsl:value-of select="race1500m"/></td>
	</tr>
</xsl:template>

</xsl:stylesheet>