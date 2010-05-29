<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" standalone="yes" encoding="UTF-8" indent="yes"/>

<xsl:template match="/decathlonresults">
	<html><head><meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
	<title>Decathlon competition results</title>
	</head>
	<body>
		<h1>Decathlon competition results</h1><br/>
		<xsl:apply-templates/>
	</body>
	</html>
</xsl:template>

<xsl:template match="result">
	<p>
		<b>Place: <xsl:value-of select="place"/></b>
		Points: <xsl:value-of select="score"/>
		<br/>Name: <xsl:value-of select="athlete/name"/>
		<br/>Date of birth: <xsl:value-of select="athlete/dateofbirth"/>
		<br/>Country: <xsl:value-of select="athlete/country"/>
		<table><tr><td width="50"></td><td width="200"><b>Event</b></td><td width="200"><b>Performance</b></td></tr>
		<xsl:for-each select="performance/event">
			<tr><td></td><td><xsl:value-of select="@name"/></td><td><xsl:value-of select="."/></td></tr>
		</xsl:for-each>
		</table>
	</p>
</xsl:template>
</xsl:stylesheet>
