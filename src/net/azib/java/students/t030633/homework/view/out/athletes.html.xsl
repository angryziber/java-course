<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html" indent="yes" />

	<!-- Athlete transformation from XML to HTML -->

	<xsl:template match="/">
		<html>
			<head><meta http-equiv="content-type" content="text/html; charset=UTF-8"></meta><title>Athletes</title></head>
			<body>
				<h1>Athletes</h1>
				<xsl:apply-templates select="//athlete"/>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="athlete">
		<h2>#<xsl:value-of select="place" /><xsl:text> </xsl:text><xsl:value-of select="name" /> (<xsl:value-of select="country" />)</h2>
		<p>Birth date: <xsl:apply-templates select="birthdate" /></p>
		<p>Total score: <xsl:value-of select="score" /></p>
		<table border="1">
			<tr bgcolor="#9acd32"><th>Event</th><th>Performance</th></tr>
			<tr><xsl:apply-templates select="results/result" /></tr>
		</table>
	</xsl:template>

	<xsl:template match="result">
		<tr>
			<td><xsl:value-of select="event" /></td>
			<td><xsl:value-of select="performance" /></td>
		</tr>
	</xsl:template>
	
	<!-- Select local date format -->
	<xsl:template match="birthdate">
		<xsl:value-of select="@local" />
	</xsl:template>
	
</xsl:stylesheet>
