<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="Results">
<html>
<head>
<title>Results</title>
</head>
<body>
<table border="1">
<tr>
			<td>Name</td>
			<td>Country</td>
			<td>Born</td>
			<td>Sprint_100m</td>
			<td>Long_Jump</td>
			<td>Short_Put</td>
			<td>Hurdles</td>
			<td>Discus_Throw</td>
			<td>Pole_Vault</td>
			<td>Jevelin_Throw</td>
			<td>High_Jump</td>
			<td>Sprint_400m</td>
			<td>Race</td>
			<td>Total</td>
			</tr>
<xsl:for-each select="Athlete">
			<tr>
			<td><xsl:copy-of select="Name"/></td>
			<td><xsl:copy-of select="Country"/></td>
			<td><xsl:copy-of select="Born"/></td>
			<td><xsl:copy-of select="Sprint_100m"/></td>
			<td><xsl:copy-of select="Long_Jump"/></td>
			<td><xsl:copy-of select="Short_Put"/></td>
			<td><xsl:copy-of select="Hurdles"/></td>
			<td><xsl:copy-of select="Discus_Throw"/></td>
			<td><xsl:copy-of select="Pole_Vault"/></td>
			<td><xsl:copy-of select="Jevelin_Throw"/></td>
			<td><xsl:copy-of select="High_Jump"/></td>
			<td><xsl:copy-of select="Sprint_400m"/></td>
			<td><xsl:copy-of select="Race"/></td>
			<td><xsl:copy-of select="Total"/></td>
			</tr>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
