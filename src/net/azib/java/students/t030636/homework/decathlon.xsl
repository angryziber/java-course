<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
	<html>
		<body>
		<h2>Results for the DECATHLON</h2>
		<table border="1">
		<tr bgcolor="#9acd32">
			<th>Place</th>
			<th>Points</th>
			<th>Name</th>
			<th>Country</th>
			<th>Date of birth</th>
			<th bgcolor="#6699FF">100m</th>
			<th bgcolor="#6699FF">Long jump</th>
			<th bgcolor="#6699FF">Shot put</th>
			<th bgcolor="#6699FF">High jump</th>
			<th bgcolor="#6699FF">400m</th>
			<th bgcolor="#6699FF">110m hurdles</th>
			<th bgcolor="#6699FF">Discus throw</th>
			<th bgcolor="#6699FF">Pole vault</th>
			<th bgcolor="#6699FF">Javelin throw</th>
			<th bgcolor="#6699FF">1500m</th>
		</tr>
		<xsl:for-each select="DECATHLON/DECATHLETE">
		<tr>
			<td align="center"><b><xsl:value-of select="PLACE"/></b></td>
			<td><xsl:value-of select="SCORE"/></td>
			<td><xsl:value-of select="@NAME"/></td>
			<td><xsl:value-of select="COUNTRY"/></td>
			<td><xsl:value-of select="DATEOFBIRTH"/></td>
			<td><xsl:value-of select="RESULTS/HUNDREDMETERS"/></td>
			<td><xsl:value-of select="RESULTS/LONGJUMP"/></td>
			<td><xsl:value-of select="RESULTS/SHOTPUT"/></td>
			<td><xsl:value-of select="RESULTS/HIGHJUMP"/></td>
			<td><xsl:value-of select="RESULTS/FOURHUNDREDMETERS"/></td>
			<td><xsl:value-of select="RESULTS/HUNDREDANDTENHURDLES"/></td>
			<td><xsl:value-of select="RESULTS/DISCUSTHROW"/></td>
			<td><xsl:value-of select="RESULTS/POLEVAULT"/></td>
			<td><xsl:value-of select="RESULTS/JAVELINTHROW"/></td>
			<td><xsl:value-of select="RESULTS/FINALRUN"/></td>
		</tr>
		</xsl:for-each>
		</table>
		</body>
	</html>
</xsl:template>

</xsl:stylesheet>