<?xml version="1.0" encoding='UTF-8'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:template match="/competition">
	<html>
	<body>
		<table>
		<xsl:apply-templates/>
		</table>
	</body>
	</html>
</xsl:template>

<xsl:template match="competitor">
	<tr>
	<td><b><xsl:value-of select="position"/>.</b></td>
	<td><b><xsl:value-of select="@name"/></b></td>
	<td><xsl:value-of select="@country"/></td>
	<td><b><xsl:value-of select="score"/></b></td>
	
	<td><xsl:value-of select="sprint100m"/></td>
	<td><xsl:value-of select="long_jump"/></td>
	<td><xsl:value-of select="shot_put"/></td>
	<td><xsl:value-of select="high_jump"/></td>
	<td><xsl:value-of select="sprint400m"/></td>
	<td><xsl:value-of select="hurdles"/></td>
	<td><xsl:value-of select="discus"/></td>
	<td><xsl:value-of select="pole_valt"/></td>
	<td><xsl:value-of select="javelin_throw"/></td>
	<td><xsl:value-of select="race1500m"/></td>
	</tr>
</xsl:template>

</xsl:stylesheet>
