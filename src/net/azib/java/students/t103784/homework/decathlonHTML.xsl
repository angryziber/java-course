<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

<xsl:template match="/decathlon">
	<html>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<body>
			<table border="1">
				<xsl:apply-templates select="athlete"/>
			</table>
		</body>
	</html>
</xsl:template>

<xsl:template match="athlete">
	<tr>
	    <td><b><xsl:value-of select="name"/></b></td>
	    <td><b><xsl:value-of select="dateofbirth"/></b></td>
		<td><b><xsl:value-of select="country"/></b></td>
		<td><b><xsl:value-of select="hundredmeters"/></b></td>
		<td><b><xsl:value-of select="longjump"/></b></td>
		<td><b><xsl:value-of select="shotput"/></b></td>
		<td><b><xsl:value-of select="highjump"/></b></td>
		<td><b><xsl:value-of select="fourhundredmeters"/></b></td>
		<td><b><xsl:value-of select="hurdles"/></b></td>
		<td><b><xsl:value-of select="discus"/></b></td>
		<td><b><xsl:value-of select="polevault"/></b></td>
		<td><b><xsl:value-of select="javelin"/></b></td>
		<td><b><xsl:value-of select="race"/></b></td>
		<td><b><xsl:value-of select="score"/></b></td>
	</tr>
</xsl:template>

</xsl:stylesheet>
